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

import static org.junit.Assert.*;

import org.mule.modules.jive.api.EntityTypeName;
import org.mule.modules.jive.api.EntityTypes;

import org.junit.Test;

/**
 * {@link StandardCountOperationUnitTest}
 * 
 * @author flbulgarelli
 */
public class StandardCountOperationUnitTest
{

    @Test
    public void testGenerateUri() throws Exception
    {
        assertEquals("/blogService/blogCount",
            ((StandardCountOperation) StandardCountOperation.STANDARD).getUri(EntityTypes.fromName(EntityTypeName.BLOG)));
    }
}

