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
import org.mule.modules.jive.api.TypeOperation;
import org.mule.modules.jive.api.xml.XmlMapper;

import com.sun.jersey.api.client.WebResource;

import java.io.StringReader;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class StandardCountOperation implements TypeOperation
{
    public static final TypeOperation STANDARD = new StandardCountOperation();

    @Override
    public Long execute(WebResource resource, XmlMapper mapper, EntityType type)
    {
        final String response = resource.path(getUri(type)).get(String.class);
        return Long.parseLong(StringUtils.substringBetween(response, "<return>", "</return>"));
    }

    protected String getUri(EntityType type)
    {
        return type.getBaseSingularUri() + "Count";
    }

}


