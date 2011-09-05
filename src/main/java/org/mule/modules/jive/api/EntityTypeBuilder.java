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

import org.mule.modules.jive.api.impl.StandardCountOperation;
import org.mule.modules.jive.api.impl.StandardCreateOperation;
import org.mule.modules.jive.api.impl.StandardDeleteOperation;
import org.mule.modules.jive.api.impl.StandardGetAllOperation;
import org.mule.modules.jive.api.impl.StandardGetOperation;
import org.mule.modules.jive.api.impl.StandardPayloadOperation;

/**
 * Builder to hold all the crud operations.
 */
public class EntityTypeBuilder 
{
    private String serviceNameException = EntityTypes.DEFAULT_SERVICE_URI;
    private final String entityType;
    
    private PayloadOperation createOp = StandardCreateOperation.STANDARD;
    private PayloadOperation putOp = StandardPayloadOperation.STANDARD;
    private ReferenceOperation deleteOp = StandardDeleteOperation.STANDARD;
    private ReferenceOperation getOp = StandardGetOperation.STANDARD;
    private ReferenceOperation getAllOp = StandardGetAllOperation.STANDARD;
    private ReferenceOperation countOp = StandardCountOperation.STANDARD;

    
    /**
     * Base constructor.
     */
    public EntityTypeBuilder(String entityType)
    {
        this.entityType = entityType;
    }
    
    /**
     * @param string
     */
    public EntityTypeBuilder(String entityType, String serviceNameException)
    {
        this(entityType);
        this.serviceNameException = serviceNameException;
    }
    
    /**
     * Sets all the remaining operations.
     */
    public EntityType build()
    {
        return new EntityType(entityType, serviceNameException, createOp,
                              deleteOp, getOp, getAllOp, putOp, countOp);
    }

    /**
     * @param deleteOp the deleteOp to set
     * @return 
     */
    public EntityTypeBuilder addCustomDeleteOp(ReferenceOperation deleteOp)
    {
        this.deleteOp = deleteOp;
        return this;
    }

    /**
     * @param getOp the getOp to set
     * @return 
     */
    public EntityTypeBuilder addCustomGetOp(ReferenceOperation getOp)
    {
        this.getOp = getOp;
        return this;
    }

    /**
     * @param getAllOp the getAllOp to set
     * @return 
     */
    public EntityTypeBuilder addCustomGetAllOp(ReferenceOperation getAllOp)
    {
        this.getAllOp = getAllOp;
        return this;
    }

    /**
     * @param updateOp the updateOp to set
     * @return 
     */
    public EntityTypeBuilder addCustomPutOp(PayloadOperation updateOp)
    {
        this.putOp = updateOp;
        return this;
    }

    public static EntityTypeBuilder from(final String entityTypeName) 
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
    public void addCustomCountOperation(ReferenceOperation countOperation)
    {
        this.countOp = countOperation;
    }
    
}