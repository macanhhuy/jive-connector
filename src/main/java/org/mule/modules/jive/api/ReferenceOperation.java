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
 * Models a Jive Operation that may use path params but no payload
 * 
 * @author Pablo Diez
 */
public interface ReferenceOperation
{
    Map<String, Object> execute(JiveClient resource, XmlMapper mapper, EntityType type, String id);
}
