/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.jive.api.impl;

import org.mule.modules.jive.CustomOp;
import org.mule.modules.jive.api.EntityType;
import org.mule.modules.jive.api.JiveIds;
import org.mule.modules.jive.api.ReferenceOperation;
import org.mule.modules.jive.api.xml.XmlMapper;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

import java.io.StringReader;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;

public final class CustomGetOperation implements ReferenceOperation
{
    private CustomOp customOp;
    
    /**
     * @param customOp
     */
    public CustomGetOperation(CustomOp customOp)
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
        return  customType.getGenerateCustomUri() + "/" + JiveIds.toPathVariable(id);
    }
    
    public static ReferenceOperation from(CustomOp customOp)
    { 
        return new CustomGetOperation(customOp);
    }
    

}

