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

public class CustomUpdateOperation implements PayloadOperation
{
    private final CustomOp op;

    public CustomUpdateOperation(final CustomOp op)
    {
        this.op = op;
    }

    @Override
    public Map<String, Object> execute(JiveClient resource, XmlMapper mapper, EntityType type, Map<String, Object> entity)
    {
        Writer writer = new StringWriter();
        mapper.map2xml(op.getRootTagElementName(), entity, writer);
        return resource.doRequestWithPayload(op.getBaseOperationUri(), "PUT", writer.toString());
    }

}
