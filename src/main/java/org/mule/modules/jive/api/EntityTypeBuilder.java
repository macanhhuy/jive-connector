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

import org.mule.modules.jive.api.impl.StandardDeleteOperation;
import org.mule.modules.jive.api.impl.StandardPayloadOperation;


/**
 * Builder to hold all the crud operations.
 */
public class EntityTypeBuilder 
{
    private PayloadOperation payloadOp;
    private ReferenceOperation deleteOp;
    private ReferenceOperation getOp;
    private ReferenceOperation getAllOp;
    private PayloadOperation updateOp;

    
    /**
     * Base constructor.
     */
    public EntityTypeBuilder()
    {
    }
    
    /**
     * Sets all the remaining operations.
     */
    public void build()
    {
        if (this.payloadOp == null) 
        {
            this.payloadOp = new StandardPayloadOperation();
        }
        else if (this.deleteOp == null) 
        {
            this.deleteOp = new StandardDeleteOperation();
        }
        else if (this.updateOp == null) 
        {
            this.updateOp = new StandardPutOperation();
        }
        else if (this.getOp == null) 
        {
            this.getOp = new StandardGetOperation();
        }
        else if (this.getAllOp == null) 
        {
            this.getAllOp = new StandardGetAllOperation();
        }
    }

    /**
     * @return the payloadOp
     */
    public PayloadOperation getPayloadOp()
    {
        return payloadOp;
    }

    /**
     * @param payloadOp the payloadOp to set
     */
    public void setPayloadOp(PayloadOperation payloadOp)
    {
        this.payloadOp = payloadOp;
    }

    /**
     * @return the deleteOp
     */
    public ReferenceOperation getDeleteOp()
    {
        return deleteOp;
    }

    /**
     * @param deleteOp the deleteOp to set
     */
    public void setDeleteOp(ReferenceOperation deleteOp)
    {
        this.deleteOp = deleteOp;
    }

    /**
     * @return the getOp
     */
    public ReferenceOperation getGetOp()
    {
        return getOp;
    }

    /**
     * @param getOp the getOp to set
     */
    public void setGetOp(ReferenceOperation getOp)
    {
        this.getOp = getOp;
    }

    /**
     * @return the getAllOp
     */
    public ReferenceOperation getGetAllOp()
    {
        return getAllOp;
    }

    /**
     * @param getAllOp the getAllOp to set
     */
    public void setGetAllOp(ReferenceOperation getAllOp)
    {
        this.getAllOp = getAllOp;
    }

    /**
     * @return the updateOp
     */
    public PayloadOperation getUpdateOp()
    {
        return updateOp;
    }

    /**
     * @param updateOp the updateOp to set
     */
    public void setUpdateOp(PayloadOperation updateOp)
    {
        this.updateOp = updateOp;
    }

}


