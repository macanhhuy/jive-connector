/**
 * Mule Jive Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.jive.api;

import org.mule.modules.jive.api.xml.XmlMapper;

import java.util.Map;

/**
 * {@link PayloadOperation} that models a jive operation that sends a payload with the request
 */
public interface PayloadOperation
{
    Map<String, Object> execute(JiveClient resource, XmlMapper mapper, EntityType type, Map<String, Object> entityData);
}


