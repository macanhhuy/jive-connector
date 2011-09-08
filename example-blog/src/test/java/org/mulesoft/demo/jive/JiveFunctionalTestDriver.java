/**
 * Mule Zuora Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mulesoft.demo.jive;

import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.transport.PropertyScope;
import org.mule.construct.Flow;
import org.mule.tck.FunctionalTestCase;

public class JiveFunctionalTestDriver extends FunctionalTestCase
{

    @Override
    protected String getConfigResources()
    {
        return "mule-config.xml";
    }

    public void testCreateAccount() throws Exception
    {
        System.out.println(lookupFlowConstruct("CreateAccount").process(getTestEvent("")).getMessage().getPayload());
    }
    
    public void testSearch() throws Exception
    {
        MuleEvent process = lookupFlowConstruct("GetAccounts").process(getTestEvent(""));
        System.out.println(process.getMessage().getPayload());
    }

    private Flow lookupFlowConstruct(final String name)
    {
        return (Flow) muleContext.getRegistry().lookupFlowConstruct(name);
    }

}
