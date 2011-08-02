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

import static org.junit.Assert.assertEquals;

import org.mule.modules.jive.JiveFacade.ServiceType;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**Test for the mappings of the {@link Map} entities to and from XML.*/
public class MappingTest {
    /**The module instance we'll use to map.*/
    private static final JiveFacade FACADE = new JiveModule();

    /**Test the xml to and from mapping.
     * In a classic entity, with no exceptions in the rest uri or the xml
     * elements.*/
    @Test
    public final void testMappingSimple() {

        final String simpleEntityExpectedXMLFromMap =
            "<?xml version=\"1.0\" ?>"
            + "<createAvatar>"
                + "<ownerID>123</ownerID>"
                + "<name>foo</name>"
                + "<data>f123f123</data>"
                + "<contentType>image/jpeg</contentType>"
            + "</createAvatar>";

        //This is not the expected response, but is an example of a response
        //that if we parse it to a Map should generate the Map created in
        //newTestMapSimple().
        final String simpleEntityXMLResponseExample =
            "<createAvatarResponse>"
                + "<return>"
                    + "<ownerID>123</ownerID>"
                    + "<name>foo</name>"
                    + "<data>f123f123</data>"
                    + "<contentType>image/jpeg</contentType>"
                + "</return>"
            + "</createAvatarResponse>";

        final Writer writer = new StringWriter();

        FACADE.map2xml(ServiceType.AVATAR_CREATE, newTestMapSimple(), writer);
        assertEquals("The entity xml returned wasn't the one expected",
            simpleEntityExpectedXMLFromMap, writer.toString());

        Map<String, Object> res =
            FACADE.xml2map(new StringReader(simpleEntityXMLResponseExample));
        final String msg = "The map generated from the xml does not match"
            + "the original";
        assertEquals(msg, res.get("ownerID").toString(), "123");
        assertEquals(msg, res.get("name").toString(), "foo");
        assertEquals(msg, res.get("data").toString(), "f123f123");
        assertEquals(msg, res.get("contentType").toString(), "image/jpeg");
    }

    /**Test the xml to and from mapping.
     * For the {@link ServiceType}'s with the extraTag attribute in true.*/
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

        FACADE.map2xml(ServiceType.USER_CREATE_WITH_USER,
            newTestMapWithAdditionalTag(), writer);
        assertEquals("The entity xml returned wasn't the one expected",
            additionalTagEntityExpectedXMLFromMap, writer.toString());

        Map<String, Object> res =
            FACADE.xml2map(new StringReader(
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

    /**Test the xml to and from mapping.
     * In the entites that have a different root xml element than the usual.
     * The addressBook create instead of <addressBook> is <addUser>*/
    @Test
    public final void testMappingWithUniqueRootElement() {
        final String uniqueRootElementEntityExpectedXMLFromMap =
            "<?xml version=\"1.0\" ?>"
            + "<addUser>"
                + "<userID>123</userID>"
                + "<usernameToAdd>paul</usernameToAdd>"
            + "</addUser>";

        final String uniqueRootElementEntityXMLResponseExample =
            "<createAvatarResponse>"
                + "<return>"
                    + "<userID>123</userID>"
                    + "<usernameToAdd>paul</usernameToAdd>"
                + "</return>"
            + "</createAvatarResponse>";

        final Writer writer = new StringWriter();

        FACADE.map2xml(ServiceType.ADDRESSBOOK_CREATE_USER,
            newTestMapWithUniqueRootElement(), writer);
        assertEquals("The entity xml returned wasn't the one expected",
            uniqueRootElementEntityExpectedXMLFromMap, writer.toString());

        Map<String, Object> res =
            FACADE.xml2map(new StringReader(
                uniqueRootElementEntityXMLResponseExample));
        final String msg = "The map generated from the xml does not match"
            + "the original";
        assertEquals(msg, res.get("userID").toString(), "123");
        assertEquals(msg, res.get("usernameToAdd").toString(), "paul");
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

    /**Creates a new user in the adressbook.
     * To test the entities that don't use their name on their root xml element.
     * ADRESSBOOK_CREATE instead of having <createAdressbook> as it's root
     * element, it has <addUser>.
     * @return {@link Map} representing a User entity
     * */
    private Map<String, Object> newTestMapWithUniqueRootElement() {
        final Map<String, Object> entity = new HashMap<String, Object>();

        entity.put("userID", "123");
        entity.put("usernameToAdd", "paul");
        return entity;
    }

}


