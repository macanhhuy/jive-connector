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

import org.mule.modules.jive.api.impl.StandardDeleteOperation;
import org.mule.modules.jive.api.impl.StandardPayloadOperation;
import org.mule.modules.jive.api.xml.XmlMapper;
import org.mule.modules.jive.utils.ServiceUriFactory;

import com.sun.jersey.api.client.WebResource;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

/** Services enum. */
public enum EntityType
{

    /** Addressbook service. */
    ADDRESSBOOK("addressBookService"),
    /** Audit service. */
    AUDIT(),
    /** Avatar service. */
    AVATAR(),
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

    /** Holds the service name. */
    private final String serviceUri;

    private final ReferenceOperation deleteOperation;
    private final PayloadOperation createOperation;

    /**
     * Constructor base
     */
    private EntityType()
    {
        this(EntityTypes.DEFAULT_SERVICE_URI);
    }

    /**
     * Constructor for the services with name exceptions.
     * 
     * @param serviceNameException The service name for this entity
     */
    private EntityType(final String serviceNameException)
    {
        this(serviceNameException, StandardDeleteOperation.STANDARD,
            StandardPayloadOperation.STANDARD);
    }

    /**
     * @param serviceUri
     * @param strategy
     * @param deleteOperation
     * @param extraTag
     */
    private EntityType(String serviceUri,
                       ReferenceOperation deleteOperation,
                       PayloadOperation createOperation)
    {
        this.serviceUri = serviceUri;
        this.deleteOperation = deleteOperation;
        this.createOperation = createOperation;
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
        return "/" + serviceUri;
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

    /**
     * Generates the complete uri for the get or delete service.
     * 
     * @param this The {@link EntityType} that is being executed
     * @param id A {@link String} containing the path parameters to add
     * @return The resouce uri with the path parameters added
     */
    public String getCompleteUri(final String id)
    {
        final StringBuffer completeUri = new StringBuffer();
        final String[] pathParams = StringUtils.split(id, ':');

        completeUri.append(ServiceUriFactory.generateBaseUri(this));
        for (int i = 0; i < pathParams.length; i++)
        {
            completeUri.append("/" + pathParams[i]);
        }
        return completeUri.toString();
    }

    /**
     * @param type
     * @param entity
     * @param mapper 
     * @param resource 
     * @return
     */
    public Map<String, Object> create(final EntityType type, final Map<String, Object> entity,
        final XmlMapper mapper, final WebResource resource)
    {
        return createOperation.execute(resource, mapper, type, entity);
    }
    
    /**
     * 
     */
    public final String generateBaseUri()
    {
        final StringBuilder uri = new StringBuilder(getServiceUri() + "/");
        uri.append(pluralize(toString().toLowerCase()));
        return uri.toString();
    }
    
    /**Pluralizes the service name.
     * @param str The {@link String} to pluralize
     * @return str in plural*/
    private static String pluralize(final String str) {
        if (str.endsWith("y")) {
            return StringUtils.substringBeforeLast(str, "y") + "ies";
        }
        return str + "s";
    }

}
