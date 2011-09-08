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

import static org.mule.modules.jive.api.EntityTypeName.*;

import org.mule.modules.jive.api.EntityTypeName;

import org.apache.commons.lang.StringUtils;

/** Enum for the custom operations. */
public enum CustomOp
{

    ADDRESSBOOK_ADD_USER(ADDRESSBOOK, "addressbooks", "POST", "addUser"), //
    ADDRESSBOOK_GET_ROSTER(ADDRESSBOOK, "addressbooks/{userID}", "GET"), //
    ADDRESSBOOK_REMOVE_USER(ADDRESSBOOK, "addressbooks/{userID}/{usernameToRemove}", "DELETE"), //
    AUDIT_EVENT(AUDIT, "audit", "POST", "auditEvent"), //
    AVATAR_CREATE_AVATAR(AVATAR, "avatars", "POST", "createAvatar"), //
    AVATAR_DELETE(AVATAR, "avatar/{avatarID}", "DELETE"), //
    AVATAR_GET_ACTIVE(AVATAR, "activeAvatar/{userID}", "GET"), //
    AVATAR_GET(AVATAR, "avatarByID/{avatarID}", "GET"), //
    AVATAR_GET_AVATAR_COUNT(AVATAR, "avatarCount/{userID}", "GET"), //
    AVATAR_GET_AVATARS(AVATAR, "avatarsByUser/{userID}", "GET"), //
    AVATAR_GET_GLOBAL_AVATARS(AVATAR, "globalAvatars", "GET"), //
    AVATAR_GET_MAX_ALLOWABLE_HEIGHT(AVATAR, "avatarMaxAllowableHeight", "GET"), //
    AVATAR_GET_MAX_ALLOWABLE_WIDTH(AVATAR, "avatarMaxAllowableWidth", "GET"), //
    AVATAR_GET_MAX_USER_AVATARS(AVATAR, "maxUserAvatars", "GET"), //
    AVATAR_GET_MODERATION_AVATAR_COUNT(AVATAR, "moderationAvatarCount", "GET"), //
    AVATAR_GET_MODERATION_AVATARS(AVATAR, "moderationAvatars", "GET"), //
    AVATAR_IS_ALLOW_IMAGE_RESIZE(AVATAR, "avatarAllowImageResize", "GET"), //
    AVATAR_IS_AVATARS_ENABLED(AVATAR, "avatarsEnabled", "GET"), //
    AVATAR_IS_MODERATE_USER_AVATARS(AVATAR, "moderateUserAvatars", "GET"), //
    AVATAR_IS_USER_AVATARS_ENABLED(AVATAR, "userAvatarsEnabled", "GET"), //
    AVATAR_SET_ACTIVE_AVATAR(AVATAR, "activeAvatar", "POST", "setActiveAvatar"), //
    AVATAR_SET_ALLOW_IMAGE_RESIZE(AVATAR, "avatarAllowImageResize", "POST", "setAllowImageResize"), //
    AVATAR_SET_MAX_ALLOWABLE_HEIGHT(AVATAR, "avatarMaxAllowableHeight", "POST", "setMaxAllowableHeight"), //
    AVATAR_SET_MAX_ALLOWABLE_WIDTH(AVATAR, "avatarMaxAllowableWidth", "POST", "setMaxAllowableWidth"), //
    AVATAR_SET_MAX_USER_AVATARS(AVATAR, "maxUserAvatars", "POST", "setMaxUserAvatars"), //
    AVATAR_SET_MODERATE_USER_AVATARS(AVATAR, "moderateUserAvatars", "POST", "setModerateUserAvatars"), //
    AVATAR_SET_USER_AVATARS_ENABLED(AVATAR, "userAvatarsEnabled", "POST", "setUserAvatarsEnabled"), //
    COMMENT_ADD(COMMENT, "comments", "POST", "addComment"), //
    COMMENT_ADD_COMMENT_TO_COMMENT(COMMENT, "comments/addChild", "POST", "addCommentToComment"), //
    COMMENT_DELETE_ALL(COMMENT, "comments/{objectType}/{objectID}", "DELETE"), //
    COMMENT_DELETE(COMMENT, "comments/{objectType}/{objectID}/{commentID}", "DELETE"), //
    COMMENT_DELETE_RECURSIVE(COMMENT,
                    "comments/recursiveDelete/{objectType}/{objectID}/{commentID}/{recursive}", "DELETE"), //
    COMMENT_GET(COMMENT, "comments/{objectType}/{objectID}/{commentID}", "GET"), //
    COMMENT_GET_COMMENT_COUNT(COMMENT, "commentcount/{objectType}/{objectID}", "GET"), //
    COMMENT_GET_COMMENT_COUNT_WITH_FILTER(COMMENT, "comments/count", "POST", "getCommentCountWithFilter"), //
    COMMENT_GET_ALL(COMMENT, "comments/{objectType}/{objectID}", "GET"), //
    COMMENT_GET_USER_CONTENT_COMMENT_COUNT(COMMENT, "usercommentcount/{userID}", "GET"), //
    COMMENT_GET_USER_CONTENT_COMMENT_COUNT_WITH_FILTER(COMMENT, "comments/user/count", "POST",
                    "getUserContentCommentCountWithFilter"), //
    COMMENT_GET_USER_CONTENT_COMMENTS(COMMENT, "usercomments/{userID}", "GET"), //
    COMMENT_GET_USER_CONTENT_COMMENTS_WITH_FILTER(COMMENT, "comments/user", "POST",
                    "getUserContentCommentsWithFilter"), //
    COMMENT_UPDATE(COMMENT, "comments", "PUT", "updateComment"), //
    BLOG_ADD_ATTACHMENT_TO_BLOG_POST(BLOG, "attachments", "POST", "addAttachmentToBlogPost"), //
    BLOG_ADD_IMAGE_TO_BLOG_POST(BLOG, "images", "POST", "addImageToBlogPost"), //
    BLOG_CREATE(BLOG, "blogs", "POST", "createBlog"), //
    BLOG_CREATE_BLOG_POST(BLOG, "blogPosts", "POST", "createBlogPost"), //
    BLOG_DELETE(BLOG, "blogs/{blogID}", "DELETE"), //
    BLOG_DELETE_BLOG_POST(BLOG, "blogPosts/{blogPostID}", "DELETE"), //
    BLOG_GET_ATTACHMENTS_BY_BLOG_POST_ID(BLOG, "attachments/{blogPostID}", "GET"), //
    BLOG_GET_BLOG_BY_ID(BLOG, "blogsByID/{blogID}", "GET"), //
    BLOG_GET_BLOG_BY_NAME(BLOG, "blogsByName/{blogName}", "GET"), //
    BLOG_GET_BLOG_COUNT(BLOG, "blogCount", "GET"), //
    BLOG_GET_BLOG_COUNT_BY_FILTER(BLOG, "blogCount", "POST", "getBlogCount"), //
    BLOG_GET_BLOG_COUNT_FOR_USER(BLOG, "userBlogCount/{userID}", "GET"), //
    BLOG_GET_BLOG_POST(BLOG, "blogPosts/{blogPostID}", "GET"), //
    BLOG_GET_BLOG_POST_COUNT(BLOG, "blogPostCount", "GET"), //
    BLOG_GET_BLOG_POST_COUNT_BY_FILTER(BLOG, "blogPostCount", "POST", "getBlogPostCount"), //
    BLOG_GET_BLOG_POSTS_BY_FILTER(BLOG, "blogsPostsWithFilter", "POST", "getBlogPosts"), //
    BLOG_GET_BLOGS_BY_DISPLAY_NAME(BLOG, "blogsByDisplayName/{query}/{startIndex}/{endIndex}/{numResults}",
                    "GET"), //
    BLOG_GET_BLOGS_FOR_USER(BLOG, "userBlogs/{userID}", "GET"), //
    BLOG_GET_COMMENT_COUNT(BLOG, "commentCount", "GET"), //
    BLOG_GET_COMMENT_COUNT_BY_FILTER(BLOG, "commentCountWithFilter", "POST", "getCommentCount"), //
    BLOG_GET_COMMENTS_BY_FILTER(BLOG, "commentsWithFilter", "POST", "getComments"), //
    BLOG_GET_IMAGES_BY_BLOG_POST_ID(BLOG, "images/{blogPostID}", "GET"), //
    BLOG_GET_PING_SERVICES(BLOG, "pingServices", "GET"), //
    BLOG_GET_RECENT_BLOGS(BLOG, "recentBlogs", "GET"), //
    BLOG_GET_TAGS(BLOG, "tags", "GET"), //
    BLOG_GET_TAGS_BY_FILTER(BLOG, "tags", "POST", "getTagsResponse"), //
    BLOG_IS_BLOGS_ENABLED(BLOG, "blogsEnabled", "GET"), //
    BLOG_IS_COMMENTS_ENABLED(BLOG, "commentsEnabled", "GET"), //
    BLOG_IS_PINGS_ENABLED(BLOG, "pingsEnabled", "GET"), //
    BLOG_IS_PINGS_OVERRIDE_ENABLED(BLOG, "pingsOverrideEnabled", "GET"), //
    BLOG_IS_TRACKBACKS_ENABLED(BLOG, "trackbacksEnabled", "GET"), //
    BLOG_PUBLISH_BLOG_POST(BLOG, "publishBlogPost", "POST", "publishBlogPost"), //
    BLOG_REMOVE_ATTACHMENT(BLOG, "attachments/{attachmentID}", "DELETE"), //
    BLOG_SET_BLOGS_ENABLED(BLOG, "blogsEnabled", "POST", "setBlogsEnabled"), //
    BLOG_SET_COMMENTS_ENABLED(BLOG, "commentsEnabled", "POST", "setCommentsEnabled"), //
    BLOG_SET_PING_SERVICES(BLOG, "pingServices", "POST", "setPingServices"), //
    BLOG_SET_PINGS_ENABLED(BLOG, "pingsEnabled", "POST", "setPingsEnabled"), //
    BLOG_SET_PINGS_OVERRIDE_ENABLED(BLOG, "pingsOverrideEnabled", "POST", "setPingsOverrideEnabled"), //
    BLOG_SET_TRACKBACKS_ENABLED(BLOG, "trackbacksEnabled", "POST", "setTrackbacksEnabled"), //
    BLOG_UPDATE_BLOG_POST(BLOG, "blogPosts", "PUT", "updateBlogPost"), //
    BLOG_UPLOAD_ATTACHMENT_TO_BLOG_POST(BLOG, "attachmentUpload", "POST", "uploadAttachmentToBlogPost"), //
    BLOG_USER_HAS_BLOGS(BLOG, "userHasBlogs", "GET"), //
    COMMUNITY_CREATE(COMMUNITY, "communities", "POST", "createCommunity"), //
    COMMUNITY_DELETE(COMMUNITY, "communities/{communityID}", "DELETE"), //
    COMMUNITY_DELETE_PROPERTY(COMMUNITY, "properties/{communityID}/{name}", "DELETE"), //
    COMMUNITY_GET(COMMUNITY, "communities/{communityID}", "GET"), //
    COMMUNITY_GET_DOCUMENT_IDS(COMMUNITY, "documentIDs/{communityID}", "GET"), //
    COMMUNITY_GET_PROPERTIES(COMMUNITY, "properties/{communityID}", "GET"), //
    COMMUNITY_GET_PROPERTY(COMMUNITY, "properties/{communityID}/{name}", "GET"), //
    COMMUNITY_GET_RECURSIVE_COMMUNITIES(COMMUNITY, "communities", "GET"), //
    COMMUNITY_GET_RECURSIVE_COMMUNITIES_BY_COMMUNITY(COMMUNITY, "recursiveCommunities/{communityID}", "GET"), //
    COMMUNITY_GET_RECURSIVE_COMMUNITY_COUNT(COMMUNITY, "recursiveCount/{communityID}", "GET"), //
    COMMUNITY_GET_SUB_COMMUNITIES(COMMUNITY, "subCommunities/{communityID}", "GET"), //
    COMMUNITY_SET_PROPERTY(COMMUNITY, "properties", "POST", "setProperty"), //
    COMMUNITY_UPDATE(COMMUNITY, "communities", "PUT", "updateCommunity"), //
    DOCUMENT_ADD_ATTACHMENT_TO_DOCUMENT_BY_DOCUMENT_ID(DOCUMENT, "attachments", "POST",
                    "addAttachmentToDocumentByDocumentID"), //
    DOCUMENT_ADD_ATTACHMENT_TO_DOCUMENT_BY_INTERNAL_DOC_ID(DOCUMENT, "attachmentsByInternalDocID", "POST",
                    "addAttachmentToDocumentByInternalDocID"), //
    DOCUMENT_ADD_AUTHOR(DOCUMENT, "authors", "POST", "addAuthor"), //
    DOCUMENT_ADD_DOCUMENT_APPROVER_ON_COMMUNITY(DOCUMENT, "approval/communityUsers", "POST",
                    "addDocumentApproverOnCommunity"), //
    DOCUMENT_ADD_DOCUMENT_APPROVER_ON_DOCUMENT(DOCUMENT, "approval/users", "POST",
                    "addDocumentApproverOnDocument"), //
    DOCUMENT_ADD_IMAGE_TO_DOCUMENT_BY_DOCUMENT_ID(DOCUMENT, "images", "POST",
                    "addImageToDocumentByDocumentID"), //
    DOCUMENT_ADD_IMAGE_TO_DOCUMENT_BY_INTERNAL_DOC_ID(DOCUMENT, "imagesByInternalDocID", "POST",
                    "addImageToDocumentByInternalDocID"), //
    DOCUMENT_CREATE_BINARY_DOCUMENT(DOCUMENT, "binaryDocument", "POST", "createBinaryDocument"), //
    DOCUMENT_CREATE_BINARY_DOCUMENT_IN_CONTAINER(DOCUMENT, "createBinaryDocumentInContainer", "POST",
                    "createBinaryDocumentInContainer"), //
    DOCUMENT_CREATE(DOCUMENT, "documents", "POST", "createDocument"), //
    DOCUMENT_CREATE_DOCUMENT_IN_CONTAINER(DOCUMENT, "createDocumentInContainer", "POST",
                    "createDocumentInContainer"), //
    DOCUMENT_DELETE(DOCUMENT, "documents/{documentID}", "DELETE"), //
    DOCUMENT_DELETE_DOCUMENT_PROPERTY(DOCUMENT, "properties/{documentID}/{name}", "DELETE"), //
    DOCUMENT_GET_APPROVAL_STATUS_FOR_DOCUMENT(DOCUMENT, "approval/status/{documentID}", "GET"), //
    DOCUMENT_GET_ATTACHMENT_COUNT_BY_DOCUMENT_ID(DOCUMENT, "attachmentCount/{documentID}", "GET"), //
    DOCUMENT_GET_ATTACHMENT_COUNT_BY_INTERNAL_DOC_ID(DOCUMENT,
                    "attachmentCountByInternalDocID/{internalDocID}", "GET"), //
    DOCUMENT_GET_ATTACHMENTS_BY_DOCUMENT_ID(DOCUMENT, "attachments/{documentID}", "GET"), //
    DOCUMENT_GET_ATTACHMENTS_BY_INTERNAL_DOC_ID(DOCUMENT, "attachementsByInternalDocID/{internalDocID}",
                    "GET"), //
    DOCUMENT_GET_AUTHORS(DOCUMENT, "authors/{documentID}", "GET"), //
    DOCUMENT_GET_BINARY_DOCUMENT_CONTENT(DOCUMENT, "binaryDocument/{documentID}", "GET"), //
    DOCUMENT_GET_DOCUMENT_APPROVERS_ON_COMMUNITY(DOCUMENT, "approval/communityUsers/{communityID}", "GET"), //
    DOCUMENT_GET_DOCUMENT_APPROVERS_ON_DOCUMENT(DOCUMENT, "approval/users/{documentID}", "GET"), //
    DOCUMENT_GET_DOCUMENT_BY_DOCUMENT_ID(DOCUMENT, "documents/{documentID}", "GET"), //
    DOCUMENT_GET_DOCUMENT_BY_DOCUMENT_ID_AND_VERSION(DOCUMENT, "documents/{documentID}/{version}", "GET"), //
    DOCUMENT_GET_DOCUMENT_BY_INTERNAL_DOC_ID(DOCUMENT, "documentsByInternalDocID/{internalDocID}", "GET"), //
    DOCUMENT_GET_DOCUMENT_BY_INTERNAL_DOC_ID_AND_VERSION(DOCUMENT,
                    "documentsByInternalDocID/{internalDocID}/{version}", "GET"), //
    DOCUMENT_GET_DOCUMENT_PROPERTIES(DOCUMENT, "properties/{documentID}", "GET"), //
    DOCUMENT_GET_DOCUMENT_PROPERTY(DOCUMENT, "properties/{documentID}/{name}", "GET"), //
    DOCUMENT_GET_DOCUMENTS_BY_COMMUNITY(DOCUMENT, "documentsByCommunity/{communityID}", "GET"), //
    DOCUMENT_GET_DOCUMENTS_BY_COMMUNITY_AND_FILTER(DOCUMENT, "documentsByCommunityAndFilter", "POST",
                    "getDocumentsByCommunityAndFilter"), //
    DOCUMENT_GET_IMAGE_COUNT_BY_DOCUMENT_ID(DOCUMENT, "imageCount/{documentID}", "GET"), //
    DOCUMENT_GET_IMAGE_COUNT_BY_INTERNAL_DOC_ID(DOCUMENT, "imageCountByInternalDocID/{internalDocID}", "GET"), //
    DOCUMENT_GET_IMAGES_BY_DOCUMENT_ID(DOCUMENT, "images/{documentID}", "GET"), //
    DOCUMENT_GET_IMAGES_BY_INTERNAL_DOC_ID(DOCUMENT, "imagesByInternalDocID/{internalDocID}", "GET"), //
    DOCUMENT_GET_POPULAR_DOCUMENTS(DOCUMENT, "popularDocuments", "GET"), //
    DOCUMENT_GET_POPULAR_DOCUMENTS_BY_COMMUNITY(DOCUMENT, "popularDocumentsByCommunity/{communityID}", "GET"), //
    DOCUMENT_GET_POPULAR_DOCUMENTS_BY_LANGUAGE(DOCUMENT, "documentsByLanguage/{languages}", "GET"), //
    DOCUMENT_GET_USER(DOCUMENT, "user/{documentID}", "GET"), //
    DOCUMENT_GET_USER_APPROVAL_DOCUMENTS(DOCUMENT, "approvers/{userID}", "GET"), //
    DOCUMENT_IS_COMMENTS_ENABLED(DOCUMENT, "commentsEnabled", "GET"), //
    DOCUMENT_IS_TRACKBACKS_ENABLED(DOCUMENT, "trackbacksEnabled", "GET"), //
    DOCUMENT_MOVE(DOCUMENT, "moveDocument", "POST", "moveDocument"), //
    DOCUMENT_MOVE_DOCUMENT_TO_CONTAINER(DOCUMENT, "moveDocumentToContainer", "POST",
                    "moveDocumentToContainer"), //
    DOCUMENT_PUBLISH_BINARY_DOCUMENT(DOCUMENT, "publishBinaryDocument", "POST", "publishBinaryDocument"), //
    DOCUMENT_PUBLISH_BINARY_DOCUMENT_IN_CONTAINER(DOCUMENT, "publishBinaryDocumentInContainer", "POST",
                    "publishBinaryDocumentInContainer"), //
    DOCUMENT_PUBLISH_DOCUMENT(DOCUMENT, "publish", "PUT", "publishDocument"), //
    DOCUMENT_PUBLISH_DOCUMENT_IN_CONTAINER(DOCUMENT, "publishDocumentInContainer", "PUT",
                    "publishDocumentInContainer"), //
    DOCUMENT_REMOVE_ATTACHMENT(DOCUMENT, "attachments/{attachmentID}", "DELETE"), //
    DOCUMENT_REMOVE_AUTHOR(DOCUMENT, "authors/{documentID}/{userID}", "DELETE"), //
    DOCUMENT_SET_COMMENTS_ENABLED(DOCUMENT, "commentsEnabled", "POST", "setCommentsEnabled"), //
    DOCUMENT_SET_DOCUMENT_PROPERTY(DOCUMENT, "properties", "POST", "setDocumentProperty"), //
    DOCUMENT_SET_TRACKBACKS_ENABLED(DOCUMENT, "trackbacksEnabled", "POST", "setTrackbacksEnabled"), //
    DOCUMENT_UPDATE(DOCUMENT, "documents", "PUT", "updateDocument"), //
    DOCUMENT_UPLOAD_ATTACHMENT_TO_DOCUMENT_BY_DOCUMENT_ID(DOCUMENT, "attachmentUpload", "POST",
                    "uploadAttachmentToDocumentByDocumentID"), //
    DOCUMENT_UPLOAD_ATTACHMENT_TO_DOCUMENT_BY_INTERNAL_DOC_ID(DOCUMENT, "attachmentUploadByInternalDocID",
                    "POST", "uploadAttachmentToDocumentByInternalDocID"), //
    ENTITLEMENT_ADD_GROUP_ENTITLEMENT(ENTITLEMENT, "entitlements", "POST", "addGroupEntitlement"), //
    ENTITLEMENT_ADD_USER_ENTITLEMENT(ENTITLEMENT, "entitlements", "POST", "addUserEntitlement"), //
    ENTITLEMENT_GET_ENTITLEMENT_MASKS(ENTITLEMENT, "entitlements", "GET"), //
    ENTITLEMENT_IS_USER_ENTITLED(ENTITLEMENT, "entitlements", "GET"), //
    ENTITLEMENT_REMOVE_GROUP_ENTITLEMENT(ENTITLEMENT, "entitlements", "POST", "removeGroupEntitlement"), //
    ENTITLEMENT_REMOVE_USER_ENTITLEMENT(ENTITLEMENT, "entitlements", "POST", "removeUserEntitlement"), //
    FORUM_ADD_ATTACHMENT_TO_MESSAGE(FORUM, "attachments", "POST", "addAttachmentToMessage"), //
    FORUM_ADD_IMAGE_TO_MESSAGE(FORUM, "images", "POST", "addImageToMessage"), //
    FORUM_CREATE_MESSAGE(FORUM, "messages", "POST", "createMessage"), //
    FORUM_CREATE_REPLY_MESSAGE(FORUM, "replyMessage", "POST", "createReplyMessage"), //
    FORUM_CREATE_THREAD(FORUM, "threads", "POST", "createThread"), //
    FORUM_DELETE_MESSAGE(FORUM, "messages/{messageID}", "DELETE"), //
    FORUM_DELETE_MESSAGE_AND_CHILDREN(FORUM, "messages/{messageID}/{deleteChildren}", "DELETE"), //
    FORUM_DELETE_MESSAGE_PROPERTY(FORUM, "properties", "DELETE"), //
    FORUM_DELETE_THREAD(FORUM, "threads/{threadID}", "DELETE"), //
    FORUM_DELETE_THREAD_PROPERTY(FORUM, "threadProperties/{threadID}/{name}", "DELETE"), //
    FORUM_GET_ATTACHMENTS_BY_MESSAGE_ID(FORUM, "attachments/{messageID}", "GET"), //
    FORUM_GET_CHILD(FORUM, "children/{messageID}/{index}", "GET"), //
    FORUM_GET_CHILD_COUNT(FORUM, "childCount/{messageID}", "GET"), //
    FORUM_GET_CHILDREN(FORUM, "children/{mesageID}", "GET"), //
    FORUM_GET_FORUM_MESSAGE(FORUM, "messages/{messageID}", "GET"), //
    FORUM_GET_FORUM_THREAD(FORUM, "threads/{threadID}", "GET"), //
    FORUM_GET_IMAGES_BY_MESSAGE_ID(FORUM, "images/{messageID}", "GET"), //
    FORUM_GET_INDEX_OF_CHILD(FORUM, "indexOfChild/{parentID}/{messageID}", "GET"), //
    FORUM_GET_MESSAGE_COUNT_BY_COMMUNITY_ID(FORUM, "messageCountByCommunityID/{communityID}", "GET"), //
    FORUM_GET_MESSAGE_COUNT_BY_COMMUNITY_ID_AND_FILTER(FORUM, "messageCountByCommunityID", "POST",
                    "getMessageCountByCommunityIDAndFilter"), //
    FORUM_GET_MESSAGE_COUNT_BY_THREAD_ID(FORUM, "messageCountByThreadID/{threadID}", "GET"), //
    FORUM_GET_MESSAGE_COUNT_BY_THREAD_ID_AND_FILTER(FORUM, "messageCountByThreadID", "POST",
                    "getMessageCountByThreadIDAndFilter"), //
    FORUM_GET_MESSAGE_COUNTS_BY_COMMUNITY_ID_AND_FILTER(FORUM, "messageCountsByCommunityID", "POST",
                    "getMessageCountsByCommunityIDAndFilter"), //
    FORUM_GET_MESSAGE_DEPTH(FORUM, "messageDepth/{messageID}", "GET"), //
    FORUM_GET_MESSAGE_IDS_BY_COMMUNITY_ID(FORUM, "messageIDsByCommunityID/{communityID}", "GET"), //
    FORUM_GET_MESSAGE_IDS_BY_COMMUNITY_ID_AND_FILTER(FORUM, "messageIdsByCommunityID/{communityID}", "POST",
                    "getMessageIDsByCommunityIDAndFilter"), //
    FORUM_GET_MESSAGE_IDS_BY_THREAD_ID(FORUM, "messageIDsByThreadID/{threadID}", "GET"), //
    FORUM_GET_MESSAGE_IDS_BY_THREAD_ID_AND_FILTER(FORUM, "messageIDsByThreadID", "POST",
                    "getMessageIDsByThreadIDAndFilter"), //
    FORUM_GET_MESSAGE_PROPERTIES(FORUM, "properties/{messageID}", "GET"), //
    FORUM_GET_MESSAGE_PROPERTY(FORUM, "properties/{messageID}/{name}", "GET"), //
    FORUM_GET_MESSAGES_BY_COMMUNITY_ID(FORUM, "messagesByCommunityID/{communityID}", "GET"), //
    FORUM_GET_MESSAGES_BY_COMMUNITY_ID_AND_FILTER(FORUM, "messagesByCommunityID", "POST",
                    "getMessagesByCommunityIDAndFilter"), //
    FORUM_GET_MESSAGES_BY_THREAD_ID(FORUM, "messagesByThreadID/{threadID}", "GET"), //
    FORUM_GET_MESSAGES_BY_THREAD_ID_AND_FILTER(FORUM, "messagesByThreadID", "POST",
                    "getMessagesByThreadIDAndFilter"), //
    FORUM_GET_PARENT(FORUM, "parentMessage/{messageID}", "GET"), //
    FORUM_GET_POPULAR_THREADS(FORUM, "popularThreads", "GET"), //
    FORUM_GET_POPULAR_THREADS_BY_COMMUNITY_ID(FORUM, "popularThreadsByCommunityID/{communityID}", "GET"), //
    FORUM_GET_RECURSIVE_CHILD_COUNT(FORUM, "recursiveChildCount/{messageID}", "GET"), //
    FORUM_GET_RECURSIVE_CHILDREN(FORUM, "recursiveChildren/{messageID}", "GET"), //
    FORUM_GET_RECUSIVE_MESSAGES(FORUM, "recusiveMessages/{threadID}", "GET"), //
    FORUM_GET_ROOT_MESSAGE(FORUM, "rootMessage/{threadID}", "GET"), //
    FORUM_GET_THREAD_COUNT_BY_COMMUNITY_ID(FORUM, "threadCountByCommunityID/{communityID}", "GET"), //
    FORUM_GET_THREAD_COUNT_BY_COMMUNITY_ID_AND_FILTER(FORUM, "threadCountByCommunityID", "POST",
                    "getThreadCountByCommunityIDAndFilter"), //
    FORUM_GET_THREAD_PROPERTIES(FORUM, "threadProperties/{threadID}", "GET"), //
    FORUM_GET_THREAD_PROPERTY(FORUM, "threadProperties/{threadID}/{name}", "GET"), //
    FORUM_GET_THREADS_BY_COMMUNITY_ID(FORUM, "threadsByCommunityID/{communityID}", "GET"), //
    FORUM_GET_THREADS_BY_COMMUNITY_ID_AND_FILTER(FORUM, "threadsByCommunityID", "POST",
                    "getThreadsByCommunityIDAndFilter"), //
    FORUM_GET_UNFILTERED_MESSAGE_PROPERTIES(FORUM, "unfilteredProperties/{messageID}", "GET"), //
    FORUM_HAS_PARENT(FORUM, "hasParent/{messageID}", "GET"), //
    FORUM_IS_LEAF(FORUM, "isLeaf/{messageID}", "GET"), //
    FORUM_MOVE_THREAD(FORUM, "moveThread", "PUT", "moveThread"), //
    FORUM_MOVE_THREAD_TO_CONTAINER(FORUM, "moveThreadToContainer", "PUT", "moveThreadToContainer"), //
    FORUM_REMOVE_ATTACHMENT(FORUM, "attachments/{attachmentID}", "DELETE"), //
    FORUM_SET_MESSAGE_PROPERTY(FORUM, "properties", "POST", "setMessageProperty"), //
    FORUM_SET_THREAD_PROPERTY(FORUM, "threadProperties", "POST", "setThreadProperty"), //
    FORUM_UPDATE_FORUM_MESSAGE(FORUM, "messages", "PUT", "updateForumMessage"), //
    FORUM_UPLOAD_ATTACHMENT_TO_MESSAGE(FORUM, "attachmentUpload", "POST", "uploadAttachmentToMessage"), //
    GROUP_ADD_ADMINISTRATOR_TO_GROUP(GROUP, "groupAdmins", "POST", "addAdministratorToGroup"), //
    GROUP_ADD_MEMBER_TO_GROUP(GROUP, "groupMembers", "POST", "addMemberToGroup"), //
    GROUP_CREATE_GROUP(GROUP, "groups", "POST", "createGroup"), //
    GROUP_DELETE_GROUP(GROUP, "groups/{groupID}", "DELETE"), //
    GROUP_DELETE_PROPERTY(GROUP, "properties/{groupID}/{name}", "DELETE"), //
    GROUP_GET_ADMINISTRATOR_COUNT(GROUP, "administratorCount/{groupID}", "GET"), //
    GROUP_GET_GROUP(GROUP, "groupsByID/{groupID}", "GET"), //
    GROUP_GET_GROUP_ADMINS(GROUP, "groupAdmins/{groupID}", "GET"), //
    GROUP_GET_GROUP_BYNAME(GROUP, "groups/{name}", "GET"), //
    GROUP_GET_GROUP_COUNT(GROUP, "groupCount", "GET"), //
    GROUP_GET_GROUP_MEMBERS(GROUP, "groupMembers/{groupID}", "GET"), //
    GROUP_GET_GROUP_NAMES(GROUP, "groupNames", "GET"), //
    GROUP_GET_GROUP_NAMES_BOUNDED(GROUP, "groupNamesBounded/{startIndex}/{numResults}", "GET"), //
    GROUP_GET_GROUPS(GROUP, "groups", "GET"), //
    GROUP_GET_PROPERTIES(GROUP, "properties/{groupID}", "GET"), //
    GROUP_GET_USER_GROUP_NAMES(GROUP, "userGroupNames/{userID}", "GET"), //
    GROUP_GET_USER_GROUPS(GROUP, "userGroups/{userID}", "GET"), //
    GROUP_IS_READ_ONLY(GROUP, "isReadOnly", "GET"), //
    GROUP_REMOVE_ADMINISTRATOR_FROM_GROUP(GROUP, "groupAdmins/{groupID}/{userID}", "DELETE"), //
    GROUP_REMOVE_MEMBER_FROM_GROUP(GROUP, "groupMembers/{groupID}/{userID}", "DELETE"), //
    GROUP_SET_PROPERTY(GROUP, "properties", "POST", "setProperty"), //
    GROUP_UPDATE_GROUP(GROUP, "groups", "PUT", "configureComponent"), //
    IMSERVICE_CONFIGURE_COMPONENT(IMSERVICE, "configureComponent", "POST", "configureComponent"), //
    IMSERVICE_GENERATE_NONCE(IMSERVICE, "generateNonce", "GET"), //
    IMSERVICE_TEST_CREDENTIALS(IMSERVICE, "testCredentials", "GET"), //
    PLUGIN_GET_PLUGIN_INFO(PLUGIN, "plugins", "GET"), //
    PLUGIN_INSTALL_PLUGIN(PLUGIN, "plugins", "POST", "installPlugin"), //
    PLUGIN_UNINSTALL_PLUGIN(PLUGIN, "plugins/{pluginName}", "DELETE"), //
    POLL_ADD_ANONYMOUS_VOTE(POLL, "votes/anonymous", "POST", "addAnonymousVote"), //
    POLL_ADD_OPTION(POLL, "options", "POST", "addOption"), //
    POLL_ADD_USER_VOTE(POLL, "votes/user", "POST", "addUserVote"), //
    POLL_CHANGE_ANONYMOUS_VOTE(POLL, "votes/anonymous", "PUT", "changeAnonymousVote"), //
    POLL_CHANGE_USER_VOTE(POLL, "votes/user", "PUT", "changeUserVote"), //
    POLL_CREATE_POLL(POLL, "polls", "POST", "createPoll"), //
    POLL_DELETE_OPTION(POLL, "options/{pollID}/{index}", "DELETE"), //
    POLL_DELETE_POLL(POLL, "polls/{pollID}", "DELETE"), //
    POLL_GET_ACTIVE_POLL_COUNT(POLL, "activePollCount", "GET"), //
    POLL_GET_ACTIVE_POLL_COUNT_BY_OBJECT_TYPE_AND_OBJECT_ID(POLL, "activePollCount/{objectType}/{objectID}",
                    "GET"), //
    POLL_GET_ACTIVE_POLLS(POLL, "activePolls", "GET"), //
    POLL_GET_ACTIVE_POLLS_BY_OBJECT_TYPE_AND_OBJECT_ID(POLL, "activePolls/{objectType}/{objectID}", "GET"), //
    POLL_GET_ANONYMOUS_VOTE_COUNT(POLL, "votes/anonymousCount/{pollID}", "GET"), //
    POLL_GET_ANONYMOUS_VOTE_COUNT_BY_INDEX(POLL, "votes/anonymousCount/{pollID}/{index}", "GET"), //
    POLL_GET_ANONYMOUS_VOTE_INDICES(POLL, "votes/anonymousIndices/{pollID}/{uniqueID}", "GET"), //
    POLL_GET_ANONYMOUS_VOTES(POLL, "votes/anonymous/{pollID}", "GET"), //
    POLL_GET_ANONYMOUS_VOTES_BY_INDEX(POLL, "votes/anonymous/{pollID}/{index}", "GET"), //
    POLL_GET_LIVE_POLL_COUNT(POLL, "livePollCount", "GET"), //
    POLL_GET_LIVE_POLL_COUNT_BY_OBJECT_TYPE_AND_OBJECT_ID(POLL, "livePollCount/{objectType}/{objectID}",
                    "GET"), //
    POLL_GET_LIVE_POLLS(POLL, "livePolls", "GET"), //
    POLL_GET_LIVE_POLLS_BY_OBJECT_TYPE_AND_OBJECT_ID(POLL, "livePolls/{objectType}/{objectID}", "GET"), //
    POLL_GET_POLL(POLL, "polls/{pollID}", "GET"), //
    POLL_GET_POLL_COUNT(POLL, "pollCount", "GET"), //
    POLL_GET_POLL_COUNT_BY_OBJECT_TYPE_AND_OBJECT_ID(POLL, "pollCount/{objectType}/{objectID}", "GET"), //
    POLL_GET_POLLS(POLL, "polls", "GET"), //
    POLL_GET_POLLS_BY_OBJECT_TYPE_AND_OBJECT_ID(POLL, "polls/{objectType}/{objectID}", "GET"), //
    POLL_GET_USER_VOTE_COUNT(POLL, "votes/userCount/{pollID}", "GET"), //
    POLL_GET_USER_VOTE_COUNT_BY_INDEX(POLL, "votes/userCount/{pollID}/{index}", "GET"), //
    POLL_GET_USER_VOTE_INDICES(POLL, "votes/userIndices/{pollID}/{userID}", "GET"), //
    POLL_GET_USER_VOTES(POLL, "votes/{pollID}", "GET"), //
    POLL_GET_USER_VOTES_BY_INDEX(POLL, "votes/{pollID}/{index}", "GET"), //
    POLL_GET_VOTE_COUNT(POLL, "votes/count/{pollID}", "GET"), //
    POLL_GET_VOTE_COUNT_BY_INDEX(POLL, "votesByIndex/{pollID}/{index}", "GET"), //
    POLL_HAS_ANONYMOUS_VOTED(POLL, "votes/anonymousVoted/{pollID}/{uniqueID}", "GET"), //
    POLL_HAS_USER_VOTED(POLL, "votes/userVoted/{pollID}/{userID}", "GET"), //
    POLL_IS_MODE_ENABLED(POLL, "modes/{pollID}/{mode}", "GET"), //
    POLL_REMOVE_ANONYMOUS_VOTE(POLL, "votes/anonymous/{pollID}/{prevOptionIndex}/{uniqueID}", "DELETE"), //
    POLL_REMOVE_USER_VOTE(POLL, "votes/user/{pollID}/{prevOptionIndex}/{userID}", "DELETE"), //
    POLL_SET_MODE(POLL, "modes", "POST", "setMode"), //
    POLL_SET_OPTION(POLL, "options", "PUT", "setOption"), //
    POLL_SET_OPTION_INDEX(POLL, "options/index", "PUT", "setOptionIndex"), //
    POLL_UPDATE(POLL, "polls", "PUT", "createFolder"), //
    PRIVATE_MESSAGE_CREATE_FOLDER(PRIVATE_MESSAGE, "/rpc/rest/privateMessageService/folders", "POST",
                    "createFolder"), //
    PRIVATE_MESSAGE_CREATE_MESSAGE(PRIVATE_MESSAGE, "/rpc/rest/privateMessageService/messages", "POST",
                    "createMessage"), //
    PRIVATE_MESSAGE_DELETE_FOLDER(PRIVATE_MESSAGE,
                    "/rpc/rest/privateMessageService/folders/{userID}/{folderID}", "DELETE"), //
    PRIVATE_MESSAGE_DELETE_MESSAGE(PRIVATE_MESSAGE,
                    "/rpc/rest/privateMessageService/userMessages/{userID}/{messageID}", "DELETE"), //
    PRIVATE_MESSAGE_GET_FOLDER(PRIVATE_MESSAGE,
                    "/rpc/rest/privateMessageService/folders/{userID}/{folderID}", "GET"), //
    PRIVATE_MESSAGE_GET_FOLDERS(PRIVATE_MESSAGE, "/rpc/rest/privateMessageService/folders/{userID}", "GET"), //
    PRIVATE_MESSAGE_GET_MESSAGE(PRIVATE_MESSAGE,
                    "/rpc/rest/privateMessageService/messages/{privateMessageID}", "GET"), //
    PRIVATE_MESSAGE_GET_MESSAGE_COUNT(PRIVATE_MESSAGE,
                    "/rpc/rest/privateMessageService/messageCount/{userID}", "GET"), //
    PRIVATE_MESSAGE_GET_MESSAGE_COUNT_FOR_FOLDER(PRIVATE_MESSAGE,
                    "/rpc/rest/privateMessageService/messsageCount/{userID}/{folderID}", "GET"), //
    PRIVATE_MESSAGE_GET_MESSAGES(PRIVATE_MESSAGE,
                    "/rpc/rest/privateMessageService/userMesages/{userID}/{folderID}", "GET"), //
    PRIVATE_MESSAGE_GET_UNREAD_MESSAGE_COUNT(PRIVATE_MESSAGE,
                    "/rpc/rest/privateMessageService/unreadMessageCount/{userID}", "GET"), //
    PRIVATE_MESSAGE_GET_UNREAD_MESSAGE_COUNT_FOR_FOLDER(PRIVATE_MESSAGE,
                    "/rpc/rest/privateMessageService/unreadMessageCount/{userID}/{folderID}", "GET"), //
    PRIVATE_MESSAGE_IS_PRIVATE_MESSAGE_ENABLED(PRIVATE_MESSAGE,
                    "/rpc/rest/privateMessageService/privateMessagesEnabled", "GET"), //
    PRIVATE_MESSAGE_MOVE_MESSAGE(PRIVATE_MESSAGE, "/rpc/rest/privateMessageService/moveMessage", "POST",
                    "moveMessage"), //
    PRIVATE_MESSAGE_SAVE_MESSAGE_AS_DRAFT(PRIVATE_MESSAGE, "/rpc/rest/privateMessageService/saveDraft",
                    "POST", "saveMessageAsDraft"), //
    PRIVATE_MESSAGE_SEND_MESSAGE(PRIVATE_MESSAGE, "/rpc/rest/privateMessageService/sendMessage", "POST",
                    "sendMessage"), //
    PROFILE_CREATE_PROFILE_FIELD(PROFILE_FIELD, "/rpc/rest/profileFieldService/fields", "POST",
                    "createProfileField"), //
    PROFILE_DELETE_PROFILE_FIELD(PROFILE_FIELD, "/rpc/rest/profileFieldService/fields/{fieldID}", "DELETE"), //
    PROFILE_EDIT_PROFILE_FIELD(PROFILE_FIELD, "/rpc/rest/profileFieldService/fields", "PUT",
                    "editProfileField"), //
    PROFILE_EDIT_PROFILE_FIELD_OPTIONS(PROFILE_FIELD, "/rpc/rest/profileFieldService/options", "PUT",
                    "editProfileFieldOptions"), //
    PROFILE_GET_DEFAULT_FIELDS(PROFILE_FIELD, "/rpc/rest/profileFieldService/defaultFields", "GET"), //
    PROFILE_GET_PROFILE_FIELD(PROFILE_FIELD, "/rpc/rest/profileFieldService/fields/{fieldID}", "GET"), //
    PROFILE_GET_PROFILE_FIELDS(PROFILE_FIELD, "/rpc/rest/profileFieldService/fields", "GET"), //
    PROFILE_SET_INDEX(PROFILE_FIELD, "/rpc/rest/profileFieldService/index", "POST", "setIndex"), //
    PROFILE_GET_SIMILAR_USER_RESULTS(EntityTypeName.PROFILE_SEARCH,
                    "/rpc/rest/profileSearchService/similarUsers/{targetUserID}", "GET"), //
    PROFILE_IS_SEARCH_ENABLED(EntityTypeName.PROFILE_SEARCH,
                    "/rpc/rest/profileSearchService/isSearchEnabled", "GET"), //
    PROFILE_SEARCH(EntityTypeName.PROFILE_SEARCH, "/rpc/rest/profileSearchService/searchProfile", "POST",
                    "search"), //
    PROFILE_SEARCH_BOUNDED(EntityTypeName.PROFILE_SEARCH,
                    "/rpc/rest/profileSearchService/searchProfileBounded", "POST", "searchBounded"), //
    PROFILE_ADD_PROFILE(PROFILE, "profiles", "POST", "addProfile"), //
    PROFILE_DELETE_PROFILE_BY_ID(PROFILE, "fields/{fieldID}", "DELETE"), //
    PROFILE_DELETE_PROFILE_BY_USER_ID(PROFILE, "profiles/{userID}", "DELETE"), //
    PROFILE_DELETE_USER_STATUS(PROFILE, "status/{userID}", "DELETE"), //
    PROFILE_GET_CURRENT_STATUS(PROFILE, "currentStatus/{userID}", "GET"), //
    PROFILE_PROFILE_FIELD(PROFILE, "profiles/{userID}", "GET"), //
    PROFILE_GET_PROFILE_IMAGE(PROFILE, "images/{userID}", "GET"), //
    PROFILE_GET_RECENT_STATUS_UPDATES(PROFILE, "status", "GET"), //
    PROFILE_GET_RECENT_STATUS_UPDATES_FOR_USER(PROFILE, "status/{userID}", "GET"), //
    PROFILE_GET_STATUS_MESSAGE_MAX_LENGTH(PROFILE, "statusMessagesMaxLength", "GET"), //
    PROFILE_GET_TODAYS_STATUS_UPDATES(PROFILE, "todaysStatus/{userID}", "GET"), //
    PROFILE_GET_USER_STATUS(PROFILE, "userStatus/{statusID}", "GET"), //
    PROFILE_GET_YESTERDAYS_STATUS_UPDATES(PROFILE, "yesterdaysStatus/{userID}", "GET"), //
    PROFILE_IS_STATUS_UPDATES_ENABLED(PROFILE, "statusUpdatesEnabled", "GET"), //
    PROFILE_SET_CURRENT_STATUS(PROFILE, "status", "POST", "setCurrentStatus"), //
    PROFILE_SET_PROFILE(PROFILE, "profiles", "PUT", "setProfile"), //
    PROFILE_SET_PROFILE_IMAGE(PROFILE, "images", "POST", "setProfileImage"), //
    PROJECT_CREATE(PROJECT, "projects", "POST", "create"), //
    PROJECT_DELETE(PROJECT, "projects/{projectID}", "DELETE"), //
    PROJECT_GET_CHECK_POINTS(PROJECT, "checkPointsByProject/{projectID}", "GET"), //
    PROJECT_GET_PROJECT_BYID(PROJECT, "projects/{projectID}", "GET"), //
    PROJECT_GET_PROJECT_COUNT(PROJECT, "projectCount", "GET"), //
    PROJECT_GET_PROJECTS(PROJECT, "projects", "GET"), //
    PROJECT_GET_USER_COUNT(PROJECT, "userCount/{projectID}", "GET"), //
    PROJECT_SET_CHECK_POINTS(PROJECT, "checkPoints", "PUT", "setCheckPoints"), //
    PROJECT_UPDATE(PROJECT, "projects", "PUT", "update"), //
    RATINGS_ADD_RATING(RATINGS, "objectRatings/user", "PUT", "addRating"), //
    RATINGS_CREATE_RATING(RATINGS, "ratings", "POST", "createRating"), //
    RATINGS_GET_AVAILABLE_RATINGCOUNT(RATINGS, "ratings/count", "GET"), //
    RATINGS_GET_AVAILABLE_RATINGS(RATINGS, "ratings", "GET"), //
    RATINGS_GET_MEAN_RATING(RATINGS, "objectRatings/mean/{objectType}/{objectID}", "GET"), //
    RATINGS_GET_RATING(RATINGS, "objectRatings/user/{objectType}/{objectID}", "GET"), //
    RATINGS_GET_RATING_COUNT(RATINGS, "objectRatings/count/{objectType}/{objectID}", "GET"), //
    RATINGS_GET_RATING_FROMSCORE(RATINGS, "ratingFromScore/{score}", "POST", "getRatingFromScore"), //
    RATINGS_GET_RATINGS(RATINGS, "objectRatings/{objectType}/{objectID}", "GET"), //
    RATINGS_HAS_RATED(RATINGS, "objectRatings/userHasRated/{objectType}/{objectID}", "GET"), //
    RATINGS_IS_RATINGS_ENABLED(RATINGS, "ratingsEnabled", "GET"), //
    RATINGS_REMOVE_RATING(RATINGS, "ratings/{score}", "DELETE"), //
    RATINGS_SET_RATINGS_ENABLED(RATINGS, "ratingsEnabled", "POST", "addReference"), //
    REFERENCE_ADD_REFERENCE(REFERENCE, "references", "POST", "addReference"), //
    REFERENCE_DELETE_ALL_REFERENCES(REFERENCE, "references/{refererObjectType}/{refererObjectID}", "DELETE"), //
    REFERENCE_DELETE_ALL_REFERERS(REFERENCE, "referers/{referenceObjectType}/{referenceObjectID}", "DELETE"), //
    REFERENCE_DELETE_REFERENCE(
                    REFERENCE,
                    "references/{refererObjectType}/{refererObjectID}/{referenceObjectType}/{referenceObjectID}",
                    "DELETE"), //
    REFERENCE_GET_REFERENCES(REFERENCE, "references/{refererObjectType}/{refererObjectID}", "GET"), //
    REFERENCE_GET_REFERERS(REFERENCE, "referers/{referenceObjectType}/{referenceObjectID}", "GET"), //
    SEARCH_COUNT_QUICK_MESSAGESEARCHRESULTSBYCOMMUNITYID(SEARCH,
                    "communitySearchCount/{communityID}/{query}/{contentTypes}", "GET"), //
    SEARCH_COUNT_QUICK_SEARCHRESULTS(SEARCH, "quickSearchCount", "POST", "countQuickSearchResults"), //
    SEARCH_COUNT_SEARCH_RESULTS(SEARCH, "searchCount", "POST", "countSearchResults"), //
    SEARCH_COUNT_SEARCH_RESULTSBYCOMMUNITYID(SEARCH, "communitySearchCount", "POST",
                    "countSearchResultsByCommunityID"), //
    SEARCH_QUICK_MESSAGE_SEARCHBYCOMMUNITYID(SEARCH,
                    "communitySearch/{communityID}/{query}/{contentTypes}/{startIndex}/{numResults}", "GET"), //
    SEARCH_QUICK_SEARCH(SEARCH, "quickSearch", "POST", "quickSearch"), //
    SEARCH_SEARCH(SEARCH, "search", "POST", "search"), //
    SEARCH_SEARCH_BY_COMMUNITIES(SEARCH, "communitySearch", "POST", "searchByCommunities"), //
    SOCIAL_ADD_MEMBER(SOCIAL_GROUP, "/rpc/rest/socialGroupService/socialGroupMembers", "POST", "addMember"), //
    SOCIAL_CREATE_SOCIAL_GROUP(SOCIAL_GROUP, "/rpc/rest/socialGroupService/socialGroup", "POST",
                    "createSocialGroup"), //
    SOCIAL_DELETE_SOCIAL_GROUP(SOCIAL_GROUP, "/rpc/rest/socialGroupService/socialGroup/{socialGroupID}",
                    "DELETE"), //
    SOCIAL_GET_MEMBER_COUNT(SOCIAL_GROUP, "/rpc/rest/socialGroupService/membercount/{socialGroupID}", "GET"), //
    SOCIAL_GET_MEMBERS(SOCIAL_GROUP, "/rpc/rest/socialGroupService/members/{socialGroupID}", "GET"), //
    SOCIAL_GET_SOCIAL_GROUP(SOCIAL_GROUP, "/rpc/rest/socialGroupService/socialGroupsByID/{socialGroupID}",
                    "GET"), //
    SOCIAL_GET_SOCIAL_GROUPBYNAME(SOCIAL_GROUP,
                    "/rpc/rest/socialGroupService/socialGroupsByName/{displayName}", "GET"), //
    SOCIAL_GET_SOCIAL_GROUPCOUNT(SOCIAL_GROUP, "/rpc/rest/socialGroupService/socialGroupCount", "GET"), //
    SOCIAL_GET_SOCIAL_GROUPNAMES(SOCIAL_GROUP, "/rpc/rest/socialGroupService/socialGroupNames", "GET"), //
    SOCIAL_GET_SOCIAL_GROUPNAMESBOUNDED(SOCIAL_GROUP,
                    "/rpc/rest/socialGroupService/socialGroupNamesBounded/{startIndex}/{numResults}", "GET"), //
    SOCIAL_GET_SOCIAL_GROUPS(SOCIAL_GROUP, "/rpc/rest/socialGroupService/socialGroups", "GET"), //
    SOCIAL_GET_USER_SOCIALGROUPNAMES(SOCIAL_GROUP,
                    "/rpc/rest/socialGroupService/userSocialGroupNames/{userID}", "GET"), //
    SOCIAL_GET_USER_SOCIALGROUPS(SOCIAL_GROUP, "/rpc/rest/socialGroupService/userSocialGroups/{userID}",
                    "GET"), //
    SOCIAL_REMOVE_MEMBER(SOCIAL_GROUP,
                    "/rpc/rest/socialGroupService/socialGroupMembers/{socialGroupID}/{userID}", "DELETE"), //
    SOCIAL_SEARCH_SOCIAL_GROUPS(SOCIAL_GROUP, "/rpc/rest/socialGroupService/searchSocialGroups/", "POST",
                    "searchSocialGroups"), //
    SOCIAL_UPDATE_SOCIAL_GROUP(SOCIAL_GROUP, "/rpc/rest/socialGroupService/socialGroup", "PUT",
                    "updateSocialGroup"), //
    STATUS_ADD_POINTS(STATUS_LEVEL, "/rpc/rest/statusLevelService/addPoints", "POST", "addPoints"), //
    STATUS_ADD_POINTS_BY_CONTAINER(STATUS_LEVEL, "/rpc/rest/statusLevelService/addPointsByContainer", "POST",
                    "addPoints"), //
    STATUS_CREATE_STATUS_LEVEL_POINT_BASED(STATUS_LEVEL, "/rpc/rest/statusLevelService/pointStatusLevels",
                    "POST", "createStatusLevel"), //
    STATUS_CREATE_STATUS_LEVEL_GROUP_BASED(STATUS_LEVEL, "/rpc/rest/statusLevelService/groupStatusLevels",
                    "POST", "createStatusLevel"), //
    STATUS_DELETE_STATUS_LEVEL(STATUS_LEVEL, "/rpc/rest/statusLevelService/statusLevels/{statusLevelID}",
                    "DELETE"), //
    STATUS_GET_ALL_STATUS_LEVEL_SCENARIOS(STATUS_LEVEL, "/rpc/rest/statusLevelService/scenarios", "GET"), //
    STATUS_GET_GROUP_STATUS_LEVEL(STATUS_LEVEL, "/rpc/rest/statusLevelService/groupStatusLevels/{groupID}",
                    "GET"), //
    STATUS_GET_GROUP_STATUS_LEVELS(STATUS_LEVEL, "/rpc/rest/statusLevelService/groupStatusLevels", "GET"), //
    STATUS_GET_LEADERS(STATUS_LEVEL, "/rpc/rest/statusLevelService/leaders", "GET"), //
    STATUS_GET_LEADERS_BY_STARTINDEX_AND_NUMRESULTS(STATUS_LEVEL,
                    "/rpc/rest/statusLevelService/leaders/{startIndex}/{numResults}", "GET"), //
    STATUS_GET_LEADERS_BY_COMMUNITY(STATUS_LEVEL,
                    "/rpc/rest/statusLevelService/leadersByCommunity/{communityID}", "GET"), //
    STATUS_GET_LEADERS_BY_CONTAINER(
                    STATUS_LEVEL,
                    "/rpc/rest/statusLevelService/leadersByContainer/{containerObjectID}/{containerObjectType}",
                    "GET"), //
    STATUS_GET_LEADERS_BY_COMMUNITY_BY_STARTINDEX_AND_NUMRESULTS(
                    STATUS_LEVEL,
                    "/rpc/rest/statusLevelService/leadersByCommunity/{communityID}/{startIndex}/{numResults}",
                    "GET"), //
    STATUS_GET_LEADERS_BY_CONTAINER_ITERABLE(
                    STATUS_LEVEL,
                    "/rpc/rest/statusLevelService/leadersByContainer/{containerObjectID}/{containerObjectType}/{startIndex}/{numResults}",
                    "GET"), //
    STATUS_GET_POINT_LEVEL(STATUS_LEVEL, "/rpc/rest/statusLevelService/pointLevel/{userID}", "GET"), //
    STATUS_GET_POINT_LEVEL_BY_COMMUNITY(STATUS_LEVEL,
                    "/rpc/rest/statusLevelService/pointLevel/{userID}/{communityID}", "GET"), //
    STATUS_GET_POINT_LEVEL_BY_CONTAINER(
                    STATUS_LEVEL,
                    "/rpc/rest/statusLevelService/pointLevel/{userID}/{containerObjectID}/{containerObjectType}",
                    "GET"), //
    STATUS_GET_POINT_STATUS_LEVELS(STATUS_LEVEL, "/rpc/rest/statusLevelService/pointStatusLevels", "GET"), //
    STATUS_GET_STATUS_LEVEL(STATUS_LEVEL, "/rpc/rest/statusLevelService/statusLevels/{statusLevelID}", "GET"), //
    STATUS_GET_STATUS_LEVEL_BY_POINTS(STATUS_LEVEL,
                    "/rpc/rest/statusLevelService/statusLevelByPoints/{points}", "GET"), //
    STATUS_GET_STATUS_LEVEL_SCENARIO_BY_CODE(STATUS_LEVEL, "/rpc/rest/statusLevelService/scenarios/{code}",
                    "GET"), //
    STATUS_GET_STATUS_LEVEL_SCENARIO_BY_CODE_ENCODED(STATUS_LEVEL,
                    "/rpc/rest/statusLevelService/scenarios/{code}/{encoded}", "GET"), //
    STATUS_GET_USER_STATUS_LEVEL(STATUS_LEVEL, "/rpc/rest/statusLevelService/userStatusLevels/{userID}", "GET"), //
    STATUS_IS_STATUS_LEVELS_ENABLED(STATUS_LEVEL, "/rpc/rest/statusLevelService/statusLevelsEnabled", "GET"), //
    STATUS_SET_STATUS_LEVELS_ENABLED(STATUS_LEVEL, "/rpc/rest/statusLevelService/statusLevelsEnabled", "POST",
                    "setStatusLevelsEnabled"), //
    STATUS_UPDATE_STATUS_LEVEL_SCENARIO(STATUS_LEVEL, "/rpc/rest/statusLevelService/scenarios", "PUT",
                    "updateStatusLevelScenario"), //
    SYSTEM_DELETE_PROPERTY(SYSTEM_PROPERTIES, "/rpc/rest/systemPropertiesService/properties/{name}", "DELETE"), //
    SYSTEM_GET_PROPERTIES(SYSTEM_PROPERTIES, "/rpc/rest/systemPropertiesService/properties", "GET"), //
    SYSTEM_SAVE_PROPERTY(SYSTEM_PROPERTIES, "/rpc/rest/systemPropertiesService/properties", "POST",
                    "saveProperty"), //
    TAG_ADD_TAG(TAG, "objectTags", "POST", "addTag"), //
    TAG_CREATE_TAG(TAG, "tags", "POST", "createTag"), //
    TAG_GET_TAG_BYID(TAG, "tagsByID/{tagID}", "GET"), //
    TAG_GET_TAG_BYNAME(TAG, "tags/{tagname}", "GET"), //
    TAG_GET_TAGS(TAG, "objectTags/{objectID}/{objectType}", "GET"), //
    TAG_REMOVE_ALL_TAGS(TAG, "removeAllTags/{objectID}/{objectType}", "DELETE"), //
    TAG_REMOVE_TAG(TAG, "objectTags/{tag}/{objectID}/{objectType}", "DELETE"), //
    TASK_CREATE(TASK, "tasks", "POST", "create"), //
    TASK_CREATE_PERSONAL_TASK(TASK, "personalTasks", "POST", "createPersonalTask"), //
    TASK_DELETE(TASK, "tasks/{taskID}", "DELETE"), //
    TASK_GET_TASK_COUNT(TASK, "taskCount", "GET"), //
    TASK_GET_TASK_COUNTWITHFILTER(TASK, "taskCount", "POST", "getTaskCountWithFilter"), //
    TASK_GET_TASKBY_ID(TASK, "tasks/{taskID}", "GET"), //
    TASK_GET_TASKS(TASK, "tasks", "GET"), //
    TASK_GET_TASKS_BY_PROJECT(TASK, "tasksByProject/{projectID}", "GET"), //
    TASK_GET_TASKS_WITH_FILTER(TASK, "tasksWithFilter", "POST", "getTasksWithFilter"), //
    TASK_GET_UNCOMPLETE_TASKS_BY_USER_ID(TASK, "tasksByUserID/{userID}", "GET"), //
    TASK_UPDATE(TASK, "tasks", "PUT", "update"), //
    USER_CREATE_USER(USER, "users/create", "POST", "createUser"), //
    USER_CREATE_USER_WITH_USER(USER, "users", "POST", "createUserWithUser"), //
    USER_DELETE_USER_PROPERTY(USER, "properties/{userID}/{name}", "DELETE"), //
    USER_DISABLE_USER(USER, "disable", "PUT", "disableUser"), //
    USER_ENABLE_USER(USER, "enable", "PUT", "enableUser"), //
    USER_GET_USER(USER, "usersByID/{userID}", "GET"), //
    USER_GET_USER_BY_EMAIL_ADDRESS(USER, "usersByEmail/{emailAddress}", "GET"), //
    USER_GET_USER_BY_USER_NAME(USER, "users/{username}", "GET"), //
    USER_GET_USER_COUNT(USER, "users/count", "GET"), //
    USER_GET_USER_NAMES(USER, "userNames", "GET"), //
    USER_GET_USER_PROPERTIES(USER, "properties/{userID}", "GET"), //
    USER_GET_USERS(USER, "users", "GET"), //
    USER_GET_USERS_BOUNDED(USER, "usersBounded/{startIndex}/{numResults}", "GET"), //
    USER_IS_READ_ONLY(USER, "isReadOnly", "GET"), //
    USER_SET_PASSWORD(USER, "password", "PUT", "setPassword"), //
    USER_SET_USER_PROPERTY(USER, "properties", "POST", "setUserProperty"), //
    USER_UPDATE_USER(USER, "users", "PUT", "updateUser"), //
    VIDEO_CREATE_VIDEO(VIDEO, "createVideo", "POST", "createVideo"), //
    VIDEO_DELETE_VIDEO(VIDEO, "rpc/rest/videoService/deleteVideo/{videoID}", "DELETE"), //
    VIDEO_GET_VIDEO(VIDEO, "rpc/rest/videoService/videoByID/{videoID}", "GET"), //
    VIDEO_GET_VIDEOS_FOR_CONTAINER(VIDEO, "rpc/rest/videoService/videosForContainer", "POST",
                    "getVideosForContainerResponse"), //
    VIDEO_UPDATE_VIDEO(VIDEO, "updateVideo", "PUT", "updateVideo"), //
    WATCH_CREATE_COMMUNITY_WATCH(WATCH, "communityWatches", "POST", "createCommunityWatch"), //
    WATCH_CREATE_THREAD_WATCH(WATCH, "threadWatches", "POST", "createThreadWatch"), //
    WATCH_CREATE_USER_WATCH(WATCH, "userWatches", "POST", "createUserWatch"), //
    WATCH_DELETE_WATCH(WATCH, "watches/{userID}/{objectID}/{objectType}", "DELETE"), //
    WATCH_DELETE_WATCHES(WATCH, "users/{userID}", "DELETE"), //
    WATCH_GET_COMMUNITY_WATCH(WATCH, "communityWatches/{userID}/{communityID}", "GET"), //
    WATCH_GET_COMMUNITY_WATCH_COUNT(WATCH, "communityWatches/count/{userID}/{communityID}", "GET"), //
    WATCH_GET_COMMUNITY_WATCHES(WATCH, "allCommunityWatches/{userID}/{communityID}", "GET"), //
    WATCH_GET_DELETE_DAYS(WATCH, "deleteDays", "GET"), //
    WATCH_GET_THREAD_WATCH(WATCH, "threadWatches/{userID}/{threadID}", "GET"), //
    WATCH_GET_TOTAL_WATCH_COUNT(WATCH, "watches/count/{userID}/{objectType}", "GET"), //
    WATCH_GET_USER_WATCH(WATCH, "userWatches/{userID}/{watchedUserID}", "GET"), //
    WATCH_GET_WATCH_LIST(WATCH, "watches/{userID}/{objectType}", "GET"), //
    WATCH_GET_WATCH_USERS(WATCH, "users/{objectType}/{objectID}/{watchType}", "GET"), //
    WATCH_IS_COMMUNITY_WATCHED(WATCH, "isCommunityWatched/{userID}/{communityID}", "GET"), //
    WATCH_IS_THREAD_WATCHED(WATCH, "isThreadWatched/{userID}/{threadID}", "GET"), //
    WATCH_IS_USER_WATCHED(WATCH, "isUserWatched/{userID}/{watchedUserID}", "GET"), //
    WATCH_SET_DELETE_DAYS(WATCH, "deleteDays", "POST", "setDeleteDays");

    /** The service of this operation. */
    private final EntityTypeName entityType;

    /** This operation uri. */
    private final String operationName;

    /** The http protocol for this operation. */
    private final String method;

    /** Custom root tag element name */
    private final String rootTagElementName;

    /**
     * Contructor for the {@link CustomOp}.
     * 
     * @param type the entity type to which this operation applies
     * @param operationName The operation name, as present in the uri
     * @param method The http method
     */
    private CustomOp(final EntityTypeName type, final String operationName, final String method)
    {
        this.operationName = operationName;
        this.entityType = type;
        this.method = method;
        this.rootTagElementName = getRootTagElementFromName();
    }

    /**
     * @param type the entity type to which this operation applies
     * @param operationName The operation name, as present in the uri
     * @param method The http method
     * @param rootTag The root tag for the payload xml
     */
    private CustomOp(final EntityTypeName type,
                     final String operationName,
                     final String method,
                     final String rootTag)
    {
        this.operationName = operationName;
        this.entityType = type;
        this.method = method;
        this.rootTagElementName = rootTag;
    }

    /**
     * Contructor for the {@link CustomOp}.
     * 
     * @param type This op service
     * @param op The operation uri
     */
    private CustomOp(final EntityTypeName type, final String op)
    {
        this.operationName = op;
        this.entityType = type;
        this.rootTagElementName = getRootTagElementFromName();

        final String[] split = StringUtils.split(this.toString(), '_');
        if (split[1].equals("ADD") || split[1].equals("CREATE"))
        {
            this.method = "POST";
        }
        else if (split[1].equals("REMOVE") || split[1].equals("DELETE"))
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
     * @return The root tag xml element name for this custom operation.
     */
    private String getRootTagElementFromName()
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

    // /////////////

    /**
     * @return
     */
    private String getResourceUriFromOperationName()
    {
        final String[] split = StringUtils.split(this.toString(), '_');
        final StringBuffer str = new StringBuffer();
        str.append(split[1].toLowerCase());
        for (int i = 2; i < split.length; i++)
        {
            str.append(StringUtils.capitalize(split[i].toLowerCase()));
        }
        return str.toString();
    }

    // ///////////////

    /**
     * @return the opUri
     */
    public String getOperationName()
    {
        return operationName;
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
    public String getBaseOperationUri()
    {
        return this.entityType.getServiceName() + "/" + getOperationName();
    }

    /**
     * @return The root tag element for the xml of this custom operation.
     */
    public String getRootTagElementName()
    {
        return this.rootTagElementName;
    }
}
