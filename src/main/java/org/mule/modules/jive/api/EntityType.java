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

import com.sun.jersey.api.client.WebResource;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

public final class EntityType
{
    
    private String serviceUri;
    private ReferenceOperation deleteOperation;
    private PayloadOperation createOperation;
    private PayloadOperation putOperation;
    private EntityTypeName entityTypeName;
    private ReferenceOperation getOperation;
    private TypeOperation countOperation;

    /**
     * @param entityType
     * @param serviceNameException
     * @param createOp
     * @param deleteOp
     * @param getOp
     * @param getAllOp
     * @param putOp
     * @param countOp
     */
    public EntityType(EntityTypeName entityType,
                      String serviceNameException,
                      PayloadOperation createOp,
                      ReferenceOperation deleteOp,
                      ReferenceOperation getOp,
                      PayloadOperation putOp,
                      TypeOperation countOp)
    {
        this.entityTypeName = entityType;
        this.serviceUri = serviceNameException;
        this.createOperation = createOp;
        this.deleteOperation = deleteOp;
        this.getOperation = getOp;
        this.putOperation = putOp;
        this.countOperation = countOp;
    }

    /**
     * @return the rootElement of the xml request
     */
    public String getXmlRootElementName()
    {
        return entityTypeName.getXmlRootElementName();
    }

    /**
     * @return the serviceUri
     */
    protected String getTypeUri()
    {
        if (serviceUri == EntityTypes.DEFAULT_SERVICE_URI)
        {
            return "/" + entityTypeName.getServiceName();
        }
        return "/" + serviceUri;
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
     * @param type
     * @param id
     * @param mapper
     * @param resource
     * @return
     */
    public Map<String, Object> delete(final EntityType type, final String id,
        final XmlMapper mapper, final WebResource resource) 
    {
        return deleteOperation.execute(resource, mapper, type, id);
    }
    
    /**
     * @param type
     * @param id
     * @param mapper
     * @param resource
     * @return
     */
    public Long count(final EntityType type, final XmlMapper mapper, final WebResource resource)
    {
        return countOperation.execute(resource, mapper, type);
    }
    
    /**
     * @param type
     * @param id
     * @param mapper
     * @param resource
     * @return
     */
    public Map<String, Object> get(final String id,
        final XmlMapper mapper, final WebResource resource)
    {
        return getOperation.execute(resource, mapper, this, id);
    }
    
    /**
     * @param type
     * @param entityData
     * @param mapper
     * @param resource
     * @return
     */
    public Map<String, Object> put(final EntityType type, final Map<String, Object> entityData,
        final XmlMapper mapper, final WebResource resource)
    {
        return putOperation.execute(resource, mapper, type, entityData);
    }
    
    /**Generates the base uri for the service type given.
     * @return The service base uri. E.g. For the AVATAR service, the base
     * uri would be /avatarService/avatars
     * @param type The service
     * */
    public String getBasePluralUri()
    {
        return getTypeUri() + "/" + pluralize(entityTypeName.getNameAsString());
    }
    
    public String getBaseSingularUri()
    {
        return getTypeUri() + "/" + entityTypeName.getNameAsString();
    }
    
    /**Pluralizes the service name.
     * @param str The {@link String} to pluralize
     * @return str in plural*/
    private static String pluralize(final String str) 
    {
        if (str.endsWith("y")) 
        {
            return StringUtils.substringBeforeLast(str, "y") + "ies";
        }
        return str + "s";
    }

    public EntityTypeName getTypeName()
    {
        return entityTypeName;
    }
    
    

}
