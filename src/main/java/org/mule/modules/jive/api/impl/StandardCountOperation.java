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

import org.mule.modules.jive.api.EntityType;
import org.mule.modules.jive.api.JiveClient;
import org.mule.modules.jive.api.TypeOperation;
import org.mule.modules.jive.api.xml.XmlMapper;

/**Generic count operation*/
public class StandardCountOperation implements TypeOperation
{
    public static final TypeOperation STANDARD = new StandardCountOperation();

    @Override
    public Long execute(JiveClient resource, XmlMapper mapper, EntityType type)
    {
        return Long.parseLong(resource.doRequestAndExtractTagBetween(getUri(type), "GET", "return"));
    }

    protected String getUri(EntityType type)
    {
        return type.getBaseSingularUri() + "Count";
    }

}


