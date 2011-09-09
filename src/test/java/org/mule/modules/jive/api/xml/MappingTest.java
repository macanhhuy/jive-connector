/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.jive.api.xml;

import static org.junit.Assert.*;

import org.mule.api.registry.ServiceType;
import org.mule.modules.jive.CustomOp;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

/**Test for the mappings of the {@link Map} entities to and from XML.*/
public class MappingTest {
    /**The module instance we'll use to map.*/
    private final XmlMapper mapper = new XmlMapper();

    /**Test the xml to and from mapping.
     * In a classic entity, with no exceptions in the rest uri or the xml
     * elements.*/
    @Test
    public final void testMap2Xml() {
        final String simpleEntityExpectedXMLFromMap =
            "<?xml version=\"1.0\" ?>"
            + "<createAvatar>"
                + "<ownerID>123</ownerID>"
                + "<name>foo</name>"
                + "<data>f123f123</data>"
                + "<contentType>image/jpeg</contentType>"
            + "</createAvatar>";

        final Writer writer = new StringWriter();

        //The root tag sent to the map2xml method is generated from the service enum.
        mapper.map2xml("createAvatar",
            newTestMapSimple(), writer);
        assertEquals("The entity xml returned wasn't the one expected",
            simpleEntityExpectedXMLFromMap, writer.toString());
    }
    
    @Test
    public final void testXml2Map()
    {
        final String simpleEntityXMLResponseExample =
            "<createAvatarResponse>"
                + "<return>"
                    + "<ownerID>123</ownerID>"
                    + "<name>foo</name>"
                    + "<data>f123f123</data>"
                    + "<contentType>image/jpeg</contentType>"
                + "</return>"
            + "</createAvatarResponse>";

        Map<String, Object> res =
            mapper.xml2map(new StringReader(simpleEntityXMLResponseExample));
        final String msg = "The map generated from the xml does not match"
            + "the original";
        
        assertNotNull(res);
        assertEquals(msg, res.get("ownerID").toString(), "123");
        assertEquals(msg, res.get("name").toString(), "foo");
        assertEquals(msg, res.get("data").toString(), "f123f123");
        assertEquals(msg, res.get("contentType").toString(), "image/jpeg");
    }
    
    /**Test the mapping for the {@link CustomOp}s*/
    @Test
    public final void mapCustomOp() {
        final String customOpExpectedXMLFromMap =
            "<?xml version=\"1.0\" ?>"
            + "<addUser>"
                + "<userID>123</userID>"
                + "<usernameToAdd>fooNewUser</usernameToAdd>"
            + "</addUser>";
        final Map<String, Object> addressbookUser = new HashMap<String, Object>();
        final Writer writer = new StringWriter();
        addressbookUser.put("userID", 123L);
        addressbookUser.put("usernameToAdd", "fooNewUser");
        mapper.map2xml(CustomOp.ADDRESSBOOK_ADD_USER.getRootTagElementName(),
            addressbookUser, writer);
        assertEquals(customOpExpectedXMLFromMap, writer.toString());
    }

    /**Test the xml to and from mapping.
     * For the {@link ServiceType}'s with the extraTag attribute in true.*/
    @Ignore
    @Test
    public final void testMappingWithAdditionalTag() {

        final String additionalTagEntityExpectedXMLFromMap =
            "<?xml version=\"1.0\" ?>"
            + "<createUserWithUser>"
                + "<user>" //Additional user tag
                    + "<lastName>Federer</lastName>"
                    + "<enabled>true</enabled>"
                    + "<creationDate>2011-07-29T07:46:55.455-07:00"
                    + "</creationDate>"
                    + "<username>userTestZauberMule</username>"
                    + "<email>pzmule@gmail.com</email>"
                    + "<name>name</name>"
                    + "<emailVisible>true</emailVisible>"
                    + "<nameVisible>true</nameVisible>"
                    + "<ID>123</ID>"
                    + "<modificationDate>2011-07-29T07:46:55.455-07:00"
                    + "</modificationDate>"
                    + "<firstName>Paul</firstName>"
                    + "<password>pass4e511Mule</password>"
                + "</user>"
            + "</createUserWithUser>";

        final String additionalTagEntityXMLResponseExample =
            "<createUserWithUserResponse>"
                + "<return>"
                    + "<creationDate>2011-07-29T07:46:55.455-07:00"
                    + "</creationDate>"
                    + "<email>pzmule@gmail.com</email>"
                    + "<emailVisible>true</emailVisible>"
                    + "<enabled>true</enabled>"
                    + "<firstName>Paul</firstName>"
                    + "<ID>123</ID>"
                    + "<lastName>Federer</lastName>"
                    + "<modificationDate>2011-07-29T07:46:55.455-07:00"
                    + "</modificationDate>"
                    + "<name>name</name>"
                    + "<nameVisible>true</nameVisible>"
                    + "<password>pass4e511Mule</password>"
                    + "<username>userTestZauberMule</username>"
                + "</return>"
            + "</createUserWithUserResponse>";

        final Writer writer = new StringWriter();

        mapper.map2xml("mmmmm",
            newTestMapWithAdditionalTag(), writer);
        assertEquals("The entity xml returned wasn't the one expected",
            additionalTagEntityExpectedXMLFromMap, writer.toString());

        Map<String, Object> res =
            mapper.xml2map(new StringReader(
                additionalTagEntityXMLResponseExample));
        final String msg = "The map generated from the xml does not match"
            + "the original";
        assertEquals(msg, res.get("creationDate").toString(),
            "2011-07-29T07:46:55.455-07:00");
        assertEquals(msg, res.get("email").toString(), "pzmule@gmail.com");
        assertEquals(msg, res.get("emailVisible").toString(), "true");
        assertEquals(msg, res.get("enabled").toString(), "true");
        assertEquals(msg, res.get("firstName").toString(), "Paul");
        assertEquals(msg, res.get("ID").toString(), "123");
        assertEquals(msg, res.get("lastName").toString(), "Federer");
        assertEquals(msg, res.get("modificationDate").toString(),
            "2011-07-29T07:46:55.455-07:00");
        assertEquals(msg, res.get("name").toString(), "name");
        assertEquals(msg, res.get("nameVisible").toString(), "true");
        assertEquals(msg, res.get("password").toString(), "pass4e511Mule");
        assertEquals(msg, res.get("username").toString(), "userTestZauberMule");
    }

    /**Creates a simple test entity.
     * @return {@link Map} representing an Avatar entity
     * */
    private Map<String, Object> newTestMapSimple() {
        final Map<String, Object> entity = new HashMap<String, Object>();
        final int magicNumber = 123;

        entity.put("ownerID", magicNumber);
        entity.put("name", "foo");
        entity.put("contentType", "image/jpeg");
        entity.put("data", "f123f123");
        return entity;
    }

    /**Creates a user entity to test the additional tag condition.
     * @return {@link Map} representing a User entity
     * */
    private Map<String, Object> newTestMapWithAdditionalTag() {
        Map<String, Object> user = new HashMap<String, Object>();
        user.put("creationDate", "2011-07-29T07:46:55.455-07:00");
        user.put("email", "pzmule@gmail.com");
        user.put("emailVisible", "true");
        user.put("enabled", "true");
        user.put("firstName", "Paul");
        user.put("ID", "123");
        user.put("lastName", "Federer");
        user.put("modificationDate", "2011-07-29T07:46:55.455-07:00");
        user.put("name", "name");
        user.put("nameVisible", "true");
        user.put("password", "pass4e511Mule");
        user.put("username", "userTestZauberMule");
        return user;
    }

}


