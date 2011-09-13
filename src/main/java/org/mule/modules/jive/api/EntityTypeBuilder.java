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

import org.mule.modules.jive.CustomOp;
import org.mule.modules.jive.api.impl.CustomDeleteOperation;
import org.mule.modules.jive.api.impl.CustomGetOperation;
import org.mule.modules.jive.api.impl.CustomPayloadOperation;
import org.mule.modules.jive.api.impl.CustomTypeOperation;
import org.mule.modules.jive.api.impl.CustomUpdateOperation;
import org.mule.modules.jive.api.impl.StandardCountOperation;
import org.mule.modules.jive.api.impl.StandardCreateOperation;
import org.mule.modules.jive.api.impl.StandardDeleteOperation;
import org.mule.modules.jive.api.impl.StandardGetOperation;
import org.mule.modules.jive.api.impl.StandardPostOperation;

/**
 * Builder for the {@link EntityType}
 */
public class EntityTypeBuilder 
{
    private String serviceNameException = EntityTypes.DEFAULT_SERVICE_URI;
    private final EntityTypeName entityTypeName;
    
    private PayloadOperation createOp = StandardCreateOperation.STANDARD;
    private PayloadOperation putOp = StandardPostOperation.STANDARD;
    private ReferenceOperation deleteOp = StandardDeleteOperation.STANDARD;
    private ReferenceOperation getOp = StandardGetOperation.STANDARD;
    private TypeOperation countOp = StandardCountOperation.STANDARD;

    /**
     * Base constructor.
     */
    public EntityTypeBuilder(EntityTypeName entityTypeName)
    {
        this.entityTypeName = entityTypeName;
    }
    
    /**
     * Builds the {@link EntityType} with all the associated methods.
     */
    public EntityType build()
    {
        return new EntityType(entityTypeName, serviceNameException, createOp,
                              deleteOp, getOp, putOp, countOp);
    }

    /**
     * Sets the delete operation.  
     */
    private EntityTypeBuilder withDelete(ReferenceOperation deleteOp)
    {
        this.deleteOp = deleteOp;
        return this;
    }
    
    /**
     * @param customOp The custom delete operation to set this entity with
     * @return The {@link EntityTypeBuilder} with the custom delete operation setted up
     */
    public EntityTypeBuilder withDelete(CustomOp customOp)
    {
        return withDelete(new CustomDeleteOperation(customOp));
    }
    
    
    /**
     * Sets the create operation
     */
    private EntityTypeBuilder withCreate(PayloadOperation createOperation)
    {
        this.createOp = createOperation;
        return this;
    }
    
    /**
     * @param createOperation The createOperation for the {@link EntityType}
     * @return The {@link EntityTypeBuilder} with the create operation setted up
     */
    public EntityTypeBuilder withCreate(CustomOp customOp)
    {
        return withCreate(new CustomPayloadOperation(customOp));
    }
    
    /**
     * Sets the get method
     */
    private EntityTypeBuilder withGet(ReferenceOperation getOp)
    {
        this.getOp = getOp;
        return this;
    }
    
    /**
     * @param getOp The get operation fot the {@link EntityType}
     * @return The {@link EntityTypeBuilder} with the get operation setted up
     */
    public EntityTypeBuilder withGet(CustomOp getOp)
    {
        return withGet(new CustomGetOperation(getOp));
    }


    /**
     * Sets the update method for the {@link EntityType}
     */
    private EntityTypeBuilder withPut(PayloadOperation updateOp)
    {
        this.putOp = updateOp;
        return this;
    }
    
    /**
     * @param custom The custom update operation for the {@link EntityType}
     * @return The {@link EntityTypeBuilder} with the update operation setted up
     */
    public EntityTypeBuilder withPut(final CustomOp custom)
    {
        return withPut(new CustomUpdateOperation(custom));
    }

    /**
     * @param entityTypeName the {@link EntityTypeName} for the {@link EntityType} to be build
     * @return The {@link EntityTypeBuilder} with the {@link EntityTypeName} setted up
     */
    public static EntityTypeBuilder from(final EntityTypeName entityTypeName) 
    {
        return new EntityTypeBuilder(entityTypeName);
    }

    /**
     * @param serviceUri The service uri for the {@link EntityType} to be build
     * @return The {@link EntityTypeBuilder} with the service uri setted up
     */
    public EntityTypeBuilder withServiceUri(final String serviceUri)
    {
        this.serviceNameException = serviceUri;
        return this;
    }

    /**
     * Sets the count operation for the {@link EntityType} to be build
     */
    public EntityTypeBuilder withCount(TypeOperation countOperation)
    {
        this.countOp = countOperation;
        return this;
    }

    /**
     * @param op The custom count operation for the {@link EntityType} to be build
     * @return The {@link EntityTypeBuilder} with the custom count operation setted up
     */
    public EntityTypeBuilder withCount(CustomOp op)
    {
        return withCount(new CustomTypeOperation(op));
    }
    
}