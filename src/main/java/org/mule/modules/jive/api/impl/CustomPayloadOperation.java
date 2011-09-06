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
import org.mule.modules.jive.api.PayloadOperation;
import org.mule.modules.jive.api.xml.XmlMapper;

import com.sun.jersey.api.client.WebResource;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class CustomPayloadOperation implements PayloadOperation
{
    private final CustomOp customOp;

    public CustomPayloadOperation (CustomOp customOp) 
    {
        this.customOp = customOp;
    }

    /* (non-Javadoc)
     * @see org.mule.modules.jive.api.PayloadOperation#execute(com.sun.jersey.api.client.WebResource, org.mule.modules.jive.api.xml.XmlMapper, org.mule.modules.jive.api.EntityType, java.util.Map)
     */
    @Override
    public Map<String, Object> execute(WebResource resource,
                                       XmlMapper mapper,
                                       EntityType type,
                                       Map<String, Object> entityData)
    {
        final Writer writer = new StringWriter();
        mapper.map2xml(customOp.getRootTagElementName(), entityData, writer);
        final String response = resource.path(customOp.getBaseOperationUri()).post(String.class, writer.toString());
        // validar error
        return mapper.xml2map(new StringReader(response));
    }
    


}


