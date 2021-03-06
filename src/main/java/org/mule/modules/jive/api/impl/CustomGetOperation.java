/**
 * Mule Jive Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.jive.api.impl;

import org.mule.modules.jive.CustomOp;
import org.mule.modules.jive.api.EntityType;
import org.mule.modules.jive.api.JiveClient;
import org.mule.modules.jive.api.JiveUris;
import org.mule.modules.jive.api.ReferenceOperation;
import org.mule.modules.jive.api.xml.XmlMapper;

import java.util.Map;

import org.apache.commons.lang.Validate;

/**{@link ReferenceOperation} with custom properties for the get method*/
public final class CustomGetOperation implements ReferenceOperation
{
    /**The {@link CustomOp} that holds the custom properties*/
    private CustomOp customOp;
    
    /**
     * @param customOp The {@link CustomOp} for this {@link CustomGetOperation}
     */
    public CustomGetOperation(CustomOp customOp)
    {
        super();
        this.customOp = customOp;
    }

    @Override
    public Map<String, Object> execute(JiveClient resource, XmlMapper mapper, EntityType type, String id)
    {
        Validate.isTrue(customOp.getMethod().equals("GET"), "Get requests should be always based on a HTTP GET method");
        
        return resource.doRequest(customOp.getBaseOperationUri(), customOp.getMethod(), id);
    }
    
    /**Generates the complete uri for the get or delete {@link CustomOp}.
     * @param customType The {@link CustomOp} that is being executed
     * @param id A {@link String} containing the path parameters to add
     * @return The resouce uri with the path parameters added
     */
    protected String getCompleteUriForCustomOp(final CustomOp customType,
                                             final String id) 
    {
        return  JiveUris.getOperationUri(customType.getBaseOperationUri(), id);
    }
    
    public static ReferenceOperation from(CustomOp customOp)
    { 
        return new CustomGetOperation(customOp);
    }
    

}

