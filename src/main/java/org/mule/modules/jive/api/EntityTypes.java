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

import static org.mule.modules.jive.CustomOp.AVATAR_DELETE;
import static org.mule.modules.jive.CustomOp.AVATAR_GET_AVATAR_BY_ID;
import static org.mule.modules.jive.CustomOp.BLOG_GET_BLOG_BY_ID;
import static org.mule.modules.jive.CustomOp.TASK_CREATE;
import static org.mule.modules.jive.api.EntityTypeBuilder.from;
import static org.mule.modules.jive.api.EntityTypeName.ADDRESSBOOK;
import static org.mule.modules.jive.api.EntityTypeName.AUDIT;
import static org.mule.modules.jive.api.EntityTypeName.AVATAR;
import static org.mule.modules.jive.api.EntityTypeName.BLOG;
import static org.mule.modules.jive.api.EntityTypeName.COMMENT;
import static org.mule.modules.jive.api.EntityTypeName.COMMUNITY;
import static org.mule.modules.jive.api.EntityTypeName.DOCUMENT;
import static org.mule.modules.jive.api.EntityTypeName.ENTITLEMENT;
import static org.mule.modules.jive.api.EntityTypeName.FORUM;
import static org.mule.modules.jive.api.EntityTypeName.GROUP;
import static org.mule.modules.jive.api.EntityTypeName.IMSERVICE;
import static org.mule.modules.jive.api.EntityTypeName.PLUGIN;
import static org.mule.modules.jive.api.EntityTypeName.POLL;
import static org.mule.modules.jive.api.EntityTypeName.PRIVATE_MESSAGE;
import static org.mule.modules.jive.api.EntityTypeName.PROFILE;
import static org.mule.modules.jive.api.EntityTypeName.PROFILE_FIELD;
import static org.mule.modules.jive.api.EntityTypeName.PROFILE_SEARCH;
import static org.mule.modules.jive.api.EntityTypeName.PROJECT;
import static org.mule.modules.jive.api.EntityTypeName.RATINGS;
import static org.mule.modules.jive.api.EntityTypeName.REFERENCE;
import static org.mule.modules.jive.api.EntityTypeName.SEARCH;
import static org.mule.modules.jive.api.EntityTypeName.SOCIAL_GROUP;
import static org.mule.modules.jive.api.EntityTypeName.STATUS_LEVEL;
import static org.mule.modules.jive.api.EntityTypeName.SYSTEM_PROPERTIES;
import static org.mule.modules.jive.api.EntityTypeName.TAG;
import static org.mule.modules.jive.api.EntityTypeName.TASK;
import static org.mule.modules.jive.api.EntityTypeName.USER;
import static org.mule.modules.jive.api.EntityTypeName.VIDEO;
import static org.mule.modules.jive.api.EntityTypeName.WATCH;

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
                .withGet(AVATAR_GET_AVATAR_BY_ID)
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
        registerType( from(PROFILE_SEARCH).build());
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
