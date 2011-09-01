/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.jive;

import org.mule.modules.jive.api.CustomReferenceOperation;
import org.mule.modules.jive.api.EntityType;
import org.mule.modules.jive.api.EntityTypeBuilder;
import org.mule.modules.jive.api.PayloadOperation;
import org.mule.modules.jive.api.impl.StandardPayloadOperation;
import org.mule.modules.jive.api.xml.XmlMapper;
import org.mule.modules.jive.utils.ServiceUriFactory;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;

public final class CustomReferenceOperationImpl implements CustomReferenceOperation
{
    private CustomOp customOp;
    
    /**
     * @param customOp
     */
    private CustomReferenceOperationImpl(CustomOp customOp)
    {
        super();
        this.customOp = customOp;
    }


    @Override
    public Map<String, Object> execute(WebResource resource, XmlMapper mapper, EntityType type, String id)
    {

        final String response;
        final Builder partialRequest = resource.path( getCompleteUriForCustomOp(customOp, id))
            .type(MediaType.APPLICATION_FORM_URLENCODED)
            .header("content-type", "text/xml");
        if (customOp.getMethod().equals("GET"))
        {
            response = partialRequest.get(String.class);
        }
        else
        { // It's a DELETE request
            response = partialRequest.delete(String.class);
        }
        return mapper.xml2map(new StringReader(response));
    }
    
    /**Generates the complete uri for the get or delete {@link CustomOp}.
     * @param customType The {@link CustomOp} that is being executed
     * @param id A {@link String} containing the path parameters to add
     * @return The resouce uri with the path parameters added
     */
    private String getCompleteUriForCustomOp(final CustomOp customType,
                                             final String id) 
    {
        final StringBuilder completeUri = new StringBuilder();
        final String[] pathParams = StringUtils.split(id, ':');

        completeUri.append(ServiceUriFactory
            .generateCustomUri(customType));
        for (int i = 0; i < pathParams.length; i++) 
        {
            completeUri.append("/" + pathParams[i]);
        }
        return completeUri.toString();
    }
    
    public static CustomReferenceOperation from(CustomOp customOp)
    { 
        return new CustomReferenceOperationImpl(customOp);
    }
    
    /* (non-Javadoc)
     * @see org.mule.modules.jive.api.ReferenceOperation#execute(com.sun.jersey.api.client.WebResource, org.mule.modules.jive.api.xml.XmlMapper, org.mule.modules.jive.api.EntityType, java.util.Map)
     */
    @Override
    public Map<String, Object> execute(WebResource resource,
                                       XmlMapper mapper,
                                       EntityTypeBuilder type,
                                       Map<String, Object> entityData)
    {
        final Writer writer = new StringWriter();
        mapper.map2xml(type.getXmlRootElementName(), entityData, writer);
        final String response = resource.path(type.getServiceUri()).post(String.class, writer.toString());
        // validar error
        return mapper.xml2map(new StringReader(response));
    }

}

