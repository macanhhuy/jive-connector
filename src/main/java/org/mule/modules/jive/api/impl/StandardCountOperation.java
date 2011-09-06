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
import org.mule.modules.jive.api.TypeOperation;
import org.mule.modules.jive.api.xml.XmlMapper;

import com.sun.jersey.api.client.WebResource;

import java.io.StringReader;
import java.util.Map;

public class StandardCountOperation implements TypeOperation
{
    public static final TypeOperation STANDARD = new StandardCountOperation();

    /* (non-Javadoc)
     * @see org.mule.modules.jive.api.ReferenceOperation#execute(com.sun.jersey.api.client.WebResource, org.mule.modules.jive.api.xml.XmlMapper, org.mule.modules.jive.api.EntityType, java.lang.String)
     */
    @Override
    public Map<String, Object> execute(WebResource resource, XmlMapper mapper, EntityType type)
    {
        final String response = resource.path(getUri(type)).get(String.class);
        return mapper.xml2map(new StringReader(response));
//      String response = this.gateway.path(ServiceUriFactory.generateBaseUri(type))
//      .get(String.class);
//  return Long.parseLong(StringUtils.substringBetween(
//      response, "<return>", "</return>"));
    }

    protected String getUri(EntityType type)
    {
        return type.getBaseSingularUri() + "Count";
    }

}


