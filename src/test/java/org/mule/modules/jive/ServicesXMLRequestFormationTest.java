/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.jive;

import static org.junit.Assert.assertTrue;

import org.mule.modules.jive.JiveFacade.ServiceType;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

/**Test the formation of the xml for the request of each post service.*/
public class ServicesXMLRequestFormationTest {
    /**The root tag name for each service that make a request.*/
    private final Map<ServiceType, String> xmlRoots =
        new HashMap<ServiceType, String>();

    /**Initialize the xml root tag for each service.*/
    @Before
    public final void init() {
        this.xmlRoots.put(ServiceType.ADDRESSBOOK_ADD_USER, "addUser");
        this.xmlRoots.put(ServiceType.ADDRESSBOOK_ADD_USERS, "addUsers");
        this.xmlRoots.put(ServiceType.ATTACHMENT_ADD_ALLOWED_TYPE,
            "addAllowedType");
        this.xmlRoots.put(ServiceType.ATTACHMENT_ADD_DISALLOWED_TYPE,
            "addDisallowedType");
        this.xmlRoots.put(ServiceType.ATTACHMENT_SET_ALLOW_ALL_BY_DEFAULT,
        "setAllowAllByDefault");
        this.xmlRoots.put(ServiceType.ATTACHMENT_SET_ATTACHMENTS_ENABLED,
        "setAttachmentsEnabled");
        this.xmlRoots.put(ServiceType.ATTACHMENT_SET_IMAGE_PREVIEW_ENABLED,
        "setImagePreviewEnabled");
        this.xmlRoots.put(ServiceType.ATTACHMENT_SET_IMAGE_PREVIEW_MAX_SIZE,
        "setImagePreviewMaxSize");
        this.xmlRoots.put(ServiceType.
            ATTACHMENT_SET_IMAGE_PREVIEW_RATIO_ENABLED,
            "setImagePreviewRatioEnabled");
        this.xmlRoots.put(ServiceType.ATTACHMENT_SET_MAX_ATTACHMENT_SIZE,
        "setMaxAttachmentSize");
        this.xmlRoots.put(ServiceType.
            ATTACHMENT_SET_MAX_ATTACHMENTS_PER_BLOG_POST,
            "setMaxAttachmentsPerBlogPost");
        this.xmlRoots.put(ServiceType.
            ATTACHMENT_SET_MAX_ATTACHMENTS_PER_DOCUMENT,
            "setMaxAttachmentsPerDocument");
        this.xmlRoots.put(ServiceType.
            ATTACHMENT_SET_MAX_ATTACHMENTS_PER_MESSAGE,
            "setMaxAttachmentsPerMessage");
        this.xmlRoots.put(ServiceType.AUDIT_AUDIT_EVENT,
        "auditEvent");
        this.xmlRoots.put(ServiceType.AVATAR_CREATE_AVATAR,
        "createAvatar");
        this.xmlRoots.put(ServiceType.AVATAR_SET_ACTIVE_AVATAR,
        "setActiveAvatar");
    }

    /**Creates the xml for an entity and verifies that the root xml tag is
     * correct.*/
    @Test
    public final void verifiedXML() {
        final JiveFacade jiveModule = new JiveModule();
        //We create an entity with foo attributes becouse it doesn't matter the
        //content in this test, we are testing the root tag.
        final int magicNumber = 1010;
        final Map<String, Object> fooEntity = new HashMap<String, Object>();
        fooEntity.put("fooElement", "fooValue");
        fooEntity.put("foouserID", magicNumber);

        for (ServiceType type : this.xmlRoots.keySet()) {
            final Writer writer = new StringWriter();
            jiveModule.map2xml(type, fooEntity, writer);
            assertTrue(StringUtils.startsWith(writer.toString(),
                "<?xml version=\"1.0\" ?><" + this.xmlRoots.get(type) + ">"));
        }
    }

}


