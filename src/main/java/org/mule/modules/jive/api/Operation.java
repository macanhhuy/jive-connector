
package org.mule.modules.jive.api;
import static org.mule.modules.jive.api.EntityTypeName.*;

import org.mule.modules.jive.CustomOp;

/**The complete list of operations the user can execute.*/
public enum Operation 
{

    /**
     * Creates a new avatar for a user using the specified byte array as the contents
     * of the avatar image.
     */
    AVATAR_CREATE_AVATAR(AVATAR, EntityTypes.BASE_URI),
    /** Deletes an avatar from the system. */
    AVATAR_DELETE_AVATAR(CustomOp.AVATAR_DELETE),
    /**
     * Returns the active avatar for the specified user, or the SystemDefaultAvatar
     * if the user does not have an active avatar specified.
     */
    AVATAR_GET_ACTIVE_AVATAR(AVATAR),
    /** Returns an avatar by its ID. */
    AVATAR_GET_AVATAR(CustomOp.AVATAR_GET),
    /** Used to acquire a count of all the avatars for a specific user. */
    AVATAR_GET_AVATAR_COUNT(AVATAR),
    /** Returns a list of avatars for the specified user. */
    AVATAR_GET_AVATARS(CustomOp.AVATAR_GET_AVATARS),
    /** Returns a list of all of the global avatars. */
    AVATAR_GET_GLOBAL_AVATARS(AVATAR),
    /** Returns the maximum allowable height for an avatar image. */
    AVATAR_GET_MAX_ALLOWABLE_HEIGHT(CustomOp.AVATAR_GET_MAX_ALLOWABLE_HEIGHT),
    /** Returns the maximum allowable width for an avatar image. */
    AVATAR_GET_MAX_ALLOWABLE_WIDTH(CustomOp.AVATAR_GET_MAX_ALLOWABLE_WIDTH),
    /**
     * Returns the maximum number of avatars a user is allowed to have; returns -1
     * when there is no limit.
     */
    AVATAR_GET_MAX_USER_AVATARS(AVATAR),
    /** Returns a count of all the avatars that require moderation. */
    AVATAR_GET_MODERATION_AVATAR_COUNT(AVATAR),
    /** Returns a collection of all of the avatars that require moderation. */
    AVATAR_GET_MODERATION_AVATARS(AVATAR),
    /** Returns true if the system should attempt to resize avatar images. */
    AVATAR_IS_ALLOW_IMAGE_RESIZE(CustomOp.AVATAR_IS_ALLOW_IMAGE_RESIZE),
    /** Returns true if the avatars feature is enabled; false otherwise. */
    AVATAR_IS_AVATARS_ENABLED(AVATAR),
    /** Returns whether or not user avatars will be moderated. */
    AVATAR_IS_MODERATE_USER_AVATARS(AVATAR),
    /** Returns true if users can create their own avatars; false otherwise. */
    AVATAR_IS_USER_AVATARS_ENABLED(AVATAR),
    /** Sets the specified avatar as the user's avatar. */
    AVATAR_SET_ACTIVE_AVATAR(AVATAR),
    /** Set whether the system should attempt to resize avatar images. */
    AVATAR_SET_ALLOW_IMAGE_RESIZE(CustomOp.AVATAR_SET_ALLOW_IMAGE_RESIZE),
    /** Sets the maximum allowable height for an avatar image. */
    AVATAR_SET_MAX_ALLOWABLE_HEIGHT(CustomOp.AVATAR_SET_MAX_ALLOWABLE_HEIGHT),
    /** Sets the maximum allowable width for an avatar image. */
    AVATAR_SET_MAX_ALLOWABLE_WIDTH(CustomOp.AVATAR_SET_MAX_ALLOWABLE_WIDTH),
    /** Sets the maximum number of avatars a user can have. */
    AVATAR_SET_MAX_USER_AVATARS(AVATAR),
    /** Sets whether or not user-create avatars will be moderated. */
    AVATAR_SET_MODERATE_USER_AVATARS(AVATAR),
    /** Sets whether or not users can create their own custom avatars. */
    AVATAR_SET_USER_AVATARS_ENABLED(AVATAR),
    /** Adds a new comment to the specified content object. */
  //  COMMENT_ADD_COMMENT(CustomOp.COMMENT_ADD), FIXME
    /** Adds a new comment to the specified parent comment. */
  //  COMMENT_ADD_COMMENT_TO_COMMENT(CustomOp.COMMENT_ADD_COMMENT_TO_COMMENT), FIXME
    /** Deletes all comments on the object. */
    COMMENT_DELETE_ALL_COMMENTS(COMMENT, EntityTypes.BASE_URI),
    /** Deletes a comment in the object. */
    COMMENT_DELETE_COMMENT(COMMENT, EntityTypes.BASE_URI),
    /** Deletes a comment in the object. */
    COMMENT_DELETE_COMMENT_RECURSIVE(CustomOp.COMMENT_DELETE_RECURSIVE),
    /** Returns the specified comment. */
    COMMENT_GET_COMMENT(COMMENT, EntityTypes.BASE_URI),
    /**
     * Returns the number of comments on the content specified by objectType and
     * objectID.
     */
    COMMENT_GET_COMMENT_COUNT(COMMENT),
    /**
     * Returns the number of comments on the content specified by objectType and
     * objectID, where the number is constrained by the filter.
     */
    COMMENT_GET_COMMENT_COUNT_WITH_FILTER(CustomOp.COMMENT_GET_COMMENT_COUNT_WITH_FILTER),
    /**
     * Returns a list of the comments on the content specified by objectType and
     * objectID.
     */
    COMMENT_GET_COMMENTS(COMMENT, EntityTypes.BASE_URI),
    /**
     * Returns a count of all the comments in all content that has been authored by
     * the specified user.
     */
    COMMENT_GET_USER_CONTENT_COMMENT_COUNT(CustomOp.COMMENT_GET_USER_CONTENT_COMMENT_COUNT),
    /**
     * Returns a count of all the comments in all content which has been authored by
     * the supplied user, with the count constrained by the specified filter.
     */
    COMMENT_GET_USER_CONTENT_COMMENT_COUNT_WITH_FILTER(CustomOp.COMMENT_GET_USER_CONTENT_COMMENT_COUNT_WITH_FILTER),
    /**
     * Returns a list of all the comments in all content which has been authored by
     * the supplied user.
     */
    COMMENT_GET_USER_CONTENT_COMMENTS(CustomOp.COMMENT_GET_USER_CONTENT_COMMENTS),
    /**
     * Returns a list of all the comments in all content which has been authored by
     * the supplied user.
     */
    COMMENT_GET_USER_CONTENT_COMMENTS_WITH_FILTER(CustomOp.COMMENT_GET_USER_CONTENT_COMMENTS_WITH_FILTER),
    /** Updates an existing comment. */
    COMMENT_UPDATE_COMMENT(CustomOp.COMMENT_UPDATE),
    /** Adds an attachment to the specified blog post. */
    BLOG_ADD_ATTACHMENT_TO_BLOG_POST(CustomOp.BLOG_ADD_ATTACHMENT_TO_BLOG_POST),
    /** Adds an image to the specified blog post. */
    BLOG_ADD_IMAGE_TO_BLOG_POST(CustomOp.BLOG_ADD_IMAGE_TO_BLOG_POST),
    /** Creates a new blog. */
    BLOG_CREATE_BLOG(BLOG, EntityTypes.BASE_URI),
    /** Creates a new blog post. */
    BLOG_CREATE_BLOG_POST(CustomOp.BLOG_CREATE_BLOG_POST),
    /**
     * Permanently deletes a blog and all of the posts and comments associated with
     * it.
     */
    BLOG_DELETE_BLOG(BLOG, EntityTypes.BASE_URI),
    /**
     * Permanently deletes a blog post and all of the comments associated with the
     * it.
     */
    BLOG_DELETE_BLOG_POST(CustomOp.BLOG_DELETE_BLOG_POST),
    /** Returns an array of attachments for the specified blog post. */
    BLOG_GET_ATTACHMENTS_BY_BLOG_POST_ID(CustomOp.BLOG_GET_ATTACHMENTS_BY_BLOG_POST_ID),
    /** Returns a blog by blog name. */
    BLOG_GET_BLOG_BY_NAME(CustomOp.BLOG_GET_BLOG_BY_NAME),
    /** Returns a blog by its ID. */
    BLOG_GET_BLOG_BY_ID(CustomOp.BLOG_GET_BLOG_BY_ID),
    /** Returns the total number of blogs on this system. */
    BLOG_GET_BLOG_COUNT(CustomOp.BLOG_GET_BLOG_COUNT),
    /**
     * Returns the total number of blogs on this system that match the criteria
     * specified by the filter.
     */
    BLOG_GET_BLOG_COUNT_BY_RESULTFILTER(CustomOp.BLOG_GET_BLOG_COUNT_BY_FILTER),
    /** Returns the count of all blogs associated with the specified user. */
    BLOG_GET_BLOG_COUNT_FOR_USER(CustomOp.BLOG_GET_BLOG_COUNT_FOR_USER),
    /** Returns a blog post by its ID. */
    BLOG_GET_BLOG_POST(CustomOp.BLOG_GET_BLOG_POST),
    /**
     * Returns the number of blog posts on the system, by default only includes blog
     * posts where status = WSBlogPost.STATUS_PUBLISH and publish date less than now.
     */
    BLOG_GET_BLOG_POST_COUNT(CustomOp.BLOG_GET_BLOG_COUNT),
    /**Returns the number of blog posts on the system.
     * The default blog post result filter () only includes
     * blog posts where status = and publish date less than now().*/
    BLOG_GET_BLOG_POST_COUNT_BY_RESULTFILTER(CustomOp.BLOG_GET_BLOG_COUNT_BY_FILTER),
    /** Returns all the blog posts that match the criteria specified by the filter. */
    BLOG_GET_BLOG_POSTS(CustomOp.BLOG_GET_BLOG_POSTS_BY_FILTER),
    /**
     * Returns all the blogs on this system whose display name is LIKE the given
     * query.
     */
    BLOG_GET_BLOGS_BY_DISPLAY_NAME(BLOG),
    /** Returns all blogs associated with the specified user. */
    BLOG_GET_BLOGS_FOR_USER(CustomOp.BLOG_GET_BLOGS_FOR_USER),
    /** Returns the number of comments on blog posts in the system. */
    BLOG_GET_COMMENT_COUNT(BLOG),
    /**
     * Returns the number of blog post comments that match the criteria specified by
     * the filter.
     */
    BLOG_GET_COMMENT_COUNT_BY_RESULTFILTER(CustomOp.BLOG_GET_COMMENT_COUNT_BY_FILTER),
    /**
     * Returns all the blog post comments that match the criteria specified by the
     * filter.
     */
    BLOG_GET_COMMENTS(CustomOp.BLOG_GET_COMMENTS_BY_FILTER),
    /** Returns an array of images that are attached to the specified blog post. */
    BLOG_GET_IMAGES_BY_BLOG_POST_ID(CustomOp.BLOG_GET_IMAGES_BY_BLOG_POST_ID),
    /** Returns a comma-delimited list of available pings for the system. */
    BLOG_GET_PING_SERVICES(BLOG),
    /** Returns up to ten of the most recent blogs created on this system. */
    BLOG_GET_RECENT_BLOGS(BLOG),
    /** Returns all of the tags for blogs in the system. */
    BLOG_GET_TAGS(CustomOp.BLOG_GET_TAGS),
    /** Returns all tags for blogs as constrained by the specified filter. */
    BLOG_GET_TAGS_BY_RESULTFILTER(CustomOp.BLOG_GET_TAGS_BY_FILTER),
    /** Returns true if the blogs feature is turned on. */
    BLOG_IS_BLOGS_ENABLED(BLOG),
    /** Returns true if the comments feature is turned on. */
    BLOG_IS_COMMENTS_ENABLED(BLOG),
    /** Returns true if the pings feature is turned on. */
    BLOG_IS_PINGS_ENABLED(BLOG),
    /**
     * Returns true if the system has been configured to allow users to override the
     * ping URIs configured for the system.
     */
    BLOG_IS_PINGS_OVERRIDE_ENABLED(BLOG),
    /** Returns true if the trackbacks feature is turned on. */
    BLOG_IS_TRACKBACKS_ENABLED(BLOG),
    /** Publishes a blog post with the specified subject and body. */
    BLOG_PUBLISH_BLOG_POST(CustomOp.BLOG_PUBLISH_BLOG_POST),
    /** Removes the attachment with the supplied ID. */
    BLOG_REMOVE_ATTACHMENT(CustomOp.BLOG_REMOVE_ATTACHMENT),
    /** Enables or disables the blogs feature. */
    BLOG_SET_BLOGS_ENABLED(BLOG),
    /** Enables or disables the comments feature system wide. */
    BLOG_SET_COMMENTS_ENABLED(BLOG),
    /** Sets the comma-delimited list of available pings for the system. */
    BLOG_SET_PING_SERVICES(BLOG),
    /** Enables or disables the pings feature system wide. */
    BLOG_SET_PINGS_ENABLED(BLOG),
    /**
     * Configures the system to allow users to override the ping URIs configured for
     * all blogs.
     */
    BLOG_SET_PINGS_OVERRIDE_ENABLED(BLOG),
    /** Enables or disables the trackbacks feature system wide. */
    BLOG_SET_TRACKBACKS_ENABLED(BLOG),
    /** Updates the specified blog post with what's contained in blogPost. */
    BLOG_UPDATE_BLOG_POST(CustomOp.BLOG_UPDATE_BLOG_POST),
    /** Uploads a new attachment to the specified blog post. */
    BLOG_UPLOAD_ATTACHMENT_TO_BLOG_POST(CustomOp.BLOG_UPLOAD_ATTACHMENT_TO_BLOG_POST),
    /**
     * Returns <tt>true</tt> if the specified user has one or more blogs;
     * <tt>false</tt> if the user does not have a blog.
     */
    BLOG_USER_HAS_BLOGS(CustomOp.BLOG_USER_HAS_BLOGS),
    /** Creates a new community as a sub-community of the specified community. */
    COMMUNITY_CREATE_COMMUNITY(COMMUNITY, EntityTypes.BASE_URI),
    /** Deletes the specified community. */
    COMMUNITY_DELETE_COMMUNITY(COMMUNITY, EntityTypes.BASE_URI),
    /** Delete the specified property from the specified community. */
    COMMUNITY_DELETE_PROPERTY(COMMUNITY),
    /** Returns a WSCommunity by its ID. */
    COMMUNITY_GET_COMMUNITY(COMMUNITY, EntityTypes.BASE_URI),
    /**
     * Returns document IDs for all published documents in the specified community,
     * excluding its sub-communities.
     */
    COMMUNITY_GET_DOCUMENT_IDS(CustomOp.COMMUNITY_GET_DOCUMENT_IDS),
    /** Returns the extended properties for the specified community. */
    COMMUNITY_GET_PROPERTIES(CustomOp.COMMUNITY_GET_PROPERTIES),
    /** Returns the specified extended property for a community. */
    COMMUNITY_GET_PROPERTY(CustomOp.COMMUNITY_GET_PROPERTY),
    /***/
    COMMUNITY_GET_RECURSIVE_COMMUNITIES(CustomOp.COMMUNITY_GET_RECURSIVE_COMMUNITIES),
    /**
     * Returns all sub-communities that are descendants of the specified parent
     * community.
     */
    COMUNITYSERVICE_GET_RECURSIVE_COMMUNITIES_BY_PARENT(COMMUNITY),
    /** Returns a count of sub-communities of the specified community. */
    COMUNITYSERVICE_GET_RECURSIVE_COMMUNITY_COUNT(COMMUNITY),
    /** Returns the immediate sub-communities of the specified parent community. */
    COMUNITYSERVICE_GET_SUB_COMMUNITIES(COMMUNITY),
    /** Sets an extended propery for the specified community. */
    COMUNITYSERVICE_SET_PROPERTY(COMMUNITY),
    /** Updates the specified community with <em>community</em>. */
    COMUNITYSERVICE_UPDATE_COMMUNITY(COMMUNITY),
    /** Adds a new attachment to the specified document. */
    DOCUMENT_ADD_ATTACHMENT_TO_DOCUMENT_BY_DOCUMENT_ID(CustomOp.DOCUMENT_ADD_ATTACHMENT_TO_DOCUMENT_BY_DOCUMENT_ID),
    /** Adds a new attachment to the specified document. */
    DOCUMENT_ADD_ATTACHMENT_TO_DOCUMENT_BY_INTERNAL_DOC_ID(CustomOp.DOCUMENT_ADD_ATTACHMENT_TO_DOCUMENT_BY_INTERNAL_DOC_ID),
    /** Adds the specified user as an author of a document. */
    DOCUMENT_ADD_AUTHOR(CustomOp.DOCUMENT_ADD_AUTHOR),
    /** Adds the specified user as a document approver for an entire community. */
    DOCUMENT_ADD_DOCUMENT_APPROVER_ON_COMMUNITY(CustomOp.DOCUMENT_ADD_DOCUMENT_APPROVER_ON_COMMUNITY),
    /** Adds a user as an approver for the specified document. */
    DOCUMENT_ADD_DOCUMENT_APPROVER_ON_DOCUMENT(CustomOp.DOCUMENT_ADD_DOCUMENT_APPROVER_ON_DOCUMENT),
    /** Adds a new image to the specified document. */
    DOCUMENT_ADD_IMAGE_TO_DOCUMENT_BY_DOCUMENT_ID(CustomOp.DOCUMENT_ADD_IMAGE_TO_DOCUMENT_BY_DOCUMENT_ID),
    /** Adds a new image to the document with the specified internal ID. */
    DOCUMENT_ADD_IMAGE_TO_DOCUMENT_BY_INTERNAL_DOC_ID(CustomOp.DOCUMENT_ADD_IMAGE_TO_DOCUMENT_BY_INTERNAL_DOC_ID),
    /** Creates a new binary document in the specified community. */
    DOCUMENT_CREATE_BINARY_DOCUMENT(DOCUMENT),
    /** Creates a new binary document in the specified container. */
    DOCUMENT_CREATE_BINARY_DOCUMENT_IN_CONTAINER(DOCUMENT),
    /** Creates a new document in the specified community. */
    DOCUMENT_CREATE_DOCUMENT(DOCUMENT),
    /** Create a new document in the specified container. */
    DOCUMENT_CREATE_DOCUMENT_IN_CONTAINER(DOCUMENT),
    /** Deletes a document. */
    DOCUMENT_DELETE_DOCUMENT(DOCUMENT),
    /** Deletes the specified property from the specified document. */
    DOCUMENT_DELETE_DOCUMENT_PROPERTY(DOCUMENT),
    /**
     * Returns a list of WSApprovalStatus that show which users have approved the
     * specified document and which haven't.
     */
    DOCUMENT_GET_APPROVAL_STATUS_FOR_DOCUMENT(DOCUMENT),
    /** Returns the number of attachments on the specified document. */
    DOCUMENT_GET_ATTACHMENT_COUNT_BY_DOCUMENT_ID(DOCUMENT),
    /** Returns the number of attachments on the specified document. */
    /**
     * Returns the number of attachments on the document with the specified internal
     * ID.
     */
    DOCUMENT_GET_ATTACHMENT_COUNT_BY_INTERNAL_DOC_ID(DOCUMENT),
    /** Returns the attachments for the specified document. */
    DOCUMENT_GET_ATTACHMENTS_BY_DOCUMENT_ID(DOCUMENT),
    DOCUMENT_GET_ATTACHMENTS_BY_INTERNAL_DOC_ID(DOCUMENT),
    /** Returns the users who are allowed to edit the document. */
    DOCUMENT_GET_AUTHORS(DOCUMENT),
    /** Returns the content of the specified binary document. */
    DOCUMENT_GET_BINARY_DOCUMENT_CONTENT(DOCUMENT),
    /**
     * Returns all of the users who must approve new documents before they can be
     * published.
     */
    DOCUMENT_GET_DOCUMENT_APPROVERS_ON_COMMUNITY(DOCUMENT),
    DOCUMENT_GET_DOCUMENT_APPROVERS_ON_DOCUMENT(DOCUMENT),
    /** Returns the specified document from a community. */
    DOCUMENT_GET_DOCUMENT_BY_DOCUMENT_ID(DOCUMENT),
    /** Returns the specified version of a document. */
    DOCUMENT_GET_DOCUMENT_BY_DOCUMENT_IDAND_VERSION(DOCUMENT),
    /** Returns the specified document. */
    DOCUMENT_GET_DOCUMENT_BY_INTERNAL_DOC_ID(DOCUMENT),
    /** Returns the specified version of a document. */
    DOCUMENT_GET_DOCUMENT_BY_INTERNAL_DOC_IDAND_VERSION(DOCUMENT),
    /** Returns the extended properties for the specified document. */
    DOCUMENT_GET_DOCUMENT_PROPERTIES(DOCUMENT),
    /** Returns the value of the specified extended property for a document. */
    DOCUMENT_GET_DOCUMENT_PROPERTY(DOCUMENT),
    /** Returns all of the documents for the specified community. */
    DOCUMENT_GET_DOCUMENTS_BY_COMMUNITY(DOCUMENT),
    DOCUMENT_GET_DOCUMENTS_BY_COMMUNITY_AND_FILTER(DOCUMENT),
    /** Returns the number of images on the specified document. */
    DOCUMENT_GET_IMAGE_COUNT_BY_DOCUMENT_ID(DOCUMENT),
    /** Returns the number of images on the document with the specified internal ID. */
    DOCUMENT_GET_IMAGE_COUNT_BY_INTERNAL_DOC_ID(DOCUMENT),
    /** Acquire the images for a document by the document id. */
    DOCUMENT_GET_IMAGES_BY_DOCUMENT_ID(DOCUMENT),
    /** Returns the images for the document specified by its internal ID. */
    DOCUMENT_GET_IMAGES_BY_INTERNAL_DOC_ID(DOCUMENT),
    /**
     * Returns the most popular documents from across all communities according to
     * ratings, document views and time passed since the document was created.
     */
    DOCUMENT_GET_POPULAR_DOCUMENTS(DOCUMENT),
    /**
     * Returns the most popular documents in the given community according to
     * ratings, document views and time passed since the document was created.
     */
    DOCUMENT_GET_POPULAR_DOCUMENTS_BY_COMMUNITY(DOCUMENT),
    /**
     * Returns the most popular documents in the given community according to
     * ratings, document views and time passed since the document was created in the
     * specified languages.
     */
    DOCUMENT_GET_POPULAR_DOCUMENTS_BY_LANGUAGE(DOCUMENT),
    /** Returns the user who authored the document. */
    DOCUMENT_GET_USER(DOCUMENT),
    /**
     * Returns a list of the documents that the specified user must approve before
     * they can be published.
     */
    DOCUMENT_GET_USER_APPROVAL_DOCUMENTS(DOCUMENT),
    /** Returns true if the comments feature is turned on. */
    DOCUMENT_IS_COMMENTS_ENABLED(DOCUMENT),
    /** Returns true if the trackbacks feature is turned on. */
    DOCUMENT_IS_TRACKBACKS_ENABLED(DOCUMENT),
    /** Moves a document from its current community to another one. */
    DOCUMENT_MOVE_DOCUMENT(DOCUMENT),
    /** Moves a document from its current container to another. */
    DOCUMENT_MOVE_DOCUMENT_TO_CONTAINER(DOCUMENT),
    /** Publishes the specified binary document in the specified community. */
    DOCUMENT_PUBLISH_BINARY_DOCUMENT(DOCUMENT),
    /** Publishes the specified binary document in the specified container. */
    DOCUMENT_PUBLISH_BINARY_DOCUMENT_IN_CONTAINER(DOCUMENT),
    /** Publishes the specified document in the specified community. */
    DOCUMENT_PUBLISH_DOCUMENT(DOCUMENT),
    /** Publishes the specified document in the specified container. */
    DOCUMENT_PUBLISH_DOCUMENT_IN_CONTAINER(DOCUMENT),
    /** Removes the specified attachment. */
    DOCUMENT_REMOVE_ATTACHMENT(DOCUMENT),
    /** Removes the specified user as an author of the specified document. */
    DOCUMENT_REMOVE_AUTHOR(DOCUMENT),
    /** Enables or disables the comments feature system wide. */
    DOCUMENT_SET_COMMENTS_ENABLED(DOCUMENT),
    /** Sets the specified extended property for a document. */
    DOCUMENT_SET_DOCUMENT_PROPERTY(DOCUMENT),
    /** Enables or disables the trackbacks feature system wide. */
    DOCUMENT_SET_TRACKBACKS_ENABLED(DOCUMENT),
    /** Updates the specified document with the <em>document</em> parameter value. */
    DOCUMENT_UPDATE_DOCUMENT(DOCUMENT),
    /** Uploads a file as an attachment to the specified document. */
    DOCUMENT_UPLOAD_ATTACHMENT_TO_DOCUMENT_BY_DOCUMENT_ID(DOCUMENT),
    /** Uploads a file as an attachment to the document specified internal ID. */
    DOCUMENT_UPLOAD_ATTACHMENT_TO_DOCUMENT_BY_INTERNAL_DOC_ID(DOCUMENT),
    /**
     * Adds the entitlements specified by the supplied mask to the user for the given
     * container and content type.
     */
    ENTITLEMENTSERVICE_ADD_GROUP_ENTITLEMENT(ENTITLEMENT),
    /**
     * Adds the entitlements specified by the supplied mask to the user for the given
     * container and content type.
     */
    ENTITLEMENTSERVICE_ADD_USER_ENTITLEMENT(ENTITLEMENT),
    /** Returns all the entitlement masks available in the system. */
    ENTITLEMENTSERVICE_GET_ENTITLEMENT_MASKS(ENTITLEMENT),
    /**
     * Returns true if the supplied user has any of the entitlements specified by the
     * given mask for the supplied container and content type
     */
    ENTITLEMENTSERVICE_IS_USER_ENTITLED(ENTITLEMENT),
    /**
     * Removes the entitlements specified by the supplied mask from the user for the
     * given container and content type.
     */
    ENTITLEMENTSERVICE_REMOVE_GROUP_ENTITLEMENT(ENTITLEMENT),
    /**
     * Removes the entitlements specified by the supplied mask from the user for the
     * given container and content type.
     */
    ENTITLEMENTSERVICE_REMOVE_USER_ENTITLEMENT(ENTITLEMENT),
    /** Adds an attachment to the specified message. */
    FORUMSERVICE_ADD_ATTACHMENT_TO_MESSAGE(FORUM),
    /** Adds an image to the specified. */
    FORUMSERVICE_ADD_IMAGE_TO_MESSAGE(FORUM),
    /** Creates a new message on the specified thread. */
    FORUMSERVICE_CREATE_MESSAGE(FORUM),
    /** Creates a new message that is a direct response to the specified message. */
    FORUMSERVICE_CREATE_REPLY_MESSAGE(FORUM),
    /** Creates a new thread in the specified community. */
    FORUMSERVICE_CREATE_THREAD(FORUM),
    /** Creates a new thread in the specified container. */
    FORUMSERVICE_CREATE_THREAD_IN_CONTAINER(FORUM),
    /** Deletes the specified message. */
    FORUMSERVICE_DELETE_MESSAGE(FORUM),
    /** Deletes the specified message, optionally also deleting its child messages. */
    FORUMSERVICE_DELETE_MESSAGE_AND_CHILDREN(FORUM),
    /** Deletes the specified property from a message. */
    FORUMSERVICE_DELETE_MESSAGE_PROPERTY(FORUM),
    /** Deletes the specified thread. */
    FORUMSERVICE_DELETE_THREAD(FORUM),
    /** Deletes the specified property from the specified thread. */
    FORUMSERVICE_DELETE_THREAD_PROPERTY(FORUM),
    /** Returns attachments for the specified message. */
    FORUMSERVICE_GET_ATTACHMENTS_BY_MESSAGE_ID(FORUM),
    /**
     * Returns the specified child message of the specified parent, given the child
     * message's index in the array of children.
     */
    FORUMSERVICE_GET_CHILD(FORUM),
    /**
     * Returns the number of the specified parent's child messages; 0 if the node has
     * no children.
     */
    FORUMSERVICE_GET_CHILD_COUNT(FORUM),
    /** Returns all the messages that are children of the specified parent. */
    FORUMSERVICE_GET_CHILDREN(FORUM),
    /** Returns the specified message. */
    FORUMSERVICE_GET_FORUM_MESSAGE(FORUM),
    /** Returns the specified thread.. */
    FORUMSERVICE_GET_FORUM_THREAD(FORUM),
    /** Returns the images that are attached to the specified message. */
    FORUMSERVICE_GET_IMAGES_BY_MESSAGE_ID(FORUM),
    /**
     * Returns the index of the specified message one of the specified parent's
     * children.
     */
    FORUMSERVICE_GET_INDEX_OF_CHILD(FORUM),
    /** Returns the number of messages in the specified community. */
    FORUMSERVICE_GET_MESSAGE_COUNT_BY_COMMUNITY_ID(FORUM),
    /**
     * Returns the number of messages in the specified community, as constrained by
     * the specified filter.
     */
    FORUMSERVICE_GET_MESSAGE_COUNT_BY_COMMUNITY_IDAND_FILTER(FORUM),
    /** Returns the number of messages in the specified thread. */
    FORUMSERVICE_GET_MESSAGE_COUNT_BY_THREAD_ID(FORUM),
    /**
     * Returns the number of messages in the specified thread, as constrained by the
     * specified filter.
     */
    FORUMSERVICE_GET_MESSAGE_COUNT_BY_THREAD_IDAND_FILTER(FORUM),
    /**
     * Returns the number of messages that are in the specified community, as
     * constrained by the specified filter.
     */
    FORUMSERVICE_GET_MESSAGE_COUNTS_BY_COMMUNITY_IDAND_FILTER(FORUM),
    /**
     * Returns the depth-level of the specified message in the message tree
     * hierarchy.
     */
    FORUMSERVICE_GET_MESSAGE_DEPTH(FORUM),
    /** Returns IDs for all messages in the specified community. */
    FORUMSERVICE_GET_MESSAGE_IDS_BY_COMMUNITY_ID(FORUM),
    /**
     * Returns IDs for all messages in the specified community, constrained by the
     * specified filter.
     */
    FORUMSERVICE_GET_MESSAGE_IDS_BY_COMMUNITY_IDAND_FILTER(FORUM),
    /** Returns IDs of all messages in the specified thread. */
    FORUMSERVICE_GET_MESSAGE_IDS_BY_THREAD_ID(FORUM),
    /**
     * Returns IDs for all of the messages in the thread, as constrained by the
     * specified filter.
     */
    FORUMSERVICE_GET_MESSAGE_IDS_BY_THREAD_IDAND_FILTER(FORUM),
    /** Returns the extended properties for the specified message. */
    FORUMSERVICE_GET_MESSAGE_PROPERTIES(FORUM),
    /** Returns the value of the specified extended property for a message. */
    FORUMSERVICE_GET_MESSAGE_PROPERTY(FORUM),
    /** Returns all of the messages in the specified community. */
    FORUMSERVICE_GET_MESSAGES_BY_COMMUNITY_ID(FORUM),
    /**
     * Returns all of the messages in the specified community, as constrained by the
     * specified filter.
     */
    FORUMSERVICE_GET_MESSAGES_BY_COMMUNITY_IDAND_FILTER(FORUM),
    /** Returns the messages in the specified thread. */
    FORUMSERVICE_GET_MESSAGES_BY_THREAD_ID(FORUM),
    /**
     * Returns all of the messages in the specified, constrained by the the specified
     * filter.
     */
    FORUMSERVICE_GET_MESSAGES_BY_THREAD_IDAND_FILTER(FORUM),
    /** Returns the parent of the specified message. */
    FORUMSERVICE_GET_PARENT(FORUM),
    /** Returns the IDs for all the popular threads in the system. */
    FORUMSERVICE_GET_POPULAR_THREADS(FORUM),
    /** Returns the popular threads in the specified community. */
    FORUMSERVICE_GET_POPULAR_THREADS_BY_COMMUNITY_ID(FORUM),
    /**
     * Returns the total number of the specified paren'ts children, recursively; 0 if
     * there are no children.
     */
    FORUMSERVICE_GET_RECURSIVE_CHILD_COUNT(FORUM),
    /**
     * Returns all descendants (child messages and all of their sub-children) of the
     * specified parent.
     */
    FORUMSERVICE_GET_RECURSIVE_CHILDREN(FORUM),
    /** Returns all messages in the specified thread in depth-first order. */
    FORUMSERVICE_GET_RECURSIVE_MESSAGES(FORUM),
    /**
     * Returns the root message of the specified thread; null if thread has no nodes.
     */
    FORUMSERVICE_GET_ROOT_MESSAGE(FORUM),
    /** Returns the number of threads in the specified community. */
    FORUMSERVICE_GET_THREAD_COUNT_BY_COMMUNITY_ID(FORUM),
    /**
     * Returns the number of threads in the specified community, as constrained by
     * the specified filter.
     */
    FORUMSERVICE_GET_THREAD_COUNT_BY_COMMUNITY_IDAND_FILTER(FORUM),
    /** Returns all the extended properties for the specified thread. */
    FORUMSERVICE_GET_THREAD_PROPERTIES(FORUM),
    /**
     * Returns the value of the specified extended property for the specified thread.
     */
    FORUMSERVICE_GET_THREAD_PROPERTY(FORUM),
    /** Returns all of the IDs for threads the specified community. */
    FORUMSERVICE_GET_THREADS_BY_COMMUNITY_ID(FORUM),
    /**
     * Returns all of the IDs for threads the specified community, as constrained by
     * the specified result filter.
     */
    FORUMSERVICE_GET_THREADS_BY_COMMUNITY_IDAND_FILTER(FORUM),
    /** Returns message properties without applying filters to them first. */
    FORUMSERVICE_GET_UNFILTERED_MESSAGE_PROPERTIES(FORUM),
    /** Returns true if the specified message has a parent message. */
    FORUMSERVICE_HAS_PARENT(FORUM),
    /** Returns true if the specified message has no child messages. */
    FORUMSERVICE_IS_LEAF(FORUM),
    /** Moves the specified thread to the specified community. */
    FORUMSERVICE_MOVE_THREAD(FORUM),
    /** Moves the specified thread to the specified container. */
    FORUMSERVICE_MOVE_THREAD_TO_CONTAINER(FORUM),
    /** Removes the specified attachment. */
    FORUMSERVICE_REMOVE_ATTACHMENT(FORUM),
    /** Sets an extended property for the specified message. */
    FORUMSERVICE_SET_MESSAGE_PROPERTY(FORUM),
    /** Sets an extended property for the specified thread. */
    FORUMSERVICE_SET_THREAD_PROPERTY(FORUM),
    /** Updates the subject and body of the specified message. */
    FORUMSERVICE_UPDATE_FORUM_MESSAGE(FORUM),
    /** Uploads a new attachment to the specified message. */
    FORUMSERVICE_UPLOAD_ATTACHMENT_TO_MESSAGE(FORUM),
    /** Makes the specified user an administrator of the specified group. */
    GROUPSERVICE_ADD_ADMINISTRATOR_TO_GROUP(GROUP),
    /** Adds the specified user to the specified group. */
    GROUPSERVICE_ADD_MEMBER_TO_GROUP(GROUP),
    /** Creates a new user group. */
    GROUPSERVICE_CREATE_GROUP(GROUP),
    /** Deletes the group with the specified ID. */
    GROUPSERVICE_DELETE_GROUP(GROUP),
    /** Deletes an extended property from the specified group. */
    GROUPSERVICE_DELETE_PROPERTY(GROUP),
    /** Returns the count of administrators for the specified group. */
    GROUPSERVICE_GET_ADMINISTRATOR_COUNT(GROUP),
    /** Returns a user group by its ID. */
    GROUPSERVICE_GET_GROUP(GROUP),
    /** Returns an array of IDs for all users that administer the specified group. */
    GROUPSERVICE_GET_GROUP_ADMINS(GROUP),
    /** Returns a user group by its name. */
    GROUPSERVICE_GET_GROUP_BY_NAME(GROUP),
    /** Returns a count of all groups in the system. */
    GROUPSERVICE_GET_GROUP_COUNT(GROUP),
    /** Returns the user information for members of the specified group. */
    GROUPSERVICE_GET_GROUP_MEMBERS(GROUP),
    /** Returns the names for all the groups in the system. */
    GROUPSERVICE_GET_GROUP_NAMES(GROUP),
    /**
     * Returns names for groups beginning at startIndex and until the number results
     * equals numResults.
     */
    GROUPSERVICE_GET_GROUP_NAMES_BOUNDED(GROUP),
    /** Returns the group IDs for all groups in the system. */
    GROUPSERVICE_GET_GROUPS(GROUP),
    /** Returns the specified group's extended properties. */
    GROUPSERVICE_GET_PROPERTIES(GROUP),
    /** Returns the names of groups that the specified user belongs to. */
    GROUPSERVICE_GET_USER_GROUP_NAMES(GROUP),
    /** Returns the IDs of groups that a user belongs to. */
    GROUPSERVICE_GET_USER_GROUPS(GROUP),
    /** Returns true if this GroupService is read-only. */
    GROUPSERVICE_IS_READ_ONLY(GROUP),
    /** Removes the specified user as an administrator from the specified group. */
    GROUPSERVICE_REMOVE_ADMINISTRATOR_FROM_GROUP(GROUP),
    /** Removes the specified user from the specified group. */
    GROUPSERVICE_REMOVE_MEMBER_FROM_GROUP(GROUP),
    /** Sets a new extended property on the specified group. */
    GROUPSERVICE_SET_PROPERTY(GROUP),
    /** Updates the specified group. */
    GROUPSERVICE_UPDATE_GROUP(GROUP),
    /** Configures the connection between SBS and the XMPP server. */
    IMSERVICE_CONFIGURE_COMPONENT(IMSERVICE),
    /** Generates a new nonce that can be used to SSO from Openfire. */
    IMSERVICE_GENERATE_NONCE(IMSERVICE),
    /**
     * Tests the user's credentials to ensure that they have the required
     * permissions.
     */
    IMSERVICE_TEST_CREDENTIALS(IMSERVICE),
    /** Returns a list of installed plugins. */
    PLUGINSERVICE_GET_PLUGIN_INFO(PLUGIN),
    /** Installs the specified plugin. */
    PLUGINSERVICE_INSTALL_PLUGIN(PLUGIN),
    /** Unistalls the specified plugin. */
    PLUGINSERVICE_UNINSTALL_PLUGIN(PLUGIN),
    /** Add a guest vote for an option in the poll. */
    POLLSERVICE_ADD_ANONYMOUS_VOTE(POLL),
    /** Add a new option to the poll. */
    POLLSERVICE_ADD_OPTION(POLL),
    /** Add a user vote for an option in the poll. */
    POLLSERVICE_ADD_USER_VOTE(POLL),
    /** Change a guest vote. */
    POLLSERVICE_CHANGE_ANONYMOUS_VOTE(POLL),
    /** Change a user vote. */
    POLLSERVICE_CHANGE_USER_VOTE(POLL),
    /** Creates a new poll. */
    POLLSERVICE_CREATE_POLL(POLL),
    /** Remove an option from the poll. */
    POLLSERVICE_DELETE_OPTION(POLL),
    /** Deletes the specified poll. */
    POLLSERVICE_DELETE_POLL(POLL),
    /** Returns a count of all active polls in the system. */
    POLLSERVICE_GET_ACTIVE_POLL_COUNT(POLL),
    /** Returns a count of all active polls of a given type and object ID. */
    POLLSERVICE_GET_ACTIVE_POLL_COUNT_BY_OBJECT_TYPE_AND_OBJECT_ID(POLL),
    /** Returns an iterable of active polls in the system. */
    POLLSERVICE_GET_ACTIVE_POLLS(POLL),
    /**
     * Returns a list of active polls associated with the object specified by the
     * objectType and objectID.
     */
    POLLSERVICE_GET_ACTIVE_POLLS_BY_OBJECT_TYPE_AND_OBJECT_ID(POLL),
    /** Returns a count of all guests user votes for all options in the poll. */
    POLLSERVICE_GET_ANONYMOUS_VOTE_COUNT(POLL),
    /** Returns a count of all user votes for the specified option in the poll. */
    POLLSERVICE_GET_ANONYMOUS_VOTE_COUNT_BY_INDEX(POLL),
    /**
     * Returns a list of option indexes corresponding to the anonymous votes, or an
     * empty array if the user has not voted.
     */
    POLLSERVICE_GET_ANONYMOUS_VOTE_INDICES(POLL),
    /**
     * Returns a list of uniqueID's for guests who have voted for the option at the
     * given index.
     */
    POLLSERVICE_GET_ANONYMOUS_VOTES(POLL),
    /**
     * Returns an Iterator of uniqueID's for guests who have voted for the option at
     * the given index.
     */
    POLLSERVICE_GET_ANONYMOUS_VOTES_BY_INDEX(POLL),
    /** Returns a count of all live polls in the system. */
    POLLSERVICE_GET_LIVE_POLL_COUNT(POLL),
    /** Returns a count of all live polls of a given type and object ID. */
    POLLSERVICE_GET_LIVE_POLL_COUNT_BY_OBJECT_TYPE_AND_OBJECT_ID(POLL),
    /** Returns a List of live polls in the system. */
    POLLSERVICE_GET_LIVE_POLLS(POLL),
    /**
     * Returns an iterable of live polls associated with the object specified by the
     * objectType and objectID.
     */
    POLLSERVICE_GET_LIVE_POLLS_BY_OBJECT_TYPE_AND_OBJECT_ID(POLL),
    /** Returns the specified poll. */
    POLLSERVICE_GET_POLL(POLL),
    /** Returns a count of all polls, both active and inactive. */
    POLLSERVICE_GET_POLL_COUNT(POLL),
    /**
     * Returns a count of polls, both active and inactive, associated with the object
     * specified by the objectType and objectID.
     */
    POLLSERVICE_GET_POLL_COUNT_BY_OBJECT_TYPE_AND_OBJECT_ID(POLL),
    /** Returns a list of all polls, both active and inactive. */
    POLLSERVICE_GET_POLLS(POLL),
    /**
     * Returns a list of polls, both active and inactive, associated with the object
     * specified by the objectType and objectID.
     */
    POLLSERVICE_GET_POLLS_BY_OBJECT_TYPE_AND_OBJECT_ID(POLL),
    /** Returns a count of all user votes for all options in the poll. */
    POLLSERVICE_GET_USER_VOTE_COUNT(POLL),
    /** Returns a count of all user votes for the specified option in the poll. */
    POLLSERVICE_GET_USER_VOTE_COUNT_BY_INDEX(POLL),
    /**
     * Returns a list of option indexes corresponding to the user votes, or an empty
     * array if the user has not voted.
     */
    POLLSERVICE_GET_USER_VOTE_INDICES(POLL),
    /**
     * Returns a List of User objects for users who have voted for any options in the
     * poll.
     */
    POLLSERVICE_GET_USER_VOTES(POLL),
    /**
     * Returns a list of User objects for users who have voted for the option at the
     * given index.
     */
    POLLSERVICE_GET_USER_VOTES_BY_INDEX(POLL),
    /**
     * Returns a count of all votes (both guest and user votes) for all options in
     * the poll.
     */
    POLLSERVICE_GET_VOTE_COUNT(POLL),
    /**
     * Returns a count of all votes (both guest and user votes) for the specified
     * option in the poll.
     */
    POLLSERVICE_GET_VOTE_COUNT_BY_INDEX(POLL),
    /**
     * Returns true if the guest associated with the uniqueID has previously voted in
     * the poll, false otherwise.
     */
    POLLSERVICE_HAS_ANONYMOUS_VOTED(POLL),
    /**
     * Returns true if the user specified has previously voted in the poll, false
     * otherwise.
     */
    POLLSERVICE_HAS_USER_VOTED(POLL),
    /** Returns true if the mode specified is enabled for the poll, false otherwise. */
    POLLSERVICE_IS_MODE_ENABLED(POLL),
    /** Remove a guest vote. */
    POLLSERVICE_REMOVE_ANONYMOUS_VOTE(POLL),
    /** Remove a user vote. */
    POLLSERVICE_REMOVE_USER_VOTE(POLL),
    /** Sets a mode to be enabled or disabled for the poll. */
    POLLSERVICE_SET_MODE(POLL),
    /** Sets the text of the option at the specified index. */
    POLLSERVICE_SET_OPTION(POLL),
    /** Moves the option's index. */
    POLLSERVICE_SET_OPTION_INDEX(POLL),
    /** Update the poll. */
    POLLSERVICE_UPDATE_POLLSERVICE(POLL),
    /** Creates a new private message folder for the specified user. */
    PRIVATE_MESSAGE_SERVICE_CREATE_FOLDER(PRIVATE_MESSAGE),
    /** Creates a new private message from the specified user. */
    PRIVATE_MESSAGE_SERVICE_CREATE_MESSAGE(PRIVATE_MESSAGE),
    /** Deletes the specified message folder. */
    PRIVATE_MESSAGE_SERVICE_DELETE_FOLDER(PRIVATE_MESSAGE),
    /**
     * Deletes a private message from the specified folder by moving it to the trash
     * folder.
     */
    PRIVATE_MESSAGE_SERVICE_DELETE_MESSAGE(PRIVATE_MESSAGE),
    /** Returns the specified message folder for a user. */
    PRIVATE_MESSAGE_SERVICE_GET_FOLDER(PRIVATE_MESSAGE),
    /** Returns a list of message folders for the specified user. */
    PRIVATE_MESSAGE_SERVICE_GET_FOLDERS(PRIVATE_MESSAGE),
    /** Returns the specified private message. */
    PRIVATE_MESSAGE_SERVICE_GET_MESSAGE(PRIVATE_MESSAGE),
    /** Returns the total number of private messages a user has in their mailbox. */
    PRIVATE_MESSAGE_SERVICE_GET_MESSAGE_COUNT(PRIVATE_MESSAGE),
    /** Returns the number of messages in the specified folder. */
    PRIVATE_MESSAGE_SERVICE_GET_MESSAGE_COUNT_FOR_FOLDER(PRIVATE_MESSAGE),
    /**
     * Returns all the messages in the specified folder sorted by date in descending
     * order.
     */
    PRIVATE_MESSAGE_SERVICE_GET_MESSAGES(PRIVATE_MESSAGE),
    /** Returns the total number of unread messages a user has in their mailbox. */
    PRIVATE_MESSAGE_SERVICE_GET_UNREAD_MESSAGE_COUNT(PRIVATE_MESSAGE),
    /**
     * Returns the total number of unread private messages a user has in the
     * specified folder.
     */
    PRIVATE_MESSAGE_SERVICE_GET_UNREAD_MESSAGE_COUNT_FOR_FOLDER(PRIVATE_MESSAGE),
    /**
     * Returns <tt>true</tt> if private messaging is enabled; <tt>false</tt>
     * otherwise.
     */
    PRIVATE_MESSAGE_SERVICE_IS_PRIVATE_MESSAGES_ENABLED(PRIVATE_MESSAGE),
    /** Moves a private message to another message folder. */
    PRIVATE_MESSAGE_SERVICE_MOVE_MESSAGE(PRIVATE_MESSAGE),
    /**
     * Saves a message as a draft by storing it in the sender's <tt>Drafts</tt>
     * folder.
     */
    PRIVATE_MESSAGE_SERVICE_SAVE_MESSAGE_AS_DRAFT(PRIVATE_MESSAGE),
    /** Sends a private message to another user. */
    PRIVATE_MESSAGE_SERVICE_SEND_MESSAGE(PRIVATE_MESSAGE),
    /**
     * access, update, and remove profile fields data. All user profile data is
     * managed via the ProfileService.
     */
    PROFILE_FIELD_SERVICE_DEFINES_METHODS_USED_TO_CREATE(PROFILE_FIELD),
    /** Creates a new profile field. */
    PROFILE_FIELD_SERVICE_CREATE_PROFILE_FIELD(PROFILE_FIELD),
    /** Removes a profile field from the system. */
    PROFILE_FIELD_SERVICE_DELETE_PROFILE_FIELD(PROFILE_FIELD),
    /** Edits the profile field data. */
    PROFILE_FIELD_SERVICE_EDIT_PROFILE_FIELD(PROFILE_FIELD),
    /** Edits the objects for a profile field. */
    PROFILE_FIELD_SERVICE_EDIT_PROFILE_FIELD_OPTIONS(PROFILE_FIELD),
    /** Returns a list of all default profile fields. */
    PROFILE_FIELD_SERVICE_GET_DEFAULT_FIELDS(PROFILE_FIELD),
    /** Gets a profile field object by its id. */
    PROFILE_FIELD_SERVICE_GET_PROFILE_FIELD(PROFILE_FIELD),
    /** Gets the list of all profile fields in the system. */
    PROFILE_FIELD_SERVICE_GET_PROFILE_FIELDS(PROFILE_FIELD),
    /** Sets the index of the profile field. */
    PROFILE_FIELD_SERVICE_SET_INDEX(PROFILE_FIELD),
    /** Returns the the first 5 users that are similar to the specified user. */
    PROFILE_SEARCH_SERVICE_GET_SIMILAR_USER_RESULTS(PROFILE_SEARCH),
    /** Returns true if the profile search feature is turned on. */
    PROFILE_SEARCH_SERVICE_IS_SEARCH_ENABLED(PROFILE_SEARCH),
    /** Returns the users that correspond to the search query. */
    PROFILE_SEARCH_SERVICE_SEARCH(PROFILE_SEARCH),
    /**
     * Returns the users that correspond to the search query beginning at startIndex
     * and until the number results equals numResults.
     */
    PROFILE_SEARCH_SERVICE_SEARCH_BOUNDED(PROFILE_SEARCH),
    /** access, update, and remove user profile data. */
    PROFILESERVICE_MANAGES_USER_PROFILE_DATA_DEFINES_METHODS_USED_TO_CREATE(PROFILE),
    /** Adds a new profile entry to a user. */
    PROFILESERVICE_ADD_PROFILE(PROFILE),
    /** Removes all user profile data associated with a particular profile field. */
    PROFILESERVICE_DELETE_PROFILE_BY_ID(PROFILE),
    /** Removes all user profile data associated with a particular user. */
    PROFILESERVICE_DELETE_PROFILE_BY_USER_ID(PROFILE),
    /** Deletes all status information for the specified user. */
    PROFILESERVICE_DELETE_USER_STATUS(PROFILE),
    /** Retrieves the current status for the specified user. */
    PROFILESERVICE_GET_CURRENT_STATUS(PROFILE),
    /**
     * Gets a map of user profile values for a particular user mapped to their
     * corresponding <tt>ProfileField</tt> id.
     */
    PROFILESERVICE_GET_PROFILE(PROFILE),
    /** Returns the profile image for a user. */
    PROFILESERVICE_GET_PROFILE_IMAGE(PROFILE),
    /** Returns a list of recent user status updates sorted newest first. */
    PROFILESERVICE_GET_RECENT_STATUS_UPDATES(PROFILE),
    /**
     * Returns a list of recent status updates for the specified user sorted newest
     * first.
     */
    PROFILESERVICE_GET_RECENT_STATUS_UPDATES_FOR_USER(PROFILE),
    /** Returns the max length permitted for a status message. */
    PROFILESERVICE_GET_STATUS_MESSAGE_MAX_LENGTH(PROFILE),
    /**
     * Returns a list of today's recent status updates for the specified user sorted
     * newest first.
     */
    PROFILESERVICE_GET_TODAYS_STATUS_UPDATES(PROFILE),
    /** Retrieves the user status corresponding to the given status ID */
    PROFILESERVICE_GET_USER_STATUS(PROFILE),
    /**
     * Returns a list of yesterday's recent status updates for the specified user
     * sorted newest first.
     */
    PROFILESERVICE_GET_YESTERDAYS_STATUS_UPDATES(PROFILE),
    /** Returns true if the user status manager is enabled, false otherwise. */
    PROFILESERVICE_IS_STATUS_UPDATES_ENABLED(PROFILE),
    /** Set the current status for a user */
    PROFILESERVICE_SET_CURRENT_STATUS(PROFILE),
    /** Sets a array of profile values for a particular user. */
    PROFILESERVICE_SET_PROFILE(PROFILE),
    /** Set a new profile page image for the specified user. */
    PROFILESERVICE_SET_PROFILE_IMAGE(PROFILE),
    /** Creates a new project as a child of the parent container. */
    PROJECTSERVICE_CREATE_PROJECTSERVICE(PROJECT),
    /** Deletes a project and all of its content. */
    PROJECTSERVICE_DELETE_PROJECTSERVICE(PROJECT),
    /** Returns a list of checkpoints for the specified project. */
    PROJECTSERVICE_GET_CHECK_POINTS(PROJECT),
    /** Returns the specified project. */
    PROJECTSERVICE_GET_PROJECT_BY_ID(PROJECT),
    /***/
    PROJECTSERVICE_GET_PROJECT_COUNT(PROJECT),
    /** Returns a list of the projects. */
    PROJECTSERVICE_GET_PROJECTS(PROJECT),
    /** Returns the count of unique users that own tasks in the specified project. */
    PROJECTSERVICE_GET_USER_COUNT(PROJECT),
    /** Sets the lists of checkpoints for the project. */
    PROJECTSERVICE_SET_CHECK_POINTS(PROJECT),
    /** Saves project changes and broadcasts changes across the cluster. */
    PROJECTSERVICE_UPDATE_PROJECTSERVICE(PROJECT),
    /** Add a rating to the JiveContentObject. */
    RATINGSSERVICE_ADD_RATING(RATINGS),
    /** Create a new rating with the specified attributes. */
    RATINGSSERVICE_CREATE_RATING(RATINGS),
    /** Returns the count of currently available ratings. */
    RATINGSSERVICE_GET_AVAILABLE_RATING_COUNT(RATINGS),
    /** Returns an iterable of Rating objects that list all the available ratings. */
    RATINGSSERVICE_GET_AVAILABLE_RATINGS(RATINGS),
    /**
     * A convenience method which returns a geometric mean average of all the ratings
     * given to the JiveContentObject.
     */
    RATINGSSERVICE_GET_MEAN_RATING(RATINGS),
    /**
     * Returns the rating associated with the user, or null if this user hasn't rated
     * the JiveContentObject.
     */
    RATINGSSERVICE_GET_RATING(RATINGS),
    /** Returns the total number of ratings given to the JiveContentObject. */
    RATINGSSERVICE_GET_RATING_COUNT(RATINGS),
    /** Retrieve the rating with the specified score. */
    RATINGSSERVICE_GET_RATING_FROM_SCORE(RATINGS),
    /** Returns an Iterable of all the ratings given to the JiveContentObject. */
    RATINGSSERVICE_GET_RATINGS(RATINGS),
    /** Returns whether the user has rated the JiveContentObject or not. */
    RATINGSSERVICE_HAS_RATED(RATINGS),
    /** Returns true if the rating feature is turned on. */
    RATINGSSERVICE_IS_RATINGS_ENABLED(RATINGS),
    /** Remove the specified rating from the list of currently available ratings. */
    RATINGSSERVICE_REMOVE_RATING(RATINGS),
    /** Enables or disables the ratings feature. */
    RATINGSSERVICE_SET_RATINGS_ENABLED(RATINGS),
    /**
     * REFERENCES_ARE_USE_TO_CREATE_A_RELATIONSHIP between one kind of jive object to
     * another. For instance a blog may reference a specific thread.
     */
    /** Creates a reference between the refering object and the references. */
    REFERENCESERVICE_ADD_REFERENCE(REFERENCE),
    /** Removes all references from the specified referer. */
    REFERENCESERVICE_DELETE_ALL_REFERENCES(REFERENCE),
    /** Causes this object to not be referred by any other objects. */
    REFERENCESERVICE_DELETE_ALL_REFERERS(REFERENCE),
    /** Delete the reference between a referer and the refered content. */
    REFERENCESERVICE_DELETE_REFERENCE(REFERENCE),
    /** Get all objects that the specfied jiveObject referers too. */
    REFERENCESERVICE_GET_REFERENCES(REFERENCE),
    /** Get a list of all the objects that refer to this specified object. */
    REFERENCESERVICE_GET_REFERERS(REFERENCE),
    /** Returns the number of possible results for the specified query. */
    SEARCHSERVICE_COUNT_QUICK_MESSAGE_SEARCH_RESULTS_BY_COMMUNITY_ID(SEARCH),
    /** Returns the number of possible results for the specified query. */
    SEARCHSERVICE_COUNT_QUICK_SEARCH_RESULTS(SEARCH),
    /** Returns the number of possible results for the specified query. */
    SEARCHSERVICE_COUNT_SEARCH_RESULTS(SEARCH),
    /** Returns the number of possible results for the specified query by category. */
    SEARCHSERVICE_COUNT_SEARCH_RESULTS_BY_COMMUNITY_ID(SEARCH),
    /** Provides the ability to do quick search queries based on the provided string. */
    SEARCHSERVICE_QUICK_MESSAGE_SEARCH_BY_COMMUNITY_ID(SEARCH),
    /** Provides the ability to do quick search queries based on the provided string. */
    SEARCHSERVICE_QUICK_SEARCH(SEARCH),
    /**
     * Provides the ability to create complex search queries with the ability to
     * change sorting, filtering, etc.
     */
    SEARCHSERVICE_SEARCH_SEARCHSERVICE(SEARCH),
    /**
     * Provides the ability to create complex search queries with the ability to
     * change sorting, filtering, etc. all by category.
     */
    SEARCHSERVICE_SEARCH_BY_COMMUNITIES(SEARCH),
    /**
     * Add the user with the specified userID to the social group with the specified
     * socialGroupID.
     */
    SOCIAL_GROUP_SERVICE_ADD_MEMBER(SOCIAL_GROUP),
    /** Creates a new social group. */
    SOCIAL_GROUP_SERVICE_CREATE_SOCIAL_GROUP(SOCIAL_GROUP),
    /** Delete the social group with the specified id. */
    SOCIAL_GROUP_SERVICE_DELETE_SOCIAL_GROUP(SOCIAL_GROUP),
    /** Returns a count of all members in a group */
    SOCIAL_GROUP_SERVICE_GET_MEMBER_COUNT(SOCIAL_GROUP),
    /** Returns an array of all members of a particular social group. */
    SOCIAL_GROUP_SERVICE_GET_MEMBERS(SOCIAL_GROUP),
    /** Returns a WSSocialGroup by its ID. */
    SOCIAL_GROUP_SERVICE_GET_SOCIAL_GROUP(SOCIAL_GROUP),
    /** Returns a WSSocialGroup by its displayName. */
    SOCIAL_GROUP_SERVICE_GET_SOCIAL_GROUP_BY_NAME(SOCIAL_GROUP),
    /** Returns a count of all social groups in the system. */
    SOCIAL_GROUP_SERVICE_GET_SOCIAL_GROUP_COUNT(SOCIAL_GROUP),
    /**
     * Returns an array of all the social group names for all the social groups in
     * the system.
     */
    SOCIAL_GROUP_SERVICE_GET_SOCIAL_GROUP_NAMES(SOCIAL_GROUP),
    /**
     * Returns an array of the social group names beginning at startIndex and until
     * the number results equals numResults.
     */
    SOCIAL_GROUP_SERVICE_GET_SOCIAL_GROUP_NAMES_BOUNDED(SOCIAL_GROUP),
    /**
     * Returns an array of all the social group IDs for all the social groups in the
     * system.
     */
    SOCIAL_GROUP_SERVICE_GET_SOCIAL_GROUPS(SOCIAL_GROUP),
    /** Returns an array of social group names that an entity belongs to. */
    SOCIAL_GROUP_SERVICE_GET_USER_SOCIAL_GROUP_NAMES(SOCIAL_GROUP),
    /** Returns an array of all the social group IDs that a user belongs too. */
    SOCIAL_GROUP_SERVICE_GET_USER_SOCIAL_GROUPS(SOCIAL_GROUP),
    /**
     * Remove the user with the specified id from the social group with the specified
     * id.
     */
    SOCIAL_GROUP_SERVICE_REMOVE_MEMBER(SOCIAL_GROUP),
    /** Returns an array of WSSocialGroup filtered. */
    SOCIAL_GROUP_SERVICE_SEARCH_SOCIAL_GROUPS(SOCIAL_GROUP),
    /** Update the following social group in the system. */
    SOCIAL_GROUP_SERVICE_UPDATE_SOCIAL_GROUP(SOCIAL_GROUP),
    /** Rewards points to a user. */
    STATUS_LEVEL_SERVICE_ADD_POINTS(STATUS_LEVEL),
    /** Rewards points to a user. */
    STATUS_LEVEL_SERVICE_ADD_POINTS_2(STATUS_LEVEL),
    /** Creates a new points based StatusLevel. */
    STATUS_LEVEL_SERVICE_CREATE_STATUS_LEVEL(STATUS_LEVEL),
    /** Creates a new group based StatusLevel Level */
    STATUS_LEVEL_SERVICE_CREATE_STATUS_LEVEL_2(STATUS_LEVEL),
    /** Deletes a statusLevel level from the system */
    STATUS_LEVEL_SERVICE_DELETE_STATUS_LEVEL(STATUS_LEVEL),
    /** Returns all of the WSStatusLevelScenario objects. */
    STATUS_LEVEL_SERVICE_GET_ALL_STATUS_LEVEL_SCENARIOS(STATUS_LEVEL),
    /**
     * If there is a status level associated with the group passed in then the status
     * level will be returned, Otherwise null will be returned.
     */
    STATUS_LEVEL_SERVICE_GET_GROUP_STATUS_LEVEL(STATUS_LEVEL),
    /** Returns an array of all group based status levels in the system. */
    STATUS_LEVEL_SERVICE_GET_GROUP_STATUS_LEVELS(STATUS_LEVEL),
    /** Returns an array of system wide leaders. */
    STATUS_LEVEL_SERVICE_GET_LEADERS(STATUS_LEVEL),
    /** Returns an array of system wide leaders. */
    STATUS_LEVEL_SERVICE_GET_LEADERS_2(STATUS_LEVEL),
    /** Returns an Iterable of leaders for a specific community */
    STATUS_LEVEL_SERVICE_GET_LEADERS_BY_COMMUNITY(STATUS_LEVEL),
    /** Returns an Iterable of leaders for a specific container */
    STATUS_LEVEL_SERVICE_GET_LEADERS_BY_CONTAINER(STATUS_LEVEL),
    /** Returns an Iterable of leaders for a specific community */
    STATUS_LEVEL_SERVICE_GET_LEADERS_3(STATUS_LEVEL),
    /** Returns an Iterable of leaders for a specific container */
    STATUS_LEVEL_SERVICE_GET_LEADERS_4(STATUS_LEVEL),
    /** Returns the point level for a user system wide. */
    STATUS_LEVEL_SERVICE_GET_POINT_LEVEL(STATUS_LEVEL),
    /** Returns the status level points for a user in regards to a specific community */
    STATUS_LEVEL_SERVICE_GET_POINT_LEVEL_2(STATUS_LEVEL),
    /** Returns the status level points for a user in regards to a specific container */
    STATUS_LEVEL_SERVICE_GET_POINT_LEVEL_3(STATUS_LEVEL),
    /**
     * Returns an array of point based status levels in the system sorted by point
     * range.
     */
    STATUS_LEVEL_SERVICE_GET_POINT_STATUS_LEVELS(STATUS_LEVEL),
    /** Used to acquire a specific status level object from the system */
    STATUS_LEVEL_SERVICE_GET_STATUS_LEVEL(STATUS_LEVEL),
    /** Used to get a status level by a point value. */
    STATUS_LEVEL_SERVICE_GET_STATUS_LEVEL_BY_POINTS(STATUS_LEVEL),
    /** Returns a WSStatusLevelScenario by its code. */
    STATUS_LEVEL_SERVICE_GET_STATUS_LEVEL_SCENARIO_BY_CODE(STATUS_LEVEL),
    /** Returns a WSStatusLevelScenario by its code. */
    STATUS_LEVEL_SERVICE_GET_STATUS_LEVEL_SCENARIO_BY_CODE_2(STATUS_LEVEL),
    /**
     * Returns the system wide status level for specific user, will return null if
     * there is no status level for this user.
     */
    STATUS_LEVEL_SERVICE_GET_USER_STATUS_LEVEL(STATUS_LEVEL),
    /** Returns true if status levels are enabled in the system */
    STATUS_LEVEL_SERVICE_IS_STATUS_LEVELS_ENABLED(STATUS_LEVEL),
    /** Sets whether status levels should be enabled in the system. */
    STATUS_LEVEL_SERVICE_SET_STATUS_LEVELS_ENABLED(STATUS_LEVEL),
    /**
     * Update the points and whether or not this scenario is included in status level
     * results.
     */
    STATUS_LEVEL_SERVICE_UPDATE_STATUS_LEVEL_SCENARIO(STATUS_LEVEL),
    /** Deletes a Jive System Property. */
    SYSTEM_PROPERTIES_SERVICE_DELETE_PROPERTY(SYSTEM_PROPERTIES),
    /** Obtains all Jive System Properties. */
    SYSTEM_PROPERTIES_SERVICE_GET_PROPERTIES(SYSTEM_PROPERTIES),
    /** Saves a name/value pair as a Jive System Property. */
    SYSTEM_PROPERTIES_SERVICE_SAVE_PROPERTY(SYSTEM_PROPERTIES),
    /** Associates a tag with this object */
    TAGSERVICE_ADD_TAG(TAG),
    /** Creates a tag in the database. */
    TAGSERVICE_CREATE_TAG(TAG),
    /** Returns a tag given a tag ID. */
    TAGSERVICE_GET_TAG_BY_ID(TAG),
    /** Returns a tag by tag name. */
    TAGSERVICE_GET_TAG_BY_NAME(TAG),
    /** Return an Iterable for all the tags associated with this manager. */
    TAGSERVICE_GET_TAGS(TAG),
    /** Disassociates this object with all tags. */
    TAGSERVICE_REMOVE_ALL_TAGS(TAG),
    /** Disassociates this object with the given tag. */
    TAGSERVICE_REMOVE_TAG(TAG),
    /** Creates a new task within the provided project. */
    TASKSERVICE_CREATE_TASKSERVICE(TASK),
    /** Creates a new personal task. */
    TASKSERVICE_CREATE_PERSONAL_TASK(TASK),
    /** Delete a task. */
    TASKSERVICE_DELETE_TASKSERVICE(TASK),
    /** Returns a count of all the incomplete tasks in the system. */
    TASKSERVICE_GET_TASK_COUNT(TASK),
    /**
     * Returns a count of all the incomplete tasks in the system that match the
     * provided result filter.
     */
    TASKSERVICE_GET_TASK_COUNT_WITH_FILTER(TASK),
    /** Retrieves the task with the given ID. */
    TASKSERVICE_GET_TASKBY_ID(TASK),
    /** Returns a system wide iterator of incomplete tasks. */
    TASKSERVICE_GET_TASKS(TASK),
    /** Returns all the tasks of a project. */
    TASKSERVICE_GET_TASKS_BY_PROJECT(TASK),
    /** Returns an iterator of tasks that match the provided result filter. */
    TASKSERVICE_GET_TASKS_WITH_FILTER(TASK),
    /** Returns all the incomplete tasks of a user. */
    TASKSERVICE_GET_UNCOMPLETE_TASKS_BY_USER_ID(TASK),
    /** Persist updates to a task to storage. */
    TASKSERVICE_UPDATE_TASKSERVICE(TASK),
    /**
     * Creates a new user account from a minimum of information: username, password,
     * and email address.
     */
    USERSERVICE_CREATE_USER(USER),
    /** Creates a new user account from user data. */
    USERSERVICE_CREATE_USER_WITH_USER(USER),
    /** Deletes an extended property from the specified user account. */
    USERSERVICE_DELETE_USER_PROPERTY(USER),
    /** Disables a user account. */
    USERSERVICE_DISABLE_USER(USER),
    /** Enables a user account. */
    USERSERVICE_ENABLE_USER(USER),
    /** Returns the user specified by ID. */
    USERSERVICE_GET_USER(USER),
    /** Returns the user account corresponding to the specified email address. */
    USERSERVICE_GET_USER_BY_EMAIL_ADDRESS(USER),
    /** Returns the user specified by username (case-insensitive). */
    USERSERVICE_GET_USER_BY_USERNAME(USER),
    /** Returns the number of users in the system. */
    USERSERVICE_GET_USER_COUNT(USER),
    /** Returns all of the userNames in the system. */
    USERSERVICE_GET_USER_NAMES(USER),
    /** Returns the extended properties for the specified user account. */
    USERSERVICE_GET_USER_PROPERTIES(USER),
    /** Returns the IDs of the first 1000 users. */
    USERSERVICE_GET_USERS(USER),
    /**
     * Returns the IDs of users begining at startIndex and until the number results
     * equals numResults.
     */
    USERSERVICE_GET_USERS_BOUNDED(USER),
    /** Returns true if this UserService is read-only. */
    USERSERVICE_IS_READ_ONLY(USER),
    /** Changes the specified user's password. */
    USERSERVICE_SET_PASSWORD(USER),
    /** Sets an extended property for the specified user. */
    USERSERVICE_SET_USER_PROPERTY(USER),
    /** Updates information for the specified user. */
    USERSERVICE_UPDATE_USER(USER),
    /** Creates a new video in the specified container. */
    VIDEOSERVICE_CREATE_VIDEO(VIDEO),
    /** Deletes the specified video. */
    VIDEOSERVICE_DELETE_VIDEO(VIDEO),
    /** Returns the specified video. */
    VIDEOSERVICE_GET_VIDEO(VIDEO),
    /** Returns a list of videos in the specified container. */
    VIDEOSERVICE_GET_VIDEOS_FOR_CONTAINER(VIDEO),
    /** Updates the specified video. */
    VIDEOSERVICE_UPDATE_VIDEO(VIDEO),
    /** Create a watch on a community for the specified user. */
    WATCHSERVICE_CREATE_COMMUNITY_WATCH(WATCH),
    /** Create a watch on a thread for the specified user. */
    WATCHSERVICE_CREATE_THREAD_WATCH(WATCH),
    /** Create a watch on a user for the specified user. */
    WATCHSERVICE_CREATE_USER_WATCH(WATCH),
    /** Delete the specified watch. */
    WATCHSERVICE_DELETE_WATCH(WATCH),
    /** Deletes all watches that a user has. */
    WATCHSERVICE_DELETE_WATCHES(WATCH),
    /** Returns a watch on a particular community, or null if there isn't a watch. */
    WATCHSERVICE_GET_COMMUNITY_WATCH(WATCH),
    /**
     * Return the count of all community watches in a particular communityID for the
     * given userID.
     */
    WATCHSERVICE_GET_COMMUNITY_WATCH_COUNT(WATCH),
    /**
     * Returns an array of IDs for all the community objects a user is watching in a
     * community.
     */
    WATCHSERVICE_GET_COMMUNITY_WATCHES(WATCH),
    /**
     * Returns the number of days that a watched object can remain inactive before
     * watches on that object are deleted.
     */
    WATCHSERVICE_GET_DELETE_DAYS(WATCH),
    /** Returns a watch on a particular thread, or null if there isn't a watch. */
    WATCHSERVICE_GET_THREAD_WATCH(WATCH),
    /** Returns a count of all watches that a userID has of a particular type. */
    WATCHSERVICE_GET_TOTAL_WATCH_COUNT(WATCH),
    /** Returns a watch on a particular user, or null if there isn't a watch. */
    WATCHSERVICE_GET_USER_WATCH(WATCH),
    /**
     * Returns an array of Watch objects for a particular object type that the given
     * user is watching.
     */
    WATCHSERVICE_GET_WATCH_LIST(WATCH),
    /** Returns all the users who are watching this objectType and objectID. */
    WATCHSERVICE_GET_WATCH_USERS(WATCH),
    /** Returns true if the user is watching the specified community. */
    WATCHSERVICE_IS_COMMUNITY_WATCHED(WATCH),
    /** Returns true if the user is watching the specified thread. */
    WATCHSERVICE_IS_THREAD_WATCHED(WATCH),
    /** Returns true if the user is watching the specified user. */
    WATCHSERVICE_IS_USER_WATCHED(WATCH),
    /**
     * Sets the number of days that a watched object can remain inactive before
     * watches on that object are deleted.
     */
    WATCHSERVICE_SET_DELETE_DAYS(WATCH);

    private Operation(final EntityTypeName type)
    {
    }

    private Operation(final CustomOp customType)
    {
    }

    private Operation(final EntityTypeName type, final int strategy)
    {
    }
    
   }
