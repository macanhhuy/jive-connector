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

import static org.mule.modules.jive.CustomOp.*;
import static org.mule.modules.jive.api.EntityTypeBuilder.*;
import static org.mule.modules.jive.api.EntityTypeName.*;

import java.util.EnumMap;
import java.util.Map;

public class EntityTypes
{
    /** Default strategy. */
    public static final String DEFAULT_SERVICE_URI = null;
    /** For operations that use the base uri. */
    public static final int BASE_URI = 1;
    
    
    private static final Map<EntityTypeName, EntityType> TYPES = new EnumMap<EntityTypeName, EntityType>(
        EntityTypeName.class);
    private static void registerType(EntityType entityType) {
        TYPES.put(entityType.getTypeName(), entityType);
    }
    
    static {
        /** Addressbook service. */
        registerType( 
             from(ADDRESSBOOK)
            .withServiceUri("addressBookService")
            .build());
        
        /** Audit service. */
        registerType( 
                from(AUDIT)
                .build());
        
        /** Avatar service. */
        registerType( 
                from(AVATAR)
                .withGet(AVATAR_GET)
                .withDelete(AVATAR_DELETE)
                .build());
        
        /** Blog service. */
        registerType( 
                from(BLOG)
                .withGet(BLOG_GET_BLOG_BY_ID)
                .build());
        
        /** Task service. */
        registerType( 
            from(TASK)
            .withCreate(TASK_CREATE)
            .build());
        
        /** Comment service. */
        registerType(from(COMMENT).build());
        /** Community service. */
        registerType( from(COMMUNITY).build());
        /** Document service. */
        registerType( from(DOCUMENT).build());
        /** Entitlement service. */
        registerType( from(ENTITLEMENT).build());
        /** Forum service. */
        registerType( from(FORUM).build());
        /** Group service. */
        registerType( from(GROUP).build());
        /** Intant Messages service. */
        registerType( from(IMSERVICE).build());
        /** Plugin service. */
        registerType( from(PLUGIN).build());
        /** Poll service. */
        registerType( from(POLL).build());
        /** Private message service. */
        registerType( from(PRIVATE_MESSAGE).build());
        /** Profile field service. */
        registerType( from(PROFILE_FIELD).build());
        /** Profile search service. */
        registerType( from(EntityTypeName.PROFILE_SEARCH).build());
        /** Profile service. */
        registerType( from(PROFILE).build());
        /** Project service. */
        registerType( from(PROJECT).build());
        /** Ratings service. */
        registerType( from(RATINGS).build());
        /** Reference service. */
        registerType( from(REFERENCE).build());
        /** Search service. */
        registerType( from(SEARCH).build());
        /** Social group service. */
        registerType( from(SOCIAL_GROUP).build());
        /** Status level service. */
        registerType( from(STATUS_LEVEL).build());
        /** System properties service. */
        registerType( from(SYSTEM_PROPERTIES).build());
        /** Tags service. */
        registerType( from(TAG).build());
        /** User service. */
        registerType( from(USER).build());
        /** Video service. */
        registerType( from(VIDEO).build());
        /** Watch service. */
        registerType( from(WATCH).build());
    }

    public static EntityType fromName(EntityTypeName type)
    {
        return TYPES.get(type);
    }

}
