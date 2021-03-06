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
import org.mule.modules.jive.api.TypeOperation;
import org.mule.modules.jive.api.xml.XmlMapper;

/**{@link TypeOperation} with custom properties*/
public class CustomTypeOperation implements TypeOperation
{
    /**The {@link CustomOp} with the custom properties for this {@link TypeOperation}*/
    private final CustomOp op;
    
    /**
     * @param op The {@link CustomOp} for this {@link TypeOperation}
     */
    public CustomTypeOperation(final CustomOp op) 
    {
        this.op = op;
    }

    /* (non-Javadoc)
     * @see org.mule.modules.jive.api.TypeOperation#execute(org.mule.modules.jive.api.JiveClient, org.mule.modules.jive.api.xml.XmlMapper, org.mule.modules.jive.api.EntityType)
     */
    @Override
    public Long execute(JiveClient resource, XmlMapper mapper, EntityType type)
    {
        return Long.parseLong(resource.doRequestAndExtractTagBetween(op.getBaseOperationUri(), "GET", "return"));
    }

}


