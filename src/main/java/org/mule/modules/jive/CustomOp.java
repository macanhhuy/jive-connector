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
    /**Adds an attachment to the blog post with the specified ID.*/
    /**Adds an image to the blog post with the specified ID.*/
    BLOG_ADD_ATTACHMENT_TO_BLOG_POST(Service.BLOG, "attachments"),
    BLOG_ADD_IMAGE_TO_BLOG_POST(Service.BLOG, "images"),
    /**Permanently deletes a blog post and all of the comments
     * associated with the it.*/
    BLOG_DELETE_BLOG_POST(Service.BLOG, "blogPosts"),
    /**Permanently deletes a blog post and all of the comments
     * associated with the it.*/
    BLOG_GET_ATTACHMENTS_BY_POST_ID(Service.BLOG, "attachments"),
    /**Returns a blog by blog ID.*/
    BLOG_GET_BLOG_BY_ID(Service.BLOG, "blogsByID"),
    /**Returns a blog by blog name.*/
    BLOG_GET_BLOG_BY_NAME(Service.BLOG, "blogsByName"),
    /**Returns the total number of blogs on this system.*/
    BLOG_GET_BLOG_COUNT(Service.BLOG, "blogsCount"),
    /**Returns the total number of blogs on this system
     * that match the criteria specified by the ResultFilter.*/
    BLOG_GET_BLOG_COUNT_BY_RESULTFILTER(Service.BLOG, "blogsCount", "POST"),
    /**Returns the count of all blogs which are associated with the given user.*/
    BLOG_GET_BLOG_COUNT_FOR_USER(Service.BLOG, "userBlogCount"),
    /**Returns a blog by blog ID.*/
    BLOG_GET_BLOG_POST(Service.BLOG, "blogPosts"),
    /**Returns the number of blog posts on the system. The default blog
     * post result filter () only includes blog posts where status = and
     * publish date less than now().*/
    BLOG_GET_BLOG_POST_COUNT_BY_RESULTFILTER(Service.BLOG, "blogPosts", "POST"),
    /**Returns all the blog posts that match the criteria specified by the
     * BlogPostResultFilter on the entire system.*/
    BLOG_GET_BLOG_POST_BY_RESULTFILTER(Service.BLOG, "blogPostsWithFilter", "POST"),
    /**Returns all blogs which are associated with the given user.*/
    BLOG_GET_BLOG_FOR_USER(Service.BLOG, "userBlogs"),
    /**Returns the number of comments on blog posts that match
     * the criteria specified by the FeedbackResultFilter in the entire system.*/
    BLOG_GET_COMMENT_COUNT_WITH_FILTER(Service.BLOG, "commentCountWithFilter", "POST"),
    /**Returns all the comments on blog posts that match the criteria specified by
     * the FeedbackResultFilter in the entire system.*/
    BLOG_GET_COMMENTS_WITH_FILTER(Service.BLOG, "commentsWithFilter", "POST"),
    /**Returns an array of images that are attached to the specified blog post.*/
    BLOG_GET_IMAGES_BY_BLOG_POST_ID(Service.BLOG, "images"),
    /**Returns all tags for blogs in the system filtered by the
     * BlogTagResultFilter.*/
    BLOG_GET_TAGS(Service.BLOG, "tags","POST"),
    /**Removes the attachment with the supplied id as an attachment of a blog.
     * Only administrators or the creator of the blog are allowed to call this method.*/
    BLOG_REMOVE_ATTACHMENT(Service.BLOG, "attachments"),
    /**Uploads a new attachment to the blog post with the specified ID.*/
    BLOG_UPLOAD_ATTACHMENTS_TO_BLOG_POST(Service.BLOG, "attachmentUpload", "POST"),
    /**Uploads a new attachment to the blog post with the specified ID.*/
    BLOG_USER_HAS_BLOGS(Service.BLOG, "userHasBlogs", "GET"),
    /**TODO([a-zA-Z ]+) Service,(.+),*/
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
        if (split[1].equals("ADD") || split[1].equals("CREATE")) {
            this.protocol = "POST";
        } else if (split[1].equals("REMOVE")) {
            this.protocol = "DELETE";
        } else if (split[1].equals("GET") || split[1].equals("IS")) {
            this.protocol = "GET";
        } else if (split[1].equals("PUT")) {
        	this.protocol = "PUT";
        } else {
            this.protocol = "";
        }
    }

    /**Contructor for the {@link CustomOp}.
     * @param type This op service
     * @param op The operation uri
     * @param protocol The http procolol
     * */
    private CustomOp(final Service type, final String op,
    		final String protocol) {
        this.opUri = op;
        this.serviceType = type;
        this.protocol = protocol;
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


