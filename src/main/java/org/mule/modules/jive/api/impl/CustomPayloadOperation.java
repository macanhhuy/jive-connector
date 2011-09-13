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
import org.mule.modules.jive.api.PayloadOperation;
import org.mule.modules.jive.api.xml.XmlMapper;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**{@link PayloadOperation} with custom properties */
public class CustomPayloadOperation implements PayloadOperation
{
    /**The {@link CustomOp} with the custom properties for this {@link PayloadOperation}*/
    private final CustomOp customOp;

    /**
     * @param customOp The {@link CustomOp} for this {@link PayloadOperation}
     */
    public CustomPayloadOperation (CustomOp customOp) 
    {
        this.customOp = customOp;
    }

    /* (non-Javadoc)
     * @see org.mule.modules.jive.api.PayloadOperation#execute(com.sun.jersey.api.client.JiveClient, org.mule.modules.jive.api.xml.XmlMapper, org.mule.modules.jive.api.EntityType, java.util.Map)
     */
    @Override
    public Map<String, Object> execute(JiveClient resource,
                                       XmlMapper mapper,
                                       EntityType type,
                                       Map<String, Object> entityData)
    {
        final Writer writer = new StringWriter();
        mapper.map2xml(customOp.getRootTagElementName(), entityData, writer);
        return resource.doRequestWithPayload(customOp.getBaseOperationUri(), customOp.getMethod(), writer.toString());
    }
    


}


