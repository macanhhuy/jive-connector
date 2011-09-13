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

import static org.mule.modules.jive.CustomOp.*;
import static org.mule.modules.jive.api.EntityTypeBuilder.*;
import static org.mule.modules.jive.api.EntityTypeName.*;

import org.mule.modules.jive.CustomOp;

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
    private static void registerType(EntityType entityType) 
    {
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
                .withCreate(AUDIT_EVENT)
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
                .withDelete(BLOG_DELETE)
                .build());
        
        /** Task service. */
        registerType( 
            from(TASK)
            .withCreate(TASK_CREATE)
            .withGet(TASK_GET_TASK_BY_ID)
            .withPut(TASK_UPDATE)
            .build());
        
        /** Comment service. */
        registerType(from(COMMENT)
            .build());
        /** Community service. */
        registerType( from(COMMUNITY).build());
        /** Document service. */
        registerType( from(DOCUMENT).build());
        /** Entitlement service. */
        registerType( from(ENTITLEMENT).build());
        /** Forum service. */
        registerType( from(FORUM).build());
        /** Group service. */
        registerType( from(GROUP)
            .withGet(GROUP_GET_GROUP)
            .withPut(GROUP_UPDATE_GROUP)
            .build());
        /** Intant Messages service. */
        registerType( from(IMSERVICE).build());
        /** Plugin service. */
        registerType( from(PLUGIN).build());
        /** Poll service. */
        registerType( from(POLL).build());
        /** Private message service. */
        registerType( from(PRIVATE_MESSAGE)
            .withGet(PRIVATE_MESSAGE_GET_MESSAGE)
            .withCount(PRIVATE_MESSAGE_GET_MESSAGE_COUNT)
            .withServiceUri("privateMessageService")
            .build());
        /** Profile field service. */
        registerType( from(PROFILE_FIELD)
            .withCreate(PROFILE_CREATE_PROFILE_FIELD)
            .withDelete(PROFILE_DELETE_PROFILE_FIELD)
            .withGet(PROFILE_GET_PROFILE_FIELD)
            .withPut(PROFILE_EDIT_PROFILE_FIELD)
            .withServiceUri("profileFieldService")
            .build());
        /** Profile search service. */
        registerType( from(EntityTypeName.PROFILE_SEARCH)
            .withServiceUri("profileSearchService")
            .build());
        /** Profile service. */
        registerType( from(PROFILE)
            .withCreate(PROFILE_ADD_PROFILE)
            .withPut(CustomOp.PROFILE_SET_PROFILE)
            .build());
        /** Project service. */
        registerType( from(PROJECT)
            .withCreate(PROJECT_CREATE)
            .withPut(PROJECT_UPDATE)
            .build());
        /** Ratings service. */
        registerType( from(RATINGS)
            .withCreate(RATINGS_CREATE_RATING)
            .build());
        /** Reference service. */
        registerType( from(REFERENCE).build());
        /** Search service. */
        registerType( from(SEARCH).build());
        /** Social group service. */
        registerType( from(SOCIAL_GROUP)
            .withGet(SOCIAL_GROUP_GET_SOCIAL_GROUP)
            .withServiceUri("socialGroupService")
            .build());
        /** Status level service. */
        registerType( from(STATUS_LEVEL)
            .withServiceUri("statusLevelService")
            .build());
        /** System properties service. */
        registerType( from(SYSTEM_PROPERTIES)
            .withServiceUri("systemPropertiesService")
            .build());
        /** Tags service. */
        registerType( from(TAG)
            .withGet(TAG_GET_TAG_BY_ID)
            .withDelete(TAG_REMOVE_TAG)
            .build());
        /** User service. */
        registerType( from(USER)
            .withCreate(USER_CREATE_USER)
            .withGet(USER_GET_USER)
            .withCount(USER_GET_USER_COUNT)
            .build());
        /** Video service. */
        registerType( from(VIDEO)
            .withCreate(VIDEO_CREATE_VIDEO)
            .withDelete(VIDEO_DELETE_VIDEO)
            .withGet(VIDEO_GET_VIDEO)
            .withPut(VIDEO_UPDATE_VIDEO)
            .build());
        /** Watch service. */
        registerType( from(WATCH).build());
    }

    public static EntityType fromName(EntityTypeName type)
    {
        return TYPES.get(type);
    }

}
