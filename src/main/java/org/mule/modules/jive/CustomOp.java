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

/** Enum for the custom operations. */
public enum CustomOp
{

    ADDRESSBOOK_ADD_USER(ADDRESSBOOK, "addressbooks", "POST", "addUser", null), //
    ADDRESSBOOK_GET_ROSTER(ADDRESSBOOK, "addressbooks", "GET", null, "userID"), //
    ADDRESSBOOK_REMOVE_USER(ADDRESSBOOK, "addressbooks", "DELETE", null, "userID:usernameToRemove"), //
    AUDIT_EVENT(AUDIT, "audit", "POST", "auditEvent", null), //
    AVATAR_CREATE_AVATAR(AVATAR, "avatars", "POST", "createAvatar", null), //
    AVATAR_DELETE(AVATAR, "avatar", "DELETE", null, "avatarID"), //
    AVATAR_GET_ACTIVE(AVATAR, "activeAvatar", "GET", null, "userID"), //
    AVATAR_GET(AVATAR, "avatarByID", "GET", null, "avatarID"), //
    AVATAR_GET_AVATAR_COUNT(AVATAR, "avatarCount", "GET", null, "userID"), //
    AVATAR_GET_AVATARS(AVATAR, "avatarsByUser", "GET", null, "userID"), //
    AVATAR_GET_GLOBAL_AVATARS(AVATAR, "globalAvatars", "GET", null, null), //
    AVATAR_GET_MAX_ALLOWABLE_HEIGHT(AVATAR, "avatarMaxAllowableHeight", "GET", null, null), //
    AVATAR_GET_MAX_ALLOWABLE_WIDTH(AVATAR, "avatarMaxAllowableWidth", "GET", null, null), //
    AVATAR_GET_MAX_USER_AVATARS(AVATAR, "maxUserAvatars", "GET", null, null), //
    AVATAR_GET_MODERATION_AVATAR_COUNT(AVATAR, "moderationAvatarCount", "GET", null, null), //
    AVATAR_GET_MODERATION_AVATARS(AVATAR, "moderationAvatars", "GET", null, null), //
    AVATAR_IS_ALLOW_IMAGE_RESIZE(AVATAR, "avatarAllowImageResize", "GET", null, null), //
    AVATAR_IS_AVATARS_ENABLED(AVATAR, "avatarsEnabled", "GET", null, null), //
    AVATAR_IS_MODERATE_USER_AVATARS(AVATAR, "moderateUserAvatars", "GET", null, null), //
    AVATAR_IS_USER_AVATARS_ENABLED(AVATAR, "userAvatarsEnabled", "GET", null, null), //
    AVATAR_SET_ACTIVE_AVATAR(AVATAR, "activeAvatar", "POST", "setActiveAvatar", null), //
    AVATAR_SET_ALLOW_IMAGE_RESIZE(AVATAR, "avatarAllowImageResize", "POST", "setAllowImageResize", null), //
    AVATAR_SET_MAX_ALLOWABLE_HEIGHT(AVATAR, "avatarMaxAllowableHeight", "POST", "setMaxAllowableHeight", null), //
    AVATAR_SET_MAX_ALLOWABLE_WIDTH(AVATAR, "avatarMaxAllowableWidth", "POST", "setMaxAllowableWidth", null), //
    AVATAR_SET_MAX_USER_AVATARS(AVATAR, "maxUserAvatars", "POST", "setMaxUserAvatars", null), //
    AVATAR_SET_MODERATE_USER_AVATARS(AVATAR, "moderateUserAvatars", "POST", "setModerateUserAvatars", null), //
    AVATAR_SET_USER_AVATARS_ENABLED(AVATAR, "userAvatarsEnabled", "POST", "setUserAvatarsEnabled", null), //
    COMMENT_ADD(COMMENT, "comments", "POST", "addComment", null), //
    COMMENT_ADD_COMMENT_TO_COMMENT(COMMENT, "comments/addChild", "POST", "addCommentToComment", null), //
    COMMENT_DELETE_ALL(COMMENT, "comments", "DELETE", null, "objectType:objectID"), //
    COMMENT_DELETE(COMMENT, "comments", "DELETE", null, "objectType:objectID:commentID"), //
    COMMENT_DELETE_RECURSIVE(COMMENT,
                    "comments/recursiveDelete", "DELETE", null, "objectType:objectID:commentID:recursive"), //
    COMMENT_GET(COMMENT, "comments", "GET", null, "objectType:objectID:commentID"), //
    COMMENT_GET_COMMENT_COUNT(COMMENT, "commentcount", "GET", null, "objectType:objectID"), //
    COMMENT_GET_COMMENT_COUNT_WITH_FILTER(COMMENT, "comments/count", "POST", "getCommentCountWithFilter", null), //
    COMMENT_GET_ALL(COMMENT, "comments", "GET", null, "objectType:objectID"), //
    COMMENT_GET_USER_CONTENT_COMMENT_COUNT(COMMENT, "usercommentcount", "GET", null, "userID"), //
    COMMENT_GET_USER_CONTENT_COMMENT_COUNT_WITH_FILTER(COMMENT, "comments/user/count", "POST",
                    "getUserContentCommentCountWithFilter", null), //
    COMMENT_GET_USER_CONTENT_COMMENTS(COMMENT, "usercomments", "GET", null, "userID"), //
    COMMENT_GET_USER_CONTENT_COMMENTS_WITH_FILTER(COMMENT, "comments/user", "POST",
                    "getUserContentCommentsWithFilter", null), //
    COMMENT_UPDATE(COMMENT, "comments", "PUT", "updateComment", null), //
    BLOG_ADD_ATTACHMENT_TO_BLOG_POST(BLOG, "attachments", "POST", "addAttachmentToBlogPost", null), //
    BLOG_ADD_IMAGE_TO_BLOG_POST(BLOG, "images", "POST", "addImageToBlogPost", null), //
    BLOG_CREATE(BLOG, "blogs", "POST", "createBlog", null), //
    BLOG_CREATE_BLOG_POST(BLOG, "blogPosts", "POST", "createBlogPost", null), //
    BLOG_DELETE(BLOG, "blogs", "DELETE", null, "blogID"), //
    BLOG_DELETE_BLOG_POST(BLOG, "blogPosts", "DELETE", null, "blogPostID"), //
    BLOG_GET_ATTACHMENTS_BY_BLOG_POST_ID(BLOG, "attachments", "GET", null, "blogPostID"), //
    BLOG_GET_BLOG_BY_ID(BLOG, "blogsByID", "GET", null, "blogID"), //
    BLOG_GET_BLOG_BY_NAME(BLOG, "blogsByName", "GET", null, "blogName"), //
    BLOG_GET_BLOG_COUNT(BLOG, "blogCount", "GET", null, null), //
    BLOG_GET_BLOG_COUNT_BY_FILTER(BLOG, "blogCount", "POST", "getBlogCount", null), //
    BLOG_GET_BLOG_COUNT_FOR_USER(BLOG, "userBlogCount", "GET", null, "userID"), //
    BLOG_GET_BLOG_POST(BLOG, "blogPosts", "GET", null, "blogPostID"), //
    BLOG_GET_BLOG_POST_COUNT(BLOG, "blogPostCount", "GET", null, null), //
    BLOG_GET_BLOG_POST_COUNT_BY_FILTER(BLOG, "blogPostCount", "POST", "getBlogPostCount", null), //
    BLOG_GET_BLOG_POSTS_BY_FILTER(BLOG, "blogsPostsWithFilter", "POST", "getBlogPosts", null), //
    BLOG_GET_BLOGS_BY_DISPLAY_NAME(BLOG, "blogsByDisplayName/:query:startIndex:endIndex:numResults",
                    "GET", null, null), //
    BLOG_GET_BLOGS_FOR_USER(BLOG, "userBlogs", "GET", null, "userID"), //
    BLOG_GET_COMMENT_COUNT(BLOG, "commentCount", "GET", null, null), //
    BLOG_GET_COMMENT_COUNT_BY_FILTER(BLOG, "commentCountWithFilter", "POST", "getCommentCount", null), //
    BLOG_GET_COMMENTS_BY_FILTER(BLOG, "commentsWithFilter", "POST", "getComments", null), //
    BLOG_GET_IMAGES_BY_BLOG_POST_ID(BLOG, "images", "GET", null, "blogPostID"), //
    BLOG_GET_PING_SERVICES(BLOG, "pingServices", "GET", null, null), //
    BLOG_GET_RECENT_BLOGS(BLOG, "recentBlogs", "GET", null, null), //
    BLOG_GET_TAGS(BLOG, "tags", "GET", null, null), //
    BLOG_GET_TAGS_BY_FILTER(BLOG, "tags", "POST", "getTagsResponse", null), //
    BLOG_IS_BLOGS_ENABLED(BLOG, "blogsEnabled", "GET", null, null), //
    BLOG_IS_COMMENTS_ENABLED(BLOG, "commentsEnabled", "GET", null, null), //
    BLOG_IS_PINGS_ENABLED(BLOG, "pingsEnabled", "GET", null, null), //
    BLOG_IS_PINGS_OVERRIDE_ENABLED(BLOG, "pingsOverrideEnabled", "GET", null, null), //
    BLOG_IS_TRACKBACKS_ENABLED(BLOG, "trackbacksEnabled", "GET", null, null), //
    BLOG_PUBLISH_BLOG_POST(BLOG, "publishBlogPost", "POST", "publishBlogPost", null), //
    BLOG_REMOVE_ATTACHMENT(BLOG, "attachments", "DELETE", null, "attachmentID"), //
    BLOG_SET_BLOGS_ENABLED(BLOG, "blogsEnabled", "POST", "setBlogsEnabled", null), //
    BLOG_SET_COMMENTS_ENABLED(BLOG, "commentsEnabled", "POST", "setCommentsEnabled", null), //
    BLOG_SET_PING_SERVICES(BLOG, "pingServices", "POST", "setPingServices", null), //
    BLOG_SET_PINGS_ENABLED(BLOG, "pingsEnabled", "POST", "setPingsEnabled", null), //
    BLOG_SET_PINGS_OVERRIDE_ENABLED(BLOG, "pingsOverrideEnabled", "POST", "setPingsOverrideEnabled", null), //
    BLOG_SET_TRACKBACKS_ENABLED(BLOG, "trackbacksEnabled", "POST", "setTrackbacksEnabled", null), //
    BLOG_UPDATE_BLOG_POST(BLOG, "blogPosts", "PUT", "updateBlogPost", null), //
    BLOG_UPLOAD_ATTACHMENT_TO_BLOG_POST(BLOG, "attachmentUpload", "POST", "uploadAttachmentToBlogPost", null), //
    BLOG_USER_HAS_BLOGS(BLOG, "userHasBlogs", "GET", null, null), //
    COMMUNITY_CREATE(COMMUNITY, "communities", "POST", "createCommunity", null), //
    COMMUNITY_DELETE(COMMUNITY, "communities", "DELETE", null, "communityID"), //
    COMMUNITY_DELETE_PROPERTY(COMMUNITY, "properties", "DELETE", null, "communityID:name"), //
    COMMUNITY_GET(COMMUNITY, "communities", "GET", null, "communityID"), //
    COMMUNITY_GET_DOCUMENT_IDS(COMMUNITY, "documentIDs", "GET", null, "communityID"), //
    COMMUNITY_GET_PROPERTIES(COMMUNITY, "properties", "GET", null, "communityID"), //
    COMMUNITY_GET_PROPERTY(COMMUNITY, "properties", "GET", null, "communityID:name"), //
    COMMUNITY_GET_RECURSIVE_COMMUNITIES(COMMUNITY, "communities", "GET", null, null), //
    COMMUNITY_GET_RECURSIVE_COMMUNITIES_BY_COMMUNITY(COMMUNITY, "recursiveCommunities", "GET", null, "communityID"), //
    COMMUNITY_GET_RECURSIVE_COMMUNITY_COUNT(COMMUNITY, "recursiveCount", "GET", null, "communityID"), //
    COMMUNITY_GET_SUB_COMMUNITIES(COMMUNITY, "subCommunities", "GET", null, "communityID"), //
    COMMUNITY_SET_PROPERTY(COMMUNITY, "properties", "POST", "setProperty", null), //
    COMMUNITY_UPDATE(COMMUNITY, "communities", "PUT", "updateCommunity", null), //
    DOCUMENT_ADD_ATTACHMENT_TO_DOCUMENT_BY_DOCUMENT_ID(DOCUMENT, "attachments", "POST",
                    "addAttachmentToDocumentByDocumentID", null), //
    DOCUMENT_ADD_ATTACHMENT_TO_DOCUMENT_BY_INTERNAL_DOC_ID(DOCUMENT, "attachmentsByInternalDocID", "POST",
                    "addAttachmentToDocumentByInternalDocID", null), //
    DOCUMENT_ADD_AUTHOR(DOCUMENT, "authors", "POST", "addAuthor", null), //
    DOCUMENT_ADD_DOCUMENT_APPROVER_ON_COMMUNITY(DOCUMENT, "approval/communityUsers", "POST",
                    "addDocumentApproverOnCommunity", null), //
    DOCUMENT_ADD_DOCUMENT_APPROVER_ON_DOCUMENT(DOCUMENT, "approval/users", "POST",
                    "addDocumentApproverOnDocument", null), //
    DOCUMENT_ADD_IMAGE_TO_DOCUMENT_BY_DOCUMENT_ID(DOCUMENT, "images", "POST",
                    "addImageToDocumentByDocumentID", null), //
    DOCUMENT_ADD_IMAGE_TO_DOCUMENT_BY_INTERNAL_DOC_ID(DOCUMENT, "imagesByInternalDocID", "POST",
                    "addImageToDocumentByInternalDocID", null), //
    DOCUMENT_CREATE_BINARY_DOCUMENT(DOCUMENT, "binaryDocument", "POST", "createBinaryDocument", null), //
    DOCUMENT_CREATE_BINARY_DOCUMENT_IN_CONTAINER(DOCUMENT, "createBinaryDocumentInContainer", "POST",
                    "createBinaryDocumentInContainer", null), //
    DOCUMENT_CREATE(DOCUMENT, "documents", "POST", "createDocument", null), //
    DOCUMENT_CREATE_DOCUMENT_IN_CONTAINER(DOCUMENT, "createDocumentInContainer", "POST",
                    "createDocumentInContainer", null), //
    DOCUMENT_DELETE(DOCUMENT, "documents", "DELETE", null, "documentID"), //
    DOCUMENT_DELETE_DOCUMENT_PROPERTY(DOCUMENT, "properties", "DELETE", null, "documentID:name"), //
    DOCUMENT_GET_APPROVAL_STATUS_FOR_DOCUMENT(DOCUMENT, "approval/status", "GET", null, "documentID"), //
    DOCUMENT_GET_ATTACHMENT_COUNT_BY_DOCUMENT_ID(DOCUMENT, "attachmentCount", "GET", null, "documentID"), //
    DOCUMENT_GET_ATTACHMENT_COUNT_BY_INTERNAL_DOC_ID(DOCUMENT,
                    "attachmentCountByInternalDocID", "GET", null, "internalDocID"), //
    DOCUMENT_GET_ATTACHMENTS_BY_DOCUMENT_ID(DOCUMENT, "attachments", "GET", null, "documentID"), //
    DOCUMENT_GET_ATTACHMENTS_BY_INTERNAL_DOC_ID(DOCUMENT, "attachementsByInternalDocID/:internalDocID",
                    "GET", null, null), //
    DOCUMENT_GET_AUTHORS(DOCUMENT, "authors", "GET", null, "documentID"), //
    DOCUMENT_GET_BINARY_DOCUMENT_CONTENT(DOCUMENT, "binaryDocument", "GET", null, "documentID"), //
    DOCUMENT_GET_DOCUMENT_APPROVERS_ON_COMMUNITY(DOCUMENT, "approval/communityUsers", "GET", null, "communityID"), //
    DOCUMENT_GET_DOCUMENT_APPROVERS_ON_DOCUMENT(DOCUMENT, "approval/users", "GET", null, "documentID"), //
    DOCUMENT_GET_DOCUMENT_BY_DOCUMENT_ID(DOCUMENT, "documents", "GET", null, "documentID"), //
    DOCUMENT_GET_DOCUMENT_BY_DOCUMENT_ID_AND_VERSION(DOCUMENT, "documents", "GET", null, "documentID:version"), //
    DOCUMENT_GET_DOCUMENT_BY_INTERNAL_DOC_ID(DOCUMENT, "documentsByInternalDocID", "GET", null, "internalDocID"), //
    DOCUMENT_GET_DOCUMENT_BY_INTERNAL_DOC_ID_AND_VERSION(DOCUMENT,
                    "documentsByInternalDocID", "GET", null, "internalDocID:version"), //
    DOCUMENT_GET_DOCUMENT_PROPERTIES(DOCUMENT, "properties", "GET", null, "documentID"), //
    DOCUMENT_GET_DOCUMENT_PROPERTY(DOCUMENT, "properties", "GET", null, "documentID:name"), //
    DOCUMENT_GET_DOCUMENTS_BY_COMMUNITY(DOCUMENT, "documentsByCommunity", "GET", null, "communityID"), //
    DOCUMENT_GET_DOCUMENTS_BY_COMMUNITY_AND_FILTER(DOCUMENT, "documentsByCommunityAndFilter", "POST",
                    "getDocumentsByCommunityAndFilter", null), //
    DOCUMENT_GET_IMAGE_COUNT_BY_DOCUMENT_ID(DOCUMENT, "imageCount", "GET", null, "documentID"), //
    DOCUMENT_GET_IMAGE_COUNT_BY_INTERNAL_DOC_ID(DOCUMENT, "imageCountByInternalDocID", "GET", null, "internalDocID"), //
    DOCUMENT_GET_IMAGES_BY_DOCUMENT_ID(DOCUMENT, "images", "GET", null, "documentID"), //
    DOCUMENT_GET_IMAGES_BY_INTERNAL_DOC_ID(DOCUMENT, "imagesByInternalDocID", "GET", null, "internalDocID"), //
    DOCUMENT_GET_POPULAR_DOCUMENTS(DOCUMENT, "popularDocuments", "GET", null, null), //
    DOCUMENT_GET_POPULAR_DOCUMENTS_BY_COMMUNITY(DOCUMENT, "popularDocumentsByCommunity", "GET", null, "communityID"), //
    DOCUMENT_GET_POPULAR_DOCUMENTS_BY_LANGUAGE(DOCUMENT, "documentsByLanguage", "GET", null, "languages"), //
    DOCUMENT_GET_USER(DOCUMENT, "user", "GET", null, "documentID"), //
    DOCUMENT_GET_USER_APPROVAL_DOCUMENTS(DOCUMENT, "approvers", "GET", null, "userID"), //
    DOCUMENT_IS_COMMENTS_ENABLED(DOCUMENT, "commentsEnabled", "GET", null, null), //
    DOCUMENT_IS_TRACKBACKS_ENABLED(DOCUMENT, "trackbacksEnabled", "GET", null, null), //
    DOCUMENT_MOVE(DOCUMENT, "moveDocument", "POST", "moveDocument", null), //
    DOCUMENT_MOVE_DOCUMENT_TO_CONTAINER(DOCUMENT, "moveDocumentToContainer", "POST",
                    "moveDocumentToContainer", null), //
    DOCUMENT_PUBLISH_BINARY_DOCUMENT(DOCUMENT, "publishBinaryDocument", "POST", "publishBinaryDocument", null), //
    DOCUMENT_PUBLISH_BINARY_DOCUMENT_IN_CONTAINER(DOCUMENT, "publishBinaryDocumentInContainer", "POST",
                    "publishBinaryDocumentInContainer", null), //
    DOCUMENT_PUBLISH_DOCUMENT(DOCUMENT, "publish", "PUT", "publishDocument", null), //
    DOCUMENT_PUBLISH_DOCUMENT_IN_CONTAINER(DOCUMENT, "publishDocumentInContainer", "PUT",
                    "publishDocumentInContainer", null), //
    DOCUMENT_REMOVE_ATTACHMENT(DOCUMENT, "attachments", "DELETE", null, "attachmentID"), //
    DOCUMENT_REMOVE_AUTHOR(DOCUMENT, "authors", "DELETE", null, "documentID:userID"), //
    DOCUMENT_SET_COMMENTS_ENABLED(DOCUMENT, "commentsEnabled", "POST", "setCommentsEnabled", null), //
    DOCUMENT_SET_DOCUMENT_PROPERTY(DOCUMENT, "properties", "POST", "setDocumentProperty", null), //
    DOCUMENT_SET_TRACKBACKS_ENABLED(DOCUMENT, "trackbacksEnabled", "POST", "setTrackbacksEnabled", null), //
    DOCUMENT_UPDATE(DOCUMENT, "documents", "PUT", "updateDocument", null), //
    DOCUMENT_UPLOAD_ATTACHMENT_TO_DOCUMENT_BY_DOCUMENT_ID(DOCUMENT, "attachmentUpload", "POST",
                    "uploadAttachmentToDocumentByDocumentID", null), //
    DOCUMENT_UPLOAD_ATTACHMENT_TO_DOCUMENT_BY_INTERNAL_DOC_ID(DOCUMENT, "attachmentUploadByInternalDocID",
                    "POST", "uploadAttachmentToDocumentByInternalDocID", null), //
    ENTITLEMENT_ADD_GROUP_ENTITLEMENT(ENTITLEMENT, "entitlements", "POST", "addGroupEntitlement", null), //
    ENTITLEMENT_ADD_USER_ENTITLEMENT(ENTITLEMENT, "entitlements", "POST", "addUserEntitlement", null), //
    ENTITLEMENT_GET_ENTITLEMENT_MASKS(ENTITLEMENT, "entitlements", "GET", null, null), //
    ENTITLEMENT_IS_USER_ENTITLED(ENTITLEMENT, "entitlements", "GET", null, null), //
    ENTITLEMENT_REMOVE_GROUP_ENTITLEMENT(ENTITLEMENT, "entitlements", "POST", "removeGroupEntitlement", null), //
    ENTITLEMENT_REMOVE_USER_ENTITLEMENT(ENTITLEMENT, "entitlements", "POST", "removeUserEntitlement", null), //
    FORUM_ADD_ATTACHMENT_TO_MESSAGE(FORUM, "attachments", "POST", "addAttachmentToMessage", null), //
    FORUM_ADD_IMAGE_TO_MESSAGE(FORUM, "images", "POST", "addImageToMessage", null), //
    FORUM_CREATE_MESSAGE(FORUM, "messages", "POST", "createMessage", null), //
    FORUM_CREATE_REPLY_MESSAGE(FORUM, "replyMessage", "POST", "createReplyMessage", null), //
    FORUM_CREATE_THREAD(FORUM, "threads", "POST", "createThread", null), //
    FORUM_DELETE_MESSAGE(FORUM, "messages", "DELETE", null, "messageID"), //
    FORUM_DELETE_MESSAGE_AND_CHILDREN(FORUM, "messages", "DELETE", null, "messageID:deleteChildren"), //
    FORUM_DELETE_MESSAGE_PROPERTY(FORUM, "properties", "DELETE", null, null), //
    FORUM_DELETE_THREAD(FORUM, "threads", "DELETE", null, "threadID"), //
    FORUM_DELETE_THREAD_PROPERTY(FORUM, "threadProperties", "DELETE", null, "threadID:name"), //
    FORUM_GET_ATTACHMENTS_BY_MESSAGE_ID(FORUM, "attachments", "GET", null, "messageID"), //
    FORUM_GET_CHILD(FORUM, "children", "GET", null, "messageID:index"), //
    FORUM_GET_CHILD_COUNT(FORUM, "childCount", "GET", null, "messageID"), //
    FORUM_GET_CHILDREN(FORUM, "children", "GET", null, "mesageID"), //
    FORUM_GET_FORUM_MESSAGE(FORUM, "messages", "GET", null, "messageID"), //
    FORUM_GET_FORUM_THREAD(FORUM, "threads", "GET", null, "threadID"), //
    FORUM_GET_IMAGES_BY_MESSAGE_ID(FORUM, "images", "GET", null, "messageID"), //
    FORUM_GET_INDEX_OF_CHILD(FORUM, "indexOfChild", "GET", null, "parentID:messageID"), //
    FORUM_GET_MESSAGE_COUNT_BY_COMMUNITY_ID(FORUM, "messageCountByCommunityID", "GET", null, "communityID"), //
    FORUM_GET_MESSAGE_COUNT_BY_COMMUNITY_ID_AND_FILTER(FORUM, "messageCountByCommunityID", "POST",
                    "getMessageCountByCommunityIDAndFilter", null), //
    FORUM_GET_MESSAGE_COUNT_BY_THREAD_ID(FORUM, "messageCountByThreadID", "GET", null, "threadID"), //
    FORUM_GET_MESSAGE_COUNT_BY_THREAD_ID_AND_FILTER(FORUM, "messageCountByThreadID", "POST",
                    "getMessageCountByThreadIDAndFilter", null), //
    FORUM_GET_MESSAGE_COUNTS_BY_COMMUNITY_ID_AND_FILTER(FORUM, "messageCountsByCommunityID", "POST",
                    "getMessageCountsByCommunityIDAndFilter", null), //
    FORUM_GET_MESSAGE_DEPTH(FORUM, "messageDepth", "GET", null, "messageID"), //
    FORUM_GET_MESSAGE_IDS_BY_COMMUNITY_ID(FORUM, "messageIDsByCommunityID", "GET", null, "communityID"), //
    FORUM_GET_MESSAGE_IDS_BY_COMMUNITY_ID_AND_FILTER(FORUM, "messageIdsByCommunityID/:communityID", "POST",
                    "getMessageIDsByCommunityIDAndFilter", null), //
    FORUM_GET_MESSAGE_IDS_BY_THREAD_ID(FORUM, "messageIDsByThreadID", "GET", null, "threadID"), //
    FORUM_GET_MESSAGE_IDS_BY_THREAD_ID_AND_FILTER(FORUM, "messageIDsByThreadID", "POST",
                    "getMessageIDsByThreadIDAndFilter", null), //
    FORUM_GET_MESSAGE_PROPERTIES(FORUM, "properties", "GET", null, "messageID"), //
    FORUM_GET_MESSAGE_PROPERTY(FORUM, "properties", "GET", null, "messageID:name"), //
    FORUM_GET_MESSAGES_BY_COMMUNITY_ID(FORUM, "messagesByCommunityID", "GET", null, "communityID"), //
    FORUM_GET_MESSAGES_BY_COMMUNITY_ID_AND_FILTER(FORUM, "messagesByCommunityID", "POST",
                    "getMessagesByCommunityIDAndFilter", null), //
    FORUM_GET_MESSAGES_BY_THREAD_ID(FORUM, "messagesByThreadID", "GET", null, "threadID"), //
    FORUM_GET_MESSAGES_BY_THREAD_ID_AND_FILTER(FORUM, "messagesByThreadID", "POST",
                    "getMessagesByThreadIDAndFilter", null), //
    FORUM_GET_PARENT(FORUM, "parentMessage", "GET", null, "messageID"), //
    FORUM_GET_POPULAR_THREADS(FORUM, "popularThreads", "GET", null, null), //
    FORUM_GET_POPULAR_THREADS_BY_COMMUNITY_ID(FORUM, "popularThreadsByCommunityID", "GET", null, "communityID"), //
    FORUM_GET_RECURSIVE_CHILD_COUNT(FORUM, "recursiveChildCount", "GET", null, "messageID"), //
    FORUM_GET_RECURSIVE_CHILDREN(FORUM, "recursiveChildren", "GET", null, "messageID"), //
    FORUM_GET_RECUSIVE_MESSAGES(FORUM, "recusiveMessages", "GET", null, "threadID"), //
    FORUM_GET_ROOT_MESSAGE(FORUM, "rootMessage", "GET", null, "threadID"), //
    FORUM_GET_THREAD_COUNT_BY_COMMUNITY_ID(FORUM, "threadCountByCommunityID", "GET", null, "communityID"), //
    FORUM_GET_THREAD_COUNT_BY_COMMUNITY_ID_AND_FILTER(FORUM, "threadCountByCommunityID", "POST",
                    "getThreadCountByCommunityIDAndFilter", null), //
    FORUM_GET_THREAD_PROPERTIES(FORUM, "threadProperties", "GET", null, "threadID"), //
    FORUM_GET_THREAD_PROPERTY(FORUM, "threadProperties", "GET", null, "threadID:name"), //
    FORUM_GET_THREADS_BY_COMMUNITY_ID(FORUM, "threadsByCommunityID", "GET", null, "communityID"), //
    FORUM_GET_THREADS_BY_COMMUNITY_ID_AND_FILTER(FORUM, "threadsByCommunityID", "POST",
                    "getThreadsByCommunityIDAndFilter", null), //
    FORUM_GET_UNFILTERED_MESSAGE_PROPERTIES(FORUM, "unfilteredProperties", "GET", null, "messageID"), //
    FORUM_HAS_PARENT(FORUM, "hasParent", "GET", null, "messageID"), //
    FORUM_IS_LEAF(FORUM, "isLeaf", "GET", null, "messageID"), //
    FORUM_MOVE_THREAD(FORUM, "moveThread", "PUT", "moveThread", null), //
    FORUM_MOVE_THREAD_TO_CONTAINER(FORUM, "moveThreadToContainer", "PUT", "moveThreadToContainer", null), //
    FORUM_REMOVE_ATTACHMENT(FORUM, "attachments", "DELETE", null, "attachmentID"), //
    FORUM_SET_MESSAGE_PROPERTY(FORUM, "properties", "POST", "setMessageProperty", null), //
    FORUM_SET_THREAD_PROPERTY(FORUM, "threadProperties", "POST", "setThreadProperty", null), //
    FORUM_UPDATE_FORUM_MESSAGE(FORUM, "messages", "PUT", "updateForumMessage", null), //
    FORUM_UPLOAD_ATTACHMENT_TO_MESSAGE(FORUM, "attachmentUpload", "POST", "uploadAttachmentToMessage", null), //
    GROUP_ADD_ADMINISTRATOR_TO_GROUP(GROUP, "groupAdmins", "POST", "addAdministratorToGroup", null), //
    GROUP_ADD_MEMBER_TO_GROUP(GROUP, "groupMembers", "POST", "addMemberToGroup", null), //
    GROUP_CREATE_GROUP(GROUP, "groups", "POST", "createGroup", null), //
    GROUP_DELETE_GROUP(GROUP, "groups", "DELETE", null, "groupID"), //
    GROUP_DELETE_PROPERTY(GROUP, "properties", "DELETE", null, "groupID:name"), //
    GROUP_GET_ADMINISTRATOR_COUNT(GROUP, "administratorCount", "GET", null, "groupID"), //
    GROUP_GET_GROUP(GROUP, "groupsByID", "GET", null, "groupID"), //
    GROUP_GET_GROUP_ADMINS(GROUP, "groupAdmins", "GET", null, "groupID"), //
    GROUP_GET_GROUP_BYNAME(GROUP, "groups", "GET", null, "name"), //
    GROUP_GET_GROUP_COUNT(GROUP, "groupCount", "GET", null, null), //
    GROUP_GET_GROUP_MEMBERS(GROUP, "groupMembers", "GET", null, "groupID"), //
    GROUP_GET_GROUP_NAMES(GROUP, "groupNames", "GET", null, null), //
    GROUP_GET_GROUP_NAMES_BOUNDED(GROUP, "groupNamesBounded", "GET", null, "startIndex:numResults"), //
    GROUP_GET_GROUPS(GROUP, "groups", "GET", null, null), //
    GROUP_GET_PROPERTIES(GROUP, "properties", "GET", null, "groupID"), //
    GROUP_GET_USER_GROUP_NAMES(GROUP, "userGroupNames", "GET", null, "userID"), //
    GROUP_GET_USER_GROUPS(GROUP, "userGroups", "GET", null, "userID"), //
    GROUP_IS_READ_ONLY(GROUP, "isReadOnly", "GET", null, null), //
    GROUP_REMOVE_ADMINISTRATOR_FROM_GROUP(GROUP, "groupAdmins", "DELETE", null, "groupID:userID"), //
    GROUP_REMOVE_MEMBER_FROM_GROUP(GROUP, "groupMembers", "DELETE", null, "groupID:userID"), //
    GROUP_SET_PROPERTY(GROUP, "properties", "POST", "setProperty", null), //
    GROUP_UPDATE_GROUP(GROUP, "groups", "PUT", "configureComponent", null), //
    IMSERVICE_CONFIGURE_COMPONENT(IMSERVICE, "configureComponent", "POST", "configureComponent", null), //
    IMSERVICE_GENERATE_NONCE(IMSERVICE, "generateNonce", "GET", null, null), //
    IMSERVICE_TEST_CREDENTIALS(IMSERVICE, "testCredentials", "GET", null, null), //
    PLUGIN_GET_PLUGIN_INFO(PLUGIN, "plugins", "GET", null, null), //
    PLUGIN_INSTALL_PLUGIN(PLUGIN, "plugins", "POST", "installPlugin", null), //
    PLUGIN_UNINSTALL_PLUGIN(PLUGIN, "plugins", "DELETE", null, "pluginName"), //
    POLL_ADD_ANONYMOUS_VOTE(POLL, "votes/anonymous", "POST", "addAnonymousVote", null), //
    POLL_ADD_OPTION(POLL, "options", "POST", "addOption", null), //
    POLL_ADD_USER_VOTE(POLL, "votes/user", "POST", "addUserVote", null), //
    POLL_CHANGE_ANONYMOUS_VOTE(POLL, "votes/anonymous", "PUT", "changeAnonymousVote", null), //
    POLL_CHANGE_USER_VOTE(POLL, "votes/user", "PUT", "changeUserVote", null), //
    POLL_CREATE_POLL(POLL, "polls", "POST", "createPoll", null), //
    POLL_DELETE_OPTION(POLL, "options", "DELETE", null, "pollID:index"), //
    POLL_DELETE_POLL(POLL, "polls", "DELETE", null, "pollID"), //
    POLL_GET_ACTIVE_POLL_COUNT(POLL, "activePollCount", "GET", null, null), //
    POLL_GET_ACTIVE_POLL_COUNT_BY_OBJECT_TYPE_AND_OBJECT_ID(POLL, "activePollCount/:objectType:objectID",
                    "GET", null, null), //
    POLL_GET_ACTIVE_POLLS(POLL, "activePolls", "GET", null, null), //
    POLL_GET_ACTIVE_POLLS_BY_OBJECT_TYPE_AND_OBJECT_ID(POLL, "activePolls", "GET", null, "objectType:objectID"), //
    POLL_GET_ANONYMOUS_VOTE_COUNT(POLL, "votes/anonymousCount", "GET", null, "pollID"), //
    POLL_GET_ANONYMOUS_VOTE_COUNT_BY_INDEX(POLL, "votes/anonymousCount", "GET", null, "pollID:index"), //
    POLL_GET_ANONYMOUS_VOTE_INDICES(POLL, "votes/anonymousIndices", "GET", null, "pollID:uniqueID"), //
    POLL_GET_ANONYMOUS_VOTES(POLL, "votes/anonymous", "GET", null, "pollID"), //
    POLL_GET_ANONYMOUS_VOTES_BY_INDEX(POLL, "votes/anonymous", "GET", null, "pollID:index"), //
    POLL_GET_LIVE_POLL_COUNT(POLL, "livePollCount", "GET", null, null), //
    POLL_GET_LIVE_POLL_COUNT_BY_OBJECT_TYPE_AND_OBJECT_ID(POLL, "livePollCount/:objectType:objectID",
                    "GET", null, null), //
    POLL_GET_LIVE_POLLS(POLL, "livePolls", "GET", null, null), //
    POLL_GET_LIVE_POLLS_BY_OBJECT_TYPE_AND_OBJECT_ID(POLL, "livePolls", "GET", null, "objectType:objectID"), //
    POLL_GET_POLL(POLL, "polls", "GET", null, "pollID"), //
    POLL_GET_POLL_COUNT(POLL, "pollCount", "GET", null, null), //
    POLL_GET_POLL_COUNT_BY_OBJECT_TYPE_AND_OBJECT_ID(POLL, "pollCount", "GET", null, "objectType:objectID"), //
    POLL_GET_POLLS(POLL, "polls", "GET", null, null), //
    POLL_GET_POLLS_BY_OBJECT_TYPE_AND_OBJECT_ID(POLL, "polls", "GET", null, "objectType:objectID"), //
    POLL_GET_USER_VOTE_COUNT(POLL, "votes/userCount", "GET", null, "pollID"), //
    POLL_GET_USER_VOTE_COUNT_BY_INDEX(POLL, "votes/userCount", "GET", null, "pollID:index"), //
    POLL_GET_USER_VOTE_INDICES(POLL, "votes/userIndices", "GET", null, "pollID:userID"), //
    POLL_GET_USER_VOTES(POLL, "votes", "GET", null, "pollID"), //
    POLL_GET_USER_VOTES_BY_INDEX(POLL, "votes", "GET", null, "pollID:index"), //
    POLL_GET_VOTE_COUNT(POLL, "votes/count", "GET", null, "pollID"), //
    POLL_GET_VOTE_COUNT_BY_INDEX(POLL, "votesByIndex", "GET", null, "pollID:index"), //
    POLL_HAS_ANONYMOUS_VOTED(POLL, "votes/anonymousVoted", "GET", null, "pollID:uniqueID"), //
    POLL_HAS_USER_VOTED(POLL, "votes/userVoted", "GET", null, "pollID:userID"), //
    POLL_IS_MODE_ENABLED(POLL, "modes", "GET", null, "pollID:mode"), //
    POLL_REMOVE_ANONYMOUS_VOTE(POLL, "votes/anonymous", "DELETE", null, "pollID:prevOptionIndex:uniqueID"), //
    POLL_REMOVE_USER_VOTE(POLL, "votes/user", "DELETE", null, "pollID:prevOptionIndex:userID"), //
    POLL_SET_MODE(POLL, "modes", "POST", "setMode", null), //
    POLL_SET_OPTION(POLL, "options", "PUT", "setOption", null), //
    POLL_SET_OPTION_INDEX(POLL, "options/index", "PUT", "setOptionIndex", null), //
    POLL_UPDATE(POLL, "polls", "PUT", "createFolder", null), //
    PRIVATE_MESSAGE_CREATE_FOLDER(PRIVATE_MESSAGE, "/rpc/rest/privateMessageService/folders", "POST",
                    "createFolder", null), //
    PRIVATE_MESSAGE_CREATE_MESSAGE(PRIVATE_MESSAGE, "/rpc/rest/privateMessageService/messages", "POST",
                    "createMessage", null), //
    PRIVATE_MESSAGE_DELETE_FOLDER(PRIVATE_MESSAGE,
                    "/rpc/rest/privateMessageService/folders", "DELETE", null, "userID:folderID"), //
    PRIVATE_MESSAGE_DELETE_MESSAGE(PRIVATE_MESSAGE,
                    "/rpc/rest/privateMessageService/userMessages", "DELETE", null, "userID:messageID"), //
    PRIVATE_MESSAGE_GET_FOLDER(PRIVATE_MESSAGE,
                    "/rpc/rest/privateMessageService/folders", "GET", null, "userID:folderID"), //
    PRIVATE_MESSAGE_GET_FOLDERS(PRIVATE_MESSAGE, "/rpc/rest/privateMessageService/folders", "GET", null, "userID"), //
    PRIVATE_MESSAGE_GET_MESSAGE(PRIVATE_MESSAGE,
                    "/rpc/rest/privateMessageService/messages", "GET", null, "privateMessageID"), //
    PRIVATE_MESSAGE_GET_MESSAGE_COUNT(PRIVATE_MESSAGE,
                    "/rpc/rest/privateMessageService/messageCount", "GET", null, "userID"), //
    PRIVATE_MESSAGE_GET_MESSAGE_COUNT_FOR_FOLDER(PRIVATE_MESSAGE,
                    "/rpc/rest/privateMessageService/messsageCount", "GET", null, "userID:folderID"), //
    PRIVATE_MESSAGE_GET_MESSAGES(PRIVATE_MESSAGE,
                    "/rpc/rest/privateMessageService/userMesages", "GET", null, "userID:folderID"), //
    PRIVATE_MESSAGE_GET_UNREAD_MESSAGE_COUNT(PRIVATE_MESSAGE,
                    "/rpc/rest/privateMessageService/unreadMessageCount", "GET", null, "userID"), //
    PRIVATE_MESSAGE_GET_UNREAD_MESSAGE_COUNT_FOR_FOLDER(PRIVATE_MESSAGE,
                    "/rpc/rest/privateMessageService/unreadMessageCount", "GET", null, "userID:folderID"), //
    PRIVATE_MESSAGE_IS_PRIVATE_MESSAGE_ENABLED(PRIVATE_MESSAGE,
                    "/rpc/rest/privateMessageService/privateMessagesEnabled", "GET", null, null), //
    PRIVATE_MESSAGE_MOVE_MESSAGE(PRIVATE_MESSAGE, "/rpc/rest/privateMessageService/moveMessage", "POST",
                    "moveMessage", null), //
    PRIVATE_MESSAGE_SAVE_MESSAGE_AS_DRAFT(PRIVATE_MESSAGE, "/rpc/rest/privateMessageService/saveDraft",
                    "POST", "saveMessageAsDraft", null), //
    PRIVATE_MESSAGE_SEND_MESSAGE(PRIVATE_MESSAGE, "/rpc/rest/privateMessageService/sendMessage", "POST",
                    "sendMessage", null), //
    PROFILE_CREATE_PROFILE_FIELD(PROFILE_FIELD, "/rpc/rest/profileFieldService/fields", "POST",
                    "createProfileField", null), //
    PROFILE_DELETE_PROFILE_FIELD(PROFILE_FIELD, "/rpc/rest/profileFieldService/fields", "DELETE", null, "fieldID"), //
    PROFILE_EDIT_PROFILE_FIELD(PROFILE_FIELD, "/rpc/rest/profileFieldService/fields", "PUT",
                    "editProfileField", null), //
    PROFILE_EDIT_PROFILE_FIELD_OPTIONS(PROFILE_FIELD, "/rpc/rest/profileFieldService/options", "PUT",
                    "editProfileFieldOptions", null), //
    PROFILE_GET_DEFAULT_FIELDS(PROFILE_FIELD, "/rpc/rest/profileFieldService/defaultFields", "GET", null, null), //
    PROFILE_GET_PROFILE_FIELD(PROFILE_FIELD, "/rpc/rest/profileFieldService/fields", "GET", null, "fieldID"), //
    PROFILE_GET_PROFILE_FIELDS(PROFILE_FIELD, "/rpc/rest/profileFieldService/fields", "GET", null, null), //
    PROFILE_SET_INDEX(PROFILE_FIELD, "/rpc/rest/profileFieldService/index", "POST", "setIndex", null), //
    PROFILE_GET_SIMILAR_USER_RESULTS(EntityTypeName.PROFILE_SEARCH,
                    "/rpc/rest/profileSearchService/similarUsers", "GET", null, "targetUserID"), //
    PROFILE_IS_SEARCH_ENABLED(EntityTypeName.PROFILE_SEARCH,
                    "/rpc/rest/profileSearchService/isSearchEnabled", "GET", null, null), //
    PROFILE_SEARCH(EntityTypeName.PROFILE_SEARCH, "/rpc/rest/profileSearchService/searchProfile", "POST",
                    "search", null), //
    PROFILE_SEARCH_BOUNDED(EntityTypeName.PROFILE_SEARCH,
                    "/rpc/rest/profileSearchService/searchProfileBounded", "POST", "searchBounded", null), //
    PROFILE_ADD_PROFILE(PROFILE, "profiles", "POST", "addProfile", null), //
    PROFILE_DELETE_PROFILE_BY_ID(PROFILE, "fields", "DELETE", null, "fieldID"), //
    PROFILE_DELETE_PROFILE_BY_USER_ID(PROFILE, "profiles", "DELETE", null, "userID"), //
    PROFILE_DELETE_USER_STATUS(PROFILE, "status", "DELETE", null, "userID"), //
    PROFILE_GET_CURRENT_STATUS(PROFILE, "currentStatus", "GET", null, "userID"), //
    PROFILE_PROFILE_FIELD(PROFILE, "profiles", "GET", null, "userID"), //
    PROFILE_GET_PROFILE_IMAGE(PROFILE, "images", "GET", null, "userID"), //
    PROFILE_GET_RECENT_STATUS_UPDATES(PROFILE, "status", "GET", null, null), //
    PROFILE_GET_RECENT_STATUS_UPDATES_FOR_USER(PROFILE, "status", "GET", null, "userID"), //
    PROFILE_GET_STATUS_MESSAGE_MAX_LENGTH(PROFILE, "statusMessagesMaxLength", "GET", null, null), //
    PROFILE_GET_TODAYS_STATUS_UPDATES(PROFILE, "todaysStatus", "GET", null, "userID"), //
    PROFILE_GET_USER_STATUS(PROFILE, "userStatus", "GET", null, "statusID"), //
    PROFILE_GET_YESTERDAYS_STATUS_UPDATES(PROFILE, "yesterdaysStatus", "GET", null, "userID"), //
    PROFILE_IS_STATUS_UPDATES_ENABLED(PROFILE, "statusUpdatesEnabled", "GET", null, null), //
    PROFILE_SET_CURRENT_STATUS(PROFILE, "status", "POST", "setCurrentStatus", null), //
    PROFILE_SET_PROFILE(PROFILE, "profiles", "PUT", "setProfile", null), //
    PROFILE_SET_PROFILE_IMAGE(PROFILE, "images", "POST", "setProfileImage", null), //
    PROJECT_CREATE(PROJECT, "projects", "POST", "create", null), //
    PROJECT_DELETE(PROJECT, "projects", "DELETE", null, "projectID"), //
    PROJECT_GET_CHECK_POINTS(PROJECT, "checkPointsByProject", "GET", null, "projectID"), //
    PROJECT_GET_PROJECT_BYID(PROJECT, "projects", "GET", null, "projectID"), //
    PROJECT_GET_PROJECT_COUNT(PROJECT, "projectCount", "GET", null, null), //
    PROJECT_GET_PROJECTS(PROJECT, "projects", "GET", null, null), //
    PROJECT_GET_USER_COUNT(PROJECT, "userCount", "GET", null, "projectID"), //
    PROJECT_SET_CHECK_POINTS(PROJECT, "checkPoints", "PUT", "setCheckPoints", null), //
    PROJECT_UPDATE(PROJECT, "projects", "PUT", "update", null), //
    RATINGS_ADD_RATING(RATINGS, "objectRatings/user", "PUT", "addRating", null), //
    RATINGS_CREATE_RATING(RATINGS, "ratings", "POST", "createRating", null), //
    RATINGS_GET_AVAILABLE_RATINGCOUNT(RATINGS, "ratings/count", "GET", null, null), //
    RATINGS_GET_AVAILABLE_RATINGS(RATINGS, "ratings", "GET", null, null), //
    RATINGS_GET_MEAN_RATING(RATINGS, "objectRatings/mean", "GET", null, "objectType:objectID"), //
    RATINGS_GET_RATING(RATINGS, "objectRatings/user", "GET", null, "objectType:objectID"), //
    RATINGS_GET_RATING_COUNT(RATINGS, "objectRatings/count", "GET", null, "objectType:objectID"), //
    RATINGS_GET_RATING_FROM_SCORE(RATINGS, "ratingFromScore", "POST", "getRatingFromScore", "score"), //
    RATINGS_GET_RATINGS(RATINGS, "objectRatings", "GET", null, "objectType:objectID"), //
    RATINGS_HAS_RATED(RATINGS, "objectRatings/userHasRated", "GET", null, "objectType:objectID"), //
    RATINGS_IS_RATINGS_ENABLED(RATINGS, "ratingsEnabled", "GET", null, null), //
    RATINGS_REMOVE_RATING(RATINGS, "ratings", "DELETE", null, "score"), //
    RATINGS_SET_RATINGS_ENABLED(RATINGS, "ratingsEnabled", "POST", "addReference", null), //
    REFERENCE_ADD_REFERENCE(REFERENCE, "references", "POST", "addReference", null), //
    REFERENCE_DELETE_ALL_REFERENCES(REFERENCE, "references", "DELETE", null, "refererObjectType:refererObjectID"), //
    REFERENCE_DELETE_ALL_REFERERS(REFERENCE, "referers", "DELETE", null, "referenceObjectType:referenceObjectID"), //
    REFERENCE_DELETE_REFERENCE(
                    REFERENCE,
                    "references/:refererObjectType:refererObjectID:referenceObjectType:referenceObjectID",
                    "DELETE", null, null), //
    REFERENCE_GET_REFERENCES(REFERENCE, "references", "GET", null, "refererObjectType:refererObjectID"), //
    REFERENCE_GET_REFERERS(REFERENCE, "referers", "GET", null, "referenceObjectType:referenceObjectID"), //
    SEARCH_COUNT_QUICK_MESSAGESEARCHRESULTSBYCOMMUNITYID(SEARCH,
                    "communitySearchCount", "GET", null, "communityID:query:contentTypes"), //
    SEARCH_COUNT_QUICK_SEARCHRESULTS(SEARCH, "quickSearchCount", "POST", "countQuickSearchResults", null), //
    SEARCH_COUNT_SEARCH_RESULTS(SEARCH, "searchCount", "POST", "countSearchResults", null), //
    SEARCH_COUNT_SEARCH_RESULTSBYCOMMUNITYID(SEARCH, "communitySearchCount", "POST",
                    "countSearchResultsByCommunityID", null), //
    SEARCH_QUICK_MESSAGE_SEARCHBYCOMMUNITYID(SEARCH,
                    "communitySearch", "GET", null, "communityID:query:contentTypes:startIndex:numResults"), //
    SEARCH_QUICK_SEARCH(SEARCH, "quickSearch", "POST", "quickSearch", null), //
    SEARCH_SEARCH(SEARCH, "search", "POST", "search", null), //
    SEARCH_SEARCH_BY_COMMUNITIES(SEARCH, "communitySearch", "POST", "searchByCommunities", null), //
    SOCIAL_ADD_MEMBER(SOCIAL_GROUP, "/rpc/rest/socialGroupService/socialGroupMembers", "POST", "addMember", null), //
    SOCIAL_CREATE_SOCIAL_GROUP(SOCIAL_GROUP, "/rpc/rest/socialGroupService/socialGroup", "POST",
                    "createSocialGroup", null), //
    SOCIAL_DELETE_SOCIAL_GROUP(SOCIAL_GROUP, "/rpc/rest/socialGroupService/socialGroup/:socialGroupID",
                    "DELETE", null, null), //
    SOCIAL_GET_MEMBER_COUNT(SOCIAL_GROUP, "/rpc/rest/socialGroupService/membercount", "GET", null, "socialGroupID"), //
    SOCIAL_GET_MEMBERS(SOCIAL_GROUP, "/rpc/rest/socialGroupService/members", "GET", null, "socialGroupID"), //
    SOCIAL_GET_SOCIAL_GROUP(SOCIAL_GROUP, "/rpc/rest/socialGroupService/socialGroupsByID/:socialGroupID",
                    "GET", null, null), //
    SOCIAL_GET_SOCIAL_GROUPBYNAME(SOCIAL_GROUP,
                    "/rpc/rest/socialGroupService/socialGroupsByName", "GET", null, "displayName"), //
    SOCIAL_GET_SOCIAL_GROUPCOUNT(SOCIAL_GROUP, "/rpc/rest/socialGroupService/socialGroupCount", "GET", null, null), //
    SOCIAL_GET_SOCIAL_GROUPNAMES(SOCIAL_GROUP, "/rpc/rest/socialGroupService/socialGroupNames", "GET", null, null), //
    SOCIAL_GET_SOCIAL_GROUPNAMESBOUNDED(SOCIAL_GROUP,
                    "/rpc/rest/socialGroupService/socialGroupNamesBounded", "GET", null, "startIndex:numResults"), //
    SOCIAL_GET_SOCIAL_GROUPS(SOCIAL_GROUP, "/rpc/rest/socialGroupService/socialGroups", "GET", null, null), //
    SOCIAL_GET_USER_SOCIALGROUPNAMES(SOCIAL_GROUP,
                    "/rpc/rest/socialGroupService/userSocialGroupNames", "GET", null, "userID"), //
    SOCIAL_GET_USER_SOCIALGROUPS(SOCIAL_GROUP, "/rpc/rest/socialGroupService/userSocialGroups/:userID",
                    "GET", null, null), //
    SOCIAL_REMOVE_MEMBER(SOCIAL_GROUP,
                    "/rpc/rest/socialGroupService/socialGroupMembers", "DELETE", null, "socialGroupID:userID"), //
    SOCIAL_SEARCH_SOCIAL_GROUPS(SOCIAL_GROUP, "/rpc/rest/socialGroupService/searchSocialGroups/", "POST",
                    "searchSocialGroups", null), //
    SOCIAL_UPDATE_SOCIAL_GROUP(SOCIAL_GROUP, "/rpc/rest/socialGroupService/socialGroup", "PUT",
                    "updateSocialGroup", null), //
    STATUS_ADD_POINTS(STATUS_LEVEL, "/rpc/rest/statusLevelService/addPoints", "POST", "addPoints", null), //
    STATUS_ADD_POINTS_BY_CONTAINER(STATUS_LEVEL, "/rpc/rest/statusLevelService/addPointsByContainer", "POST",
                    "addPoints", null), //
    STATUS_CREATE_STATUS_LEVEL_POINT_BASED(STATUS_LEVEL, "/rpc/rest/statusLevelService/pointStatusLevels",
                    "POST", "createStatusLevel", null), //
    STATUS_CREATE_STATUS_LEVEL_GROUP_BASED(STATUS_LEVEL, "/rpc/rest/statusLevelService/groupStatusLevels",
                    "POST", "createStatusLevel", null), //
    STATUS_DELETE_STATUS_LEVEL(STATUS_LEVEL, "/rpc/rest/statusLevelService/statusLevels/:statusLevelID",
                    "DELETE", null, null), //
    STATUS_GET_ALL_STATUS_LEVEL_SCENARIOS(STATUS_LEVEL, "/rpc/rest/statusLevelService/scenarios", "GET", null, null), //
    STATUS_GET_GROUP_STATUS_LEVEL(STATUS_LEVEL, "/rpc/rest/statusLevelService/groupStatusLevels/:groupID",
                    "GET", null, null), //
    STATUS_GET_GROUP_STATUS_LEVELS(STATUS_LEVEL, "/rpc/rest/statusLevelService/groupStatusLevels", "GET", null, null), //
    STATUS_GET_LEADERS(STATUS_LEVEL, "/rpc/rest/statusLevelService/leaders", "GET", null, null), //
    STATUS_GET_LEADERS_BY_STARTINDEX_AND_NUMRESULTS(STATUS_LEVEL,
                    "/rpc/rest/statusLevelService/leaders", "GET", null, "startIndex:numResults"), //
    STATUS_GET_LEADERS_BY_COMMUNITY(STATUS_LEVEL,
                    "/rpc/rest/statusLevelService/leadersByCommunity", "GET", null, "communityID"), //
    STATUS_GET_LEADERS_BY_CONTAINER(
                    STATUS_LEVEL,
                    "/rpc/rest/statusLevelService/leadersByContainer/:containerObjectID:containerObjectType",
                    "GET", null, null), //
    STATUS_GET_LEADERS_BY_COMMUNITY_BY_STARTINDEX_AND_NUMRESULTS(
                    STATUS_LEVEL,
                    "/rpc/rest/statusLevelService/leadersByCommunity/:communityID:startIndex:numResults",
                    "GET", null, null), //
    STATUS_GET_LEADERS_BY_CONTAINER_ITERABLE(
                    STATUS_LEVEL,
                    "/rpc/rest/statusLevelService/leadersByContainer/:containerObjectID:containerObjectType:startIndex:numResults",
                    "GET", null, null), //
    STATUS_GET_POINT_LEVEL(STATUS_LEVEL, "/rpc/rest/statusLevelService/pointLevel", "GET", null, "userID"), //
    STATUS_GET_POINT_LEVEL_BY_COMMUNITY(STATUS_LEVEL,
                    "/rpc/rest/statusLevelService/pointLevel", "GET", null, "userID:communityID"), //
    STATUS_GET_POINT_LEVEL_BY_CONTAINER(
                    STATUS_LEVEL,
                    "/rpc/rest/statusLevelService/pointLevel/:userID:containerObjectID:containerObjectType",
                    "GET", null, null), //
    STATUS_GET_POINT_STATUS_LEVELS(STATUS_LEVEL, "/rpc/rest/statusLevelService/pointStatusLevels", "GET", null, null), //
    STATUS_GET_STATUS_LEVEL(STATUS_LEVEL, "/rpc/rest/statusLevelService/statusLevels", "GET", null, "statusLevelID"), //
    STATUS_GET_STATUS_LEVEL_BY_POINTS(STATUS_LEVEL,
                    "/rpc/rest/statusLevelService/statusLevelByPoints", "GET", null, "points"), //
    STATUS_GET_STATUS_LEVEL_SCENARIO_BY_CODE(STATUS_LEVEL, "/rpc/rest/statusLevelService/scenarios/:code",
                    "GET", null, null), //
    STATUS_GET_STATUS_LEVEL_SCENARIO_BY_CODE_ENCODED(STATUS_LEVEL,
                    "/rpc/rest/statusLevelService/scenarios", "GET", null, "code:encoded"), //
    STATUS_GET_USER_STATUS_LEVEL(STATUS_LEVEL, "/rpc/rest/statusLevelService/userStatusLevels", "GET", null, "userID"), //
    STATUS_IS_STATUS_LEVELS_ENABLED(STATUS_LEVEL, "/rpc/rest/statusLevelService/statusLevelsEnabled", "GET", null, null), //
    STATUS_SET_STATUS_LEVELS_ENABLED(STATUS_LEVEL, "/rpc/rest/statusLevelService/statusLevelsEnabled", "POST",
                    "setStatusLevelsEnabled", null), //
    STATUS_UPDATE_STATUS_LEVEL_SCENARIO(STATUS_LEVEL, "/rpc/rest/statusLevelService/scenarios", "PUT",
                    "updateStatusLevelScenario", null), //
    SYSTEM_DELETE_PROPERTY(SYSTEM_PROPERTIES, "/rpc/rest/systemPropertiesService/properties", "DELETE", null, "name"), //
    SYSTEM_GET_PROPERTIES(SYSTEM_PROPERTIES, "/rpc/rest/systemPropertiesService/properties", "GET", null, null), //
    SYSTEM_SAVE_PROPERTY(SYSTEM_PROPERTIES, "/rpc/rest/systemPropertiesService/properties", "POST",
                    "saveProperty", null), //
    TAG_ADD_TAG(TAG, "objectTags", "POST", "addTag", null), //
    TAG_CREATE_TAG(TAG, "tags", "POST", "createTag", null), //
    TAG_GET_TAG_BYID(TAG, "tagsByID", "GET", null, "tagID"), //
    TAG_GET_TAG_BYNAME(TAG, "tags", "GET", null, "tagname"), //
    TAG_GET_TAGS(TAG, "objectTags", "GET", null, "objectID:objectType"), //
    TAG_REMOVE_ALL_TAGS(TAG, "removeAllTags", "DELETE", null, "objectID:objectType"), //
    TAG_REMOVE_TAG(TAG, "objectTags", "DELETE", null, "tag:objectID:objectType"), //
    TASK_CREATE(TASK, "tasks", "POST", "create", null), //
    TASK_CREATE_PERSONAL_TASK(TASK, "personalTasks", "POST", "createPersonalTask", null), //
    TASK_DELETE(TASK, "tasks", "DELETE", null, "taskID"), //
    TASK_GET_TASK_COUNT(TASK, "taskCount", "GET", null, null), //
    TASK_GET_TASK_COUNTWITHFILTER(TASK, "taskCount", "POST", "getTaskCountWithFilter", null), //
    TASK_GET_TASKBY_ID(TASK, "tasks", "GET", null, "taskID"), //
    TASK_GET_TASKS(TASK, "tasks", "GET", null, null), //
    TASK_GET_TASKS_BY_PROJECT(TASK, "tasksByProject", "GET", null, "projectID"), //
    TASK_GET_TASKS_WITH_FILTER(TASK, "tasksWithFilter", "POST", "getTasksWithFilter", null), //
    TASK_GET_UNCOMPLETE_TASKS_BY_USER_ID(TASK, "tasksByUserID", "GET", null, "userID"), //
    TASK_UPDATE(TASK, "tasks", "PUT", "update", null), //
    USER_CREATE_USER(USER, "users/create", "POST", "createUser", null), //
    USER_CREATE_USER_WITH_USER(USER, "users", "POST", "createUserWithUser", null), //
    USER_DELETE_USER_PROPERTY(USER, "properties", "DELETE", null, "userID:name"), //
    USER_DISABLE_USER(USER, "disable", "PUT", "disableUser", null), //
    USER_ENABLE_USER(USER, "enable", "PUT", "enableUser", null), //
    USER_GET_USER(USER, "usersByID", "GET", null, "userID"), //
    USER_GET_USER_BY_EMAIL_ADDRESS(USER, "usersByEmail", "GET", null, "emailAddress"), //
    USER_GET_USER_BY_USER_NAME(USER, "users", "GET", null, "username"), //
    USER_GET_USER_COUNT(USER, "users/count", "GET", null, null), //
    USER_GET_USER_NAMES(USER, "userNames", "GET", null, null), //
    USER_GET_USER_PROPERTIES(USER, "properties", "GET", null, "userID"), //
    USER_GET_USERS(USER, "users", "GET", null, null), //
    USER_GET_USERS_BOUNDED(USER, "usersBounded", "GET", null, "startIndex:numResults"), //
    USER_IS_READ_ONLY(USER, "isReadOnly", "GET", null, null), //
    USER_SET_PASSWORD(USER, "password", "PUT", "setPassword", null), //
    USER_SET_USER_PROPERTY(USER, "properties", "POST", "setUserProperty", null), //
    USER_UPDATE_USER(USER, "users", "PUT", "updateUser", null), //
    VIDEO_CREATE_VIDEO(VIDEO, "createVideo", "POST", "createVideo", null), //
    VIDEO_DELETE_VIDEO(VIDEO, "rpc/rest/videoService/deleteVideo", "DELETE", null, "videoID"), //
    VIDEO_GET_VIDEO(VIDEO, "rpc/rest/videoService/videoByID", "GET", null, "videoID"), //
    VIDEO_GET_VIDEOS_FOR_CONTAINER(VIDEO, "rpc/rest/videoService/videosForContainer", "POST",
                    "getVideosForContainerResponse", null), //
    VIDEO_UPDATE_VIDEO(VIDEO, "updateVideo", "PUT", "updateVideo", null), //
    WATCH_CREATE_COMMUNITY_WATCH(WATCH, "communityWatches", "POST", "createCommunityWatch", null), //
    WATCH_CREATE_THREAD_WATCH(WATCH, "threadWatches", "POST", "createThreadWatch", null), //
    WATCH_CREATE_USER_WATCH(WATCH, "userWatches", "POST", "createUserWatch", null), //
    WATCH_DELETE_WATCH(WATCH, "watches", "DELETE", null, "userID:objectID:objectType"), //
    WATCH_DELETE_WATCHES(WATCH, "users", "DELETE", null, "userID"), //
    WATCH_GET_COMMUNITY_WATCH(WATCH, "communityWatches", "GET", null, "userID:communityID"), //
    WATCH_GET_COMMUNITY_WATCH_COUNT(WATCH, "communityWatches/count", "GET", null, "userID:communityID"), //
    WATCH_GET_COMMUNITY_WATCHES(WATCH, "allCommunityWatches", "GET", null, "userID:communityID"), //
    WATCH_GET_DELETE_DAYS(WATCH, "deleteDays", "GET", null, null), //
    WATCH_GET_THREAD_WATCH(WATCH, "threadWatches", "GET", null, "userID:threadID"), //
    WATCH_GET_TOTAL_WATCH_COUNT(WATCH, "watches/count", "GET", null, "userID:objectType"), //
    WATCH_GET_USER_WATCH(WATCH, "userWatches", "GET", null, "userID:watchedUserID"), //
    WATCH_GET_WATCH_LIST(WATCH, "watches", "GET", null, "userID:objectType"), //
    WATCH_GET_WATCH_USERS(WATCH, "users", "GET", null, "objectType:objectID:watchType"), //
    WATCH_IS_COMMUNITY_WATCHED(WATCH, "isCommunityWatched", "GET", null, "userID:communityID"), //
    WATCH_IS_THREAD_WATCHED(WATCH, "isThreadWatched", "GET", null, "userID:threadID"), //
    WATCH_IS_USER_WATCHED(WATCH, "isUserWatched", "GET", null, "userID:watchedUserID"), //
    WATCH_SET_DELETE_DAYS(WATCH, "deleteDays", "POST", "setDeleteDays", null);

    /** The service of this operation. */
    private final EntityTypeName entityType;

    /** This operation uri. */
    private final String operationName;

    /** The http protocol for this operation. */
    private final String method;

    /** Custom root tag element name */
    private final String rootTagElementName;
    
    /**List of path parameters required separated by ':'*/
    private final String pathParams;
    
    /**
     * @param type the entity type to which this operation applies
     * @param operationName The operation name, as present in the uri
     * @param method The http method
     * @param rootTag The root tag for the payload xml
     */
    private CustomOp(final EntityTypeName type,
                     final String operationName,
                     final String method,
                     final String rootTag,
                     final String pathParams)
    {
        this.operationName = operationName;
        this.entityType = type;
        this.method = method;
        this.rootTagElementName = rootTag;
        this.pathParams = pathParams;
    }
    
    // /////////////

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
    
    /**
     * @return The path params for this operation separated by ':'.
     */
    public String getPathParams()
    {
        return this.pathParams;
    }
}
