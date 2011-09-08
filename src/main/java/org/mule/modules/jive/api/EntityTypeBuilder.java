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

import org.mule.modules.jive.CustomOp;
import org.mule.modules.jive.api.impl.CustomDeleteOperation;
import org.mule.modules.jive.api.impl.CustomGetOperation;
import org.mule.modules.jive.api.impl.CustomPayloadOperation;
import org.mule.modules.jive.api.impl.StandardCountOperation;
import org.mule.modules.jive.api.impl.StandardCreateOperation;
import org.mule.modules.jive.api.impl.StandardDeleteOperation;
import org.mule.modules.jive.api.impl.StandardGetOperation;
import org.mule.modules.jive.api.impl.StandardPayloadOperation;

/**
 * Builder to hold all the crud operations.
 */
public class EntityTypeBuilder 
{
    private String serviceNameException = EntityTypes.DEFAULT_SERVICE_URI;
    private final EntityTypeName entityTypeName;
    
    private PayloadOperation createOp = StandardCreateOperation.STANDARD;
    private PayloadOperation putOp = StandardPayloadOperation.STANDARD;
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
     * Sets all the remaining operations.
     */
    public EntityType build()
    {
        return new EntityType(entityTypeName, serviceNameException, createOp,
                              deleteOp, getOp, putOp, countOp);
    }

    /**
     * @param deleteOp the deleteOp to set
     * @return 
     */
    public EntityTypeBuilder withDelete(ReferenceOperation deleteOp)
    {
        this.deleteOp = deleteOp;
        return this;
    }
    
    public EntityTypeBuilder withDelete(CustomOp customOp)
    {
        return withDelete(new CustomDeleteOperation(customOp));
    }
    
    
    public EntityTypeBuilder withCreate(PayloadOperation createOperation)
    {
        this.createOp =createOperation;
        return this;
    }
    
    public EntityTypeBuilder withCreate(CustomOp customOp)
    {
        return withCreate(new CustomPayloadOperation(customOp));
    }
    
    /**
     * @param getOp the getOp to set
     * @return 
     */
    public EntityTypeBuilder withGet(ReferenceOperation getOp)
    {
        this.getOp = getOp;
        return this;
    }
    
    public EntityTypeBuilder withGet(CustomOp getOp)
    {
        return withGet(new CustomGetOperation(getOp));
    }


    /**
     * @param updateOp the updateOp to set
     * @return 
     */
    public EntityTypeBuilder withPut(PayloadOperation updateOp)
    {
        this.putOp = updateOp;
        return this;
    }

    public static EntityTypeBuilder from(final EntityTypeName entityTypeName) 
    {
        return new EntityTypeBuilder(entityTypeName);
    }

    /**
     * @param serviceUri
     * @return
     */
    public EntityTypeBuilder withServiceUri(final String serviceUri)
    {
        this.serviceNameException = serviceUri;
        return this;
    }

    /**
     * @param countOperation the countOperation to set
     */
    public void withCount(TypeOperation countOperation)
    {
        this.countOp = countOperation;
    }
    
}