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
import org.mule.modules.jive.api.ReferenceOperation;
import org.mule.modules.jive.api.xml.XmlMapper;

import java.util.Map;

/**{@link ReferenceOperation} with custom properties for the delete method*/
public class CustomDeleteOperation implements ReferenceOperation
{
    /**The custom operation that holds the custom properties for this {@link ReferenceOperation}*/
    private final CustomOp op;

    /**
     * @param op The {@link CustomOp} for this {@link ReferenceOperation}
     */
    public CustomDeleteOperation(final CustomOp op)
    {
        this.op = op;
    }

    @Override
    public Map<String, Object> execute(JiveClient resource, XmlMapper mapper, EntityType type, String id)
    {
        return resource.doRequest(op.getBaseOperationUri(), "DELETE", id);
    }

}
