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

import org.mule.modules.jive.api.ReferenceOperation;
import org.mule.modules.jive.api.EntityType;
import org.mule.modules.jive.api.xml.XmlMapper;

import com.sun.jersey.api.client.WebResource;

import java.io.StringReader;
import java.util.Map;

public final class StandardDeleteOperation implements ReferenceOperation
{
    public static final ReferenceOperation STANDARD = new StandardDeleteOperation();
    
    @Override
    public Map<String, Object> execute(WebResource resource, XmlMapper mapper, EntityType type, String id)
    {
        final String response = resource.path(type.getCompleteUri(id)).delete(String.class);
        // validar error
        // is the response of a successful delete req always ""?
        return mapper.xml2map(new StringReader(response));
    }

}