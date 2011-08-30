package org.mule.modules.jive.api;

/**
 * Mule NetSuite Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.mule.modules.jive.JiveFacade;
import org.mule.modules.jive.JiveModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class JiveModuleAdaptor
{
    private static final Logger log = LoggerFactory.getLogger(JiveModule.class);

    private JiveModuleAdaptor()
    {
    }

    @SuppressWarnings("unchecked")
    public static JiveFacade getFacadeProxy(final JiveFacade client)
    {
        return (JiveFacade) Proxy.newProxyInstance(
            client.getClass().getClassLoader(), new Class[]{JiveFacade.class},
            new InvocationHandler()
            {
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
                {
                    if (log.isDebugEnabled())
                    {
                        log.debug("Entering into {} with args {}", method.getName(), args);
                    }
                    try
                    {
                        Object ret = invoke(method, client, args);
                        if (log.isDebugEnabled())
                        {
                            log.debug("Returning from {} with value {}", method.getName(), ret);
                        }
                        return ret;
                    }
                    catch (Throwable e)
                    {
                        log.warn("Throwing {} at {}", e, method.getName());
                        throw e;
                    }
                }

                private Object invoke(Method method, JiveFacade client, Object[] args) throws Throwable
                {
                	try
					{
					    return method.invoke(client, args);
					}
					catch (InvocationTargetException e)
					{
					    throw e.getCause();
					}
                }
            });
    }
}
