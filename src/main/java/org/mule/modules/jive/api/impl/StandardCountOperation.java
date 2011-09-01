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

import org.mule.modules.jive.api.EntityType;
import org.mule.modules.jive.api.ReferenceOperation;
import org.mule.modules.jive.api.xml.XmlMapper;

import com.sun.jersey.api.client.WebResource;

import java.io.StringReader;
import java.util.Map;

public class StandardCountOperation implements ReferenceOperation
{
    public static final ReferenceOperation STANDARD = new StandardCountOperation();

    /* (non-Javadoc)
     * @see org.mule.modules.jive.api.ReferenceOperation#execute(com.sun.jersey.api.client.WebResource, org.mule.modules.jive.api.xml.XmlMapper, org.mule.modules.jive.api.EntityType, java.lang.String)
     */
    @Override
    public Map<String, Object> execute(WebResource resource, XmlMapper mapper, EntityType type, String id)
    {
        final String response = resource.path(type.getCompleteUri(id)).put(String.class);
        return mapper.xml2map(new StringReader(response));
    }

}


