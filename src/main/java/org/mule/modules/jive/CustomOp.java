/*
 * $Id$
 * ---------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.jive;

import org.apache.commons.lang.StringUtils;

/**Enum for the custom operations.*/
public enum CustomOp {

    /**Addressbook add user operation.*/
    ADDRESSBOOK_ADD_USER(Service.ADDRESSBOOK, "addressbooks"),
    /**Addressbook add users operation.*/
    ADDRESSBOOK_ADD_USERS(Service.ADDRESSBOOK, "bulk"),
    /**Addressbook remove user operation.*/
    ADDRESSBOOK_REMOVE_USER(Service.ADDRESSBOOK, "addressbooks"),
    /**Addressbook remove users operation.*/
    ADDRESSBOOK_REMOVE_USERS(Service.ADDRESSBOOK, "bulk"),
    /**Addressbook get roster operation.*/
    ADDRESSBOOK_GET_ROSTER(Service.ADDRESSBOOK, "addressbooks"),

    /**Adds a content type to the list of explicitly allowed types.*/
    ATTACHMENT_ADD_ALLOWED_TYPE(Service.ATTACHMENT, "allowedTypes"),
    /**Adds a content type to the list of explicitly disallowed types.*/
    ATTACHMENT_ADD_DISALLOWED_TYPE(Service.ATTACHMENT, "disallowedTypes"),
    /**Returns true if the specified content type is valid. This is based on the
     * current settings of the allowAllByDefault flag and the allowed and
     * disallowed types list.*/
    ATTACHMENT_IS_VALID_TYPE(Service.ATTACHMENT, "allowedTypes"),
    /**Removes a content type from the list of explicitly allowed types.
     * If the specified content type does not exist in the list, this method
     * does nothing.*/
    ATTACHMENT_REMOVE_ALLOWED_TYPE(Service.ATTACHMENT, "allowedTypes"),
    /**Removes a content type from the list of explicitly disallowed types.*/
    ATTACHMENT_REMOVE_DISALLOWED_TYPE(Service.ATTACHMENT, "disallowedTypes"),
    
    /**Returns a list of audit logs entries.*/
    AUDIT_GET_AUDIT_MESSAGES(Service.AUDIT, "audit"),
    
    /**Deletes an avatar from the system.*/
    AVATAR_DELETE(Service.AVATAR, "avatar"),
    /**Deletes an avatar from the system.*/
    AVATAR_GET_AVATAR_BY_ID(Service.AVATAR, "avatarByID"),
    /**Deletes an avatar from the system.*/
    AVATAR_GET_AVATARS(Service.AVATAR, "avatarsByUser"),
    /**Returns the maximum allowable height for an avatar image.*/
    AVATAR_GET_MAX_ALLOWABLE_HEIGHT(Service.AVATAR, "avatarMaxAllowableHeight"),
    /**Returns the maximum allowable width for an avatar image.*/
    AVATAR_GET_MAX_ALLOWABLE_WIDTH(Service.AVATAR, "avatarMaxAllowableWidth"),
    /**Returns true if the system should attempt to resize avatar images.*/
    AVATAR_IS_ALLOW_IMAGE_RESIZE(Service.AVATAR, "avatarAllowImageResize"),
    /**Set whether the system should attempt to resize avatar images.*/
    AVATAR_SET_ALLOW_IMAGE_RESIZE(Service.AVATAR, "avatarAllowImageResize"),
    /**Sets the maximum allowable height for an avatar image.*/
    AVATAR_SET_MAX_ALLOWABLE_HEIGHT(Service.AVATAR, "avatarMaxAllowableHeight"),
    /**Sets the maximum allowable width for an avatar image.*/
    AVATAR_SET_MAX_ALLOWABLE_WIDTH(Service.AVATAR, "avatarMaxAllowableWidth"),
    /**TODO*/
    BLOG_GET_BLOG_BY_ID(Service.BLOG, "blogsByID"),
    /**TODO*/
    TASK_CREATE(Service.TASK, "tasks");

    /**The service of this operation.*/
    private final Service serviceType;

    /**This operation uri.*/
    private final String opUri;

    /**The http protocol for this operation.*/
    private final String protocol;

    /**Contructor for the {@link CustomOp}.
     * @param type This op service
     * @param op The operation uri
     * */
    private CustomOp(final Service type, final String op) {
        this.opUri = op;
        this.serviceType = type;

        final String[] split = StringUtils.split(this.toString(), "_");
        if (split[1].equals("ADD")) {
            this.protocol = "POST";
        } else if (split[1].equals("REMOVE")) {
            this.protocol = "DELETE";
        } else if (split[1].equals("GET") || split[1].equals("IS")) {
            this.protocol = "GET";
        } else {
            this.protocol = "";
        }
    }

    /**
     * @return the serviceType
     */
    public Service getServiceType() {
        return serviceType;
    }
    
    /**
     * @return The root tag xml element name for this custom operation.
     */
    public final String getRootTagElementName() {
        final String[] split = StringUtils.split(this.toString(), '_');
        final StringBuffer res = new StringBuffer();
        res.append(split[1].toLowerCase());
        if(split.length > 2) {
            for(int i = 2; i < split.length; i++) {
                res.append(StringUtils.capitalize(split[i].toLowerCase()));
            }
        }
        return res.toString();
    }

    /**
     * @return the opUri
     */
    public String getOpUri() {
        return opUri;
    }

    /**
     * @return the http protocol for this operation
     */
    public String getProtocol() {
        return protocol;
    }

}


