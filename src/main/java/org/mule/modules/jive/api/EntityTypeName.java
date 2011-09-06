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

import org.apache.commons.lang.StringUtils;

/** Services enum. */
public enum EntityTypeName
{
    /** Addressbook service. */
    ADDRESSBOOK,
    /** Audit service. */
    AUDIT,
    /** Avatar service. */
    AVATAR,
    /** Blog service. */
    BLOG,
    /** Task service. */
    TASK,
    /** Comment service. */
    COMMENT,
    /** Community service. */
    COMMUNITY,
    /** Document service. */
    DOCUMENT,
    /** Entitlement service. */
    ENTITLEMENT,
    /** Forum service. */
    FORUM,
    /** Group service. */
    GROUP,
    /** Intant Messages service. */
    IMSERVICE,
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

    public String getNameAsString()
    {
        return name().toLowerCase();
    }
    
    public String getServiceName()
    {
        return getNameAsString() + "Service";
    }

    public String getXmlRootElementName()
    {
        return StringUtils.capitalize(getNameAsString());
    }

}
