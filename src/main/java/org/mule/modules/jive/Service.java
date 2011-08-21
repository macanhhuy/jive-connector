/*
 * $Id$
 * ---------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.jive;

import org.apache.commons.lang.StringUtils;


/**Services enum.*/
public enum Service {
    
    /**Addressbook service.*/
    ADDRESSBOOK("addressBookService"),
    /**Attachment service.*/
    ATTACHMENT(),
    /**Audit service.*/
    AUDIT(Service.SINGULAR),
    /**Avatar service.*/
    AVATAR(),
    /**Blog service.*/
    BLOG(),
    TASK;

    /**Const for the services that uses their name in plural.*/
    public static final int PLURAL = 0;
    
    /**Const for the services that uses their name in singular.*/
    public static final int SINGULAR = 1;
    
    /**Default strategy.*/
    private static final int DEFAULT_STRATEGY = Service.PLURAL;
    
    /**Holds the service name.*/
    private final String serviceUri;
    
    /**Strategy.*/
    private final int strategy;

    /**If true, the request of this service has an extra tag with the entity
     * name.*/
    private boolean extraTag = false;

    /**Base Constructor.*/
    private Service() {
        this.strategy = Service.DEFAULT_STRATEGY;
        this.serviceUri = "/" + getServiceName();
    }
    
    /**Constructor for the services with a specified strategy.
     * @param strategy The strategy for the uri formation of this service*/
    private Service(final int strategy) {
        this.strategy = strategy;
        this.serviceUri = "/" + getServiceName();
    }

    /**Constructor for the services with name exceptions.
     * @param serviceNameException The service name for this entity*/
    private Service(final String serviceNameException) {
        this.strategy = Service.DEFAULT_STRATEGY;
        this.serviceUri = "/" + serviceNameException;
    }

    /**@return the service name retrieved from the enum name.
     * */
    private String getServiceName() {
        return this.toString().toLowerCase() + "Service";
    }
    
    /**@return the rootElement of the xml request
     * */
    public final String getXmlRootElementName() {
        return StringUtils.capitalize(this.toString().toLowerCase());
    }

    /**
     * @return the serviceUri
     */
    public String getServiceUri() {
        return serviceUri;
    }

    /**
     * @return the strategy
     */
    public int getStrategy() {
        return strategy;
    }

    /**
     * @param extraTag the extraTag to set
     */
    public void setExtraTag(final boolean extraTag) {
        this.extraTag = extraTag;
    }

    /**
     * @return the extraTag
     */
    public boolean hasExtraTag() {
        return extraTag;
    }
}


