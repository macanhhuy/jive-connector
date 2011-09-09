/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.jive.api;

import org.mule.modules.jive.api.xml.XmlMapper;

/**
 * {@link TypeOperation} models a Jive operation that takes just a type as argument
 * 
 * @author flbulgarelli
 */
public interface TypeOperation
{
    Long execute(JiveClient resource, XmlMapper mapper, EntityType type);
}
