/**
 * Mule Jive Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.jive.api;

import org.mule.modules.jive.api.xml.XmlMapper;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**Class that holds the {@link WebResource} and make the requests.*/
public class JiveClient
{
    /**The server response minimun acceptable status*/
    private static final int serverMinAcceptableStatus = 300;
    
    /**Mapper to parse the data from {@link Map} to xml and viceversa*/
    private final XmlMapper mapper = new XmlMapper();
    /**The jersey {@link WebResource} to perform the requests*/
    private final WebResource resource;
    
    /**
     * @param gateway 
     */
    public JiveClient(final WebResource gateway)
    {
        this.resource = gateway;
    }

    /**Executes a request sending the payload given
     * @param uri The resource uri to make the request
     * @param method The http method to use
     * @param payload The payload as xml
     * @return The response as a {@link Map}
     */
    public Map<String, Object> doRequestWithPayload(final String uri, final String method, final String payload) 
    {
        ClientResponse result = resource.path(uri).method(method, ClientResponse.class, payload);
        if (result.getStatus() > serverMinAcceptableStatus)
        {
            throw new JiveGenericException(StringUtils.substringAfterLast(
                StringUtils.substringBefore(result.getEntity(String.class), "</ns1:faultstring>"), ">"));
        }
        return mapper.xml2map(result.getEntity(String.class));
    }
    
    /**
     * @param uri The resource uri to make the request
     * @param method The http method to use
     * @param pathParams The path params to add to the resource uri separated by ':'
     * @return A {@link Map} with the server response
     */
    public Map<String, Object> doRequest(final String uri, final String method, final String pathParams)
    {
        ClientResponse result = resource.path(JiveUris.getOperationUri(uri, pathParams)).method(method, ClientResponse.class);
        if (result.getStatus() > serverMinAcceptableStatus)
        {
            throw new JiveGenericException(StringUtils.substringAfterLast(
                StringUtils.substringBefore(result.getEntity(String.class), "</ns1:faultstring>"), ">"));
        }
        return mapper.xml2map(result.getEntity(String.class));
    }

    /**Executes an operation and extract the response from the xml from the given tagName.
     * @param uri The resource uri to make the request
     * @param method The http method to use
     * @param tagName The tagName that holds the answer
     * @return
     */
    public String doRequestAndExtractTagBetween(final String uri, final String method, final String tagName)
    {
        final String response = resource.path(uri).method(method, String.class);
        return StringUtils.substringBetween(response, "<" + tagName + ">", "</" + tagName + ">");
    }
}


