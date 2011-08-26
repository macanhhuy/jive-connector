/*
 * $Id$
 * ---------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.jive.util;

import static org.junit.Assert.*;

import org.mule.modules.jive.CustomOp;
import org.mule.modules.jive.Service;
import org.mule.modules.jive.utils.ServiceUriFactory;

import org.junit.Test;

/**Test that the uri generated for each service is the correct one.*/
public class ServiceTypeUriTest {

    /**Test the {@link ServiceUriFactory} base uri generation.
     * The base uri is determined from the create entity uri*/
    @Test
    public final void testBaseUri() {
        assertEquals("/addressBookService/addressbooks", ServiceUriFactory.
            generateBaseUri(Service.ADDRESSBOOK));
        assertEquals("/auditService/audit", ServiceUriFactory.
            generateBaseUri(Service.AUDIT));
        assertEquals("/avatarService/avatars", ServiceUriFactory.
            generateBaseUri(Service.AVATAR));
        assertEquals("/blogService/blogs", ServiceUriFactory.
                generateBaseUri(Service.BLOG));
    }

    /**Test the {@link ServiceUriFactory} custom operation uri formation.*/
    @Test
    public final void testCustomOpUri() {
        //ADDRESSBOOK
        assertEquals("/addressBookService/addressbooks",
            ServiceUriFactory.generateCustomUri(
                CustomOp.ADDRESSBOOK_ADD_USER));

        assertEquals("/addressBookService/bulk",
            ServiceUriFactory.generateCustomUri(
                CustomOp.ADDRESSBOOK_ADD_USERS));

        assertEquals("/addressBookService/addressbooks",
            ServiceUriFactory.generateCustomUri(
                CustomOp.ADDRESSBOOK_REMOVE_USER));

        assertEquals("/addressBookService/bulk",
            ServiceUriFactory.generateCustomUri(
                CustomOp.ADDRESSBOOK_REMOVE_USERS));

        assertEquals("/addressBookService/addressbooks",
            ServiceUriFactory.generateCustomUri(
                CustomOp.ADDRESSBOOK_GET_ROSTER));

        //ATTACHMENT
        assertEquals("/attachmentService/allowedTypes",
            ServiceUriFactory.generateCustomUri(
                CustomOp.ATTACHMENT_ADD_ALLOWED_TYPE));

        assertEquals("/attachmentService/disallowedTypes",
            ServiceUriFactory.generateCustomUri(
                CustomOp.ATTACHMENT_ADD_DISALLOWED_TYPE));

        assertEquals("/attachmentService/allowedTypes",
            ServiceUriFactory.generateCustomUri(Service.ATTACHMENT,
                "get_allowed_Types"));

        assertEquals("/attachmentService/disallowedTypes",
            ServiceUriFactory.generateCustomUri(Service.ATTACHMENT,
                "get_disallowed_Types"));

        assertEquals("/attachmentService/imagePreviewMaxSize",
            ServiceUriFactory.generateCustomUri(Service.ATTACHMENT,
                "get_image_Preview_Max_Size"));

        assertEquals("/attachmentService/maxAttachmentSize",
            ServiceUriFactory.generateCustomUri(Service.ATTACHMENT,
                "get_max_Attachment_Size"));

        assertEquals("/attachmentService/maxAttachmentsPerBlogPost",
            ServiceUriFactory.generateCustomUri(Service.ATTACHMENT,
                "get_max_Attachments_Per_Blog_Post"));

        assertEquals("/attachmentService/maxAttachmentsPerBlogPost",
            ServiceUriFactory.generateCustomUri(Service.ATTACHMENT,
                "get_max_Attachments_Per_Blog_Post"));

        assertEquals("/attachmentService/maxAttachmentsPerMessage",
            ServiceUriFactory.generateCustomUri(Service.ATTACHMENT,
                "get_max_Attachments_Per_Message"));

        assertEquals("/attachmentService/allowAllByDefault",
            ServiceUriFactory.generateCustomUri(Service.ATTACHMENT,
                "is_allow_All_By_Default"));

        assertEquals("/attachmentService/attachmentsEnabled",
            ServiceUriFactory.generateCustomUri(Service.ATTACHMENT,
                "is_attachments_Enabled"));

        assertEquals("/attachmentService/imagePreviewEnabled",
            ServiceUriFactory.generateCustomUri(Service.ATTACHMENT,
                "is_image_Preview_Enabled"));

        assertEquals("/attachmentService/imagePreviewRatioEnabled",
            ServiceUriFactory.generateCustomUri(Service.ATTACHMENT,
                "is_image_Preview_Ratio_Enabled"));

        assertEquals("/attachmentService/allowedTypes",
            ServiceUriFactory.generateCustomUri(
                CustomOp.ATTACHMENT_IS_VALID_TYPE));

        assertEquals("/attachmentService/allowedTypes",
            ServiceUriFactory.generateCustomUri(
                CustomOp.ATTACHMENT_REMOVE_ALLOWED_TYPE));

        assertEquals("/attachmentService/disallowedTypes",
            ServiceUriFactory.generateCustomUri(
                CustomOp.ATTACHMENT_REMOVE_DISALLOWED_TYPE));

        assertEquals("/auditService/audit",
            ServiceUriFactory.generateCustomUri(
                CustomOp.AUDIT_GET_AUDIT_MESSAGES));
    }

}