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
import org.mule.modules.jive.api.ReferenceOperation;
import org.mule.modules.jive.api.xml.XmlMapper;

import java.util.Map;

/**Generic delete operation*/
public final class StandardDeleteOperation implements ReferenceOperation
{
    public static final ReferenceOperation STANDARD = new StandardDeleteOperation();
    
    @Override
    public Map<String, Object> execute(JiveClient resource, XmlMapper mapper, EntityType type, String id)
    {
        return resource.doRequest(type.getBasePluralUri(), "DELETE", id);
    }

}
