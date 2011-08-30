/*
 * $Id$
 * ---------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.jive.api;

import org.mule.modules.jive.CustomOp;
import org.mule.modules.jive.CustomReferenceOperation;
import org.mule.modules.jive.api.impl.StandardDeleteOperation;
import org.mule.modules.jive.api.xml.XmlMapper;
import org.mule.modules.jive.utils.ServiceUriFactory;

import com.sun.jersey.api.client.WebResource;

import java.io.StringReader;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/** Services enum. */
public enum EntityType {

    /** Addressbook service. */
    ADDRESSBOOK("addressBookService"),
    /** Attachment service. */
    ATTACHMENT(),
    /** Audit service. */
    AUDIT(EntityType.SINGULAR),
    /** Avatar service. */
    AVATAR(EntityTypes.DEFAULT_SERVICE_URI, 
            EntityTypes.DEFAULT_STRATEGY, 
            CustomReferenceOperation.from(CustomOp.AVATAR_DELETE)),
    /** Blog service. */
    BLOG(),
    /** Task service. */
    TASK,
    /** Comment service. */
    COMMENT(), 
    /** Community service. */
    COMMUNITY(), 
    /** Document service. */
    DOCUMENT(), 
    /** Entitlement service. */
    ENTITLEMENT(), 
    /** Forum service. */
    FORUM(), 
    /** Group service. */
    GROUP(), 
    /** Intant Messages service. */
    IMSERVICE(), 
    /** Plugin service. */
    PLUGIN, 
    /** Poll service. */
    POLL, 
    /** Private message service. */
    PRIVATE_MESSAGE, 
    /** Profile field service. */
    PROFILE_FIELD,
    /** Profile search service. */
    PROFILE_SEARCH, 
    /** Profile service. */
    PROFILE, 
    /** Project service. */
    PROJECT, 
    /** Ratings service. */
    RATINGS, 
    /** Reference service. */
    REFERENCE, 
    /** Search service. */
    SEARCH, 
    /** Social group service. */
    SOCIAL_GROUP, 
    /** Status level service. */
    STATUS_LEVEL, 
    /** System properties service. */
    SYSTEM_PROPERTIES, 
    /** Tags service. */
    TAG, 
    /** User service. */
    USER, 
    /** Video service. */
    VIDEO, 
    /** Watch service. */
    WATCH;

    /** Const for the services that uses their name in plural. */
    public static final int PLURAL = 0;

    /** Const for the services that uses their name in singular. */
    public static final int SINGULAR = 1;

    
    /** Holds the service name. */
    private final String serviceUri;

    /** Strategy. */
    private final int strategy;

    /**
     * If true, the request of this service has an extra tag with the entity name.
     */
    private boolean extraTag = false;
    
    private final ReferenceOperation deleteOperation;

    /** Base Constructor. */
    private EntityType()
    {
        this(EntityTypes.DEFAULT_STRATEGY);
    }

    /**
     * Constructor for the services with a specified strategy.
     * 
     * @param strategy The strategy for the uri formation of this service
     */
    private EntityType(final int strategy)
    {
        this(EntityTypes.DEFAULT_SERVICE_URI, strategy);
    }

    /**
     * @param serviceUri
     * @param strategy
     * @param extraTag
     * @param deleteOperation
     */
    private EntityType(String serviceUri, int strategy)
    {
        this(serviceUri, strategy, StandardDeleteOperation.STANDARD);
    }


    /**
     * Constructor for the services with name exceptions.
     * 
     * @param serviceNameException The service name for this entity
     */
    private EntityType(final String serviceNameException)
    {
        this("/" + serviceNameException, EntityTypes.DEFAULT_STRATEGY, StandardDeleteOperation.STANDARD);
    }
    
    /**
     * @param serviceUri
     * @param strategy
     * @param extraTag
     * @param deleteOperation
     */
    private EntityType(String serviceUri, int strategy, ReferenceOperation deleteOperation)
    {
        this(serviceUri, strategy, deleteOperation, false);
    }

    /**
     * @param serviceUri
     * @param strategy
     * @param deleteOperation
     * @param extraTag
     */
    private EntityType(String serviceUri, int strategy, ReferenceOperation deleteOperation, boolean extraTag)
    {
        this.serviceUri = serviceUri;
        this.strategy = strategy;
        this.extraTag = extraTag;
        this.deleteOperation = deleteOperation;
    }

    /**
     * @return the service name retrieved from the enum name.
     */
    private String getServiceName()
    {
        
        
        return this.toString().toLowerCase() + "Service";
    }

    /**
     * @return the rootElement of the xml request
     */
    public final String getXmlRootElementName()
    {
        return StringUtils.capitalize(this.toString().toLowerCase());
    }

    /**
     * @return the serviceUri
     */
    public String getServiceUri()
    {
        if (serviceUri == EntityTypes.DEFAULT_SERVICE_URI)
        {
            return "/" + getServiceName();
        }
        return serviceUri;
    }

    /**
     * @return the strategy
     */
    public int getStrategy()
    {
        return strategy;
    }

    /**
     * @param extraTag the extraTag to set
     */
    public void setExtraTag(final boolean extraTag)
    {
        this.extraTag = extraTag;
    }

    /**
     * @return the extraTag
     */
    public boolean hasExtraTag()
    {
        return extraTag;
    }

    /**
     * @param id
     * @param resource 
     * @param mapper 
     * @return
     */
    public Map<String, Object> delete(final String id, WebResource resource, XmlMapper mapper)
    {
        return deleteOperation.execute(resource, mapper, this, id);
    }

    /**Generates the complete uri for the get or delete service.
     * @param this The {@link EntityType} that is being executed
     * @param id A {@link String} containing the path parameters to add
     * @return The resouce uri with the path parameters added
     */
    public String getCompleteUri(final String id) {
        final StringBuffer completeUri = new StringBuffer();
        final String[] pathParams = StringUtils.split(id, ':');

        completeUri.append(ServiceUriFactory.generateBaseUri(this));
        for(int i = 0; i < pathParams.length; i++) {
            completeUri.append("/" + pathParams[i]);
        }
        return completeUri.toString();
    }

}
