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
public enum CustomOp 
{

    /**Addressbook add user operation.*/
    ADDRESSBOOK_ADD_USER("ADDRESSBOOK", "addressbooks"),
    /**Addressbook add users operation.*/
    ADDRESSBOOK_ADD_USERS("ADDRESSBOOK", "bulk"),
    /**Addressbook remove user operation.*/
    ADDRESSBOOK_REMOVE_USER("ADDRESSBOOK", "addressbooks"),
    /**Addressbook remove users operation.*/
    ADDRESSBOOK_REMOVE_USERS("ADDRESSBOOK", "bulk"),
    /**Addressbook get roster operation.*/
    ADDRESSBOOK_GET_ROSTER("ADDRESSBOOK", "addressbooks"),

    /**Returns a list of audit logs entries.*/
    AUDIT_GET_AUDIT_MESSAGES("AUDIT", "audit"),
    
    /**Deletes an avatar from the system.*/
    AVATAR_DELETE("AVATAR", "avatar"),
    /**Deletes an avatar from the system.*/
    AVATAR_GET_AVATAR_BY_ID("AVATAR", "avatarByID"),
    /**Deletes an avatar from the system.*/
    AVATAR_GET_AVATARS("AVATAR", "avatarsByUser"),
    /**Returns the maximum allowable height for an avatar image.*/
    AVATAR_GET_MAX_ALLOWABLE_HEIGHT("AVATAR", "avatarMaxAllowableHeight"),
    /**Returns the maximum allowable width for an avatar image.*/
    AVATAR_GET_MAX_ALLOWABLE_WIDTH("AVATAR", "avatarMaxAllowableWidth"),
    /**Returns true if the system should attempt to resize avatar images.*/
    AVATAR_IS_ALLOW_IMAGE_RESIZE("AVATAR", "avatarAllowImageResize"),
    /**Set whether the system should attempt to resize avatar images.*/
    AVATAR_SET_ALLOW_IMAGE_RESIZE("AVATAR", "avatarAllowImageResize"),
    /**Sets the maximum allowable height for an avatar image.*/
    AVATAR_SET_MAX_ALLOWABLE_HEIGHT("AVATAR", "avatarMaxAllowableHeight"),
    /**Sets the maximum allowable width for an avatar image.*/
    AVATAR_SET_MAX_ALLOWABLE_WIDTH("AVATAR", "avatarMaxAllowableWidth"),
    /**Adds an attachment to the blog post with the specified ID.*/
    BLOG_ADD_ATTACHMENT_TO_BLOG_POST("BLOG", "attachments"),
    /**Adds an image to the blog post with the specified ID.*/
    BLOG_ADD_IMAGE_TO_BLOG_POST("BLOG", "images"),
    /**Creates a new blog post.*/
    BLOG_CREATE_BLOG_POST("BLOG", "blogPosts"),
    /**Permanently deletes a blog post and all of the comments
     * associated with the it.*/
    BLOG_DELETE_BLOG_POST("BLOG", "blogPosts"),
    /**Permanently deletes a blog post and all of the comments
     * associated with the it.*/
    BLOG_GET_ATTACHMENTS_BY_POST_ID("BLOG", "attachments"),
    /**Returns a blog by blog ID.*/
    BLOG_GET_BLOG_BY_ID("BLOG", "blogsByID"),
    /**Returns a blog by blog name.*/
    BLOG_GET_BLOG_BY_NAME("BLOG", "blogsByName"),
    /**Returns the total number of blogs on this system.*/
    BLOG_GET_BLOG_COUNT("BLOG", "blogsCount"),
    /**Returns the total number of blogs on this system
     * that match the criteria specified by the ResultFilter.*/
    BLOG_GET_BLOG_COUNT_BY_RESULTFILTER("BLOG", "blogsCount", "POST"),
    /**Returns the count of all blogs which are associated with the given user.*/
    BLOG_GET_BLOG_COUNT_FOR_USER("BLOG", "userBlogCount"),
    /**Returns a blog by blog ID.*/
    BLOG_GET_BLOG_POST("BLOG", "blogPosts", "POST"),
    /**Returns all the blog posts that match the criteria specified by the
     * BlogPostResultFilter on the entire system.*/
    BLOG_GET_BLOG_POSTS_BY_RESULTFILTER("BLOG", "blogPostsWithFilter", "POST"),
    /**Returns the number of blog posts on the system. The default blog
     * post result filter () only includes blog posts where status = and
     * publish date less than now().*/
    BLOG_GET_BLOG_POST_COUNT_BY_RESULTFILTER("BLOG", "blogPosts", "POST"),
    /**Returns all blogs which are associated with the given user.*/
    BLOG_GET_BLOGS_FOR_USER("BLOG", "userBlogs"),
    /**Returns the number of comments on blog posts that match
     * the criteria specified by the FeedbackResultFilter in the entire system.*/
    BLOG_GET_COMMENT_COUNT_WITH_FILTER("BLOG", "commentCountWithFilter", "POST"),
    /**Returns all the comments on blog posts that match the criteria specified by
     * the FeedbackResultFilter in the entire system.*/
    BLOG_GET_COMMENTS_WITH_FILTER("BLOG", "commentsWithFilter", "POST"),
    /**Returns an array of images that are attached to the specified blog post.*/
    BLOG_GET_IMAGES_BY_BLOG_POST_ID("BLOG", "images"),
    /**Returns all of the tags for blogs in the system.*/
    BLOG_GET_TAGS("BLOG", "tags"),
    /**Returns all tags for blogs in the system filtered by the
     * BlogTagResultFilter.*/
    BLOG_GET_TAGS_BY_RESULTFILTER("BLOG", "tags", "POST"),
    /***/
    BLOG_PUBLISH_BLOG_POST("BLOG", "publishBlogPost", "POST"),
    /**Removes the attachment with the supplied id as an attachment of a blog.
     * Only administrators or the creator of the blog are allowed to call this method.*/
    BLOG_REMOVE_ATTACHMENT("BLOG", "attachments"),
    /**Uploads a new attachment to the blog post with the specified ID.*/
    BLOG_UPLOAD_ATTACHMENTS_TO_BLOG_POST("BLOG", "attachmentUpload", "POST"),
    /**Uploads a new attachment to the blog post with the specified ID.*/
    BLOG_USER_HAS_BLOGS("BLOG", "userHasBlogs", "GET"),
    /***/
    BLOG_UPDATE_BLOG_POST("BLOG", "blogPosts", "PUT"),
    /**Adds a new comment to an object.*/
    COMMENT_ADD("COMMENT", "comments"),
    /**Adds a new comment having a parent comment to the object.*/
    COMMENT_ADD_COMMENT_TO_COMMENT("COMMENT", "addChild"),
    /**Deletes a comment in the object. The search index and other
     * resources that referenced the comment will also be updated appropriately.*/
    COMMENT_DELETE_COMMENT_RECURSIVE("COMMENT", "recursiveDelete"),
    /**Returns the number of comments in the object based on the specified ResultFilter.
     * This is useful for determining such things as the number of comments in a date range, etc.*/
    COMMENT_GET_COMMENT_COUNT_WITH_FILTER("COMMENT", "count"),
    /**Returns a count of all the comments in all content which has been authored by the supplied user.*/
    COMMENT_GET_USER_CONTENT_COMMENT_COUNT("COMMENT", "usercommentcount"),
    /**Returns a count of all the comments in all content which has been authored by the supplied user.*/
    COMMENT_GET_USER_CONTENT_COMMENT_COUNT_WITH_FILTER("COMMENT", "user/count"),
    /**Returns array of all the comments in all content which has been authored by the supplied user.*/
    COMMENT_GET_USER_CONTENT_COMMENTS("COMMENT", "usercomments"),
    /**Returns array of all the comments in all content which has been authored by the supplied user.*/
    COMMENT_GET_USER_CONTENT_COMMENTS_WITH_FILTER("COMMENT", "user", "POST"),
    /**Updates an existing comment.*/
    COMMENT_UPDATE_COMMENT("COMMENT", "comments", "PUT"),
    /**TODO([a-zA-Z ]+) Service,(.+),*/
    TASK_CREATE("TASK", "tasks");

    /**The service of this operation.*/
    private final String serviceType;

    /**This operation uri.*/
    private final String opUri;

    /**The http protocol for this operation.*/
    private final String method;
    
    /**Contructor for the {@link CustomOp}.
     * @param type This op service
     * @param op The operation uri
     * @param protocol The http procolol
     * */
    private CustomOp(final String type, final String op,
                     final String protocol) 
    {
        this.opUri = op;
        this.serviceType = type;
        this.method = protocol;
    }

    /**Contructor for the {@link CustomOp}.
     * @param type This op service
     * @param op The operation uri
     * */
    private CustomOp(final String type, final String op) 
    {
        this.opUri = op;
        this.serviceType = type;

        final String[] split = StringUtils.split(this.toString(), '_');
        if (split[1].equals("ADD") || split[1].equals("CREATE")) 
        {
            this.method = "POST";
        } 
        else if (split[1].equals("REMOVE")) 
        {
            this.method = "DELETE";
        } 
        else if (split[1].equals("GET") || split[1].equals("IS")) 
        {
            this.method = "GET";
        } 
        else if (split[1].equals("PUT")) 
        {
            this.method = "PUT";
        } 
        else 
        {
            this.method = "";
        }
    }


    /**
     * @return the serviceType
     */
    public String getServiceType() 
    {
        return serviceType;
    }
    
    /**
     * @return The root tag xml element name for this custom operation.
     */
    public final String getRootTagElementName() 
    {
        final String[] split = StringUtils.split(this.toString(), '_');
        final StringBuffer res = new StringBuffer();
        res.append(split[1].toLowerCase());
        if (split.length > 2) 
        {
            for (int i = 2; i < split.length; i++) 
            {
                res.append(StringUtils.capitalize(split[i].toLowerCase()));
            }
        }
        return res.toString();
    }

    /**
     * @return the opUri
     */
    public String getOpUri() 
    {
        return opUri;
    }

    /**
     * @return the http protocol for this operation
     */
    public String getMethod() 
    {
        return method;
    }

    /**
     * @return
     */
    public String getGenerateCustomUri()
    {
        return this.serviceType.toLowerCase() + "Service" + "/" + getOpUri();
    }
}


