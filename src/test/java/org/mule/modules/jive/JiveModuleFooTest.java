/**
 * Mule Development Kit
 * Copyright 2010-2011 (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * This file was automatically generated by the Mule Development Kit
 */
package org.mule.modules.jive;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**JiveConnector Test.
 * @author Pablo Diez
 * @since Jul 20, 2011
 */
public class JiveModuleFooTest {
    /**The gateway uri.*/
    private final String gatewayUri =
        "https://app-sandbox.jivesoftware.com/rpc/rest";
    /**Facade instance.*/
    private static JiveFacade facade;

    /**Instantiates the JiveModule with the test properties.*/
    @Before
    public final void init() {
		facade = new JerseyJiveFacade();
		facade.setGatewayUri(gatewayUri);
		facade.setUsername(System.getenv("SandboxUser"));
		facade.setPassword(System.getenv("SandboxPass"));
		facade.init();
    }
    
    @Test
    /**Test the execution of an {@link Operation} with a {@link CustomOp}.*/
    public void executeOperationWithCustomOp() {
    	final Map<String, Object> entity = new HashMap<String, Object>();
    	entity.put("blogPost", 123);
    	entity.put("name", "Great Blog");
    	entity.put("contentTypes", "Great Blog Display Name!");
    	List<String> sources = new ArrayList<String>();
    	sources.add("base64aa");
    	sources.add("base64ab");
    	sources.add("base64ac");
    	entity.put("source", sources);
    	facade.execute(Operation.BLOG_ADD_ATTACHMENT_TO_BLOG_POST, entity);
    }
    
    @Test
    public void executeOperationWithBaseUri() {
    	final Map<String, Object> entity = new HashMap<String, Object>();
    	entity.put("userID", facade.getUserID());
    	entity.put("blogName", "Great Blog");
    	entity.put("displayName", "Great Blog Display Name!");
    	facade.execute(Operation.BLOG_CREATE_BLOG, entity);
    }
    
    @Test
    public void executeRegularOperation() {
    	final Map<String, Object> entity = new HashMap<String, Object>();
    	entity.put("userID", facade.getUserID());
    	entity.put("blogID", "Great Blog");
    	entity.put("subject", "Great Blog Display Name!");
    	entity.put("body", "The blog post for testing purpuses...");
    	facade.execute(Operation.BLOG_CREATE_BLOG_POST, entity);
    }

//    /**Register a new user sending only the username, password and email.
//     * */
//    @Ignore
//    @Test
//    public final void newUserWithMinimalData() {
//        Map<String, Object> user = new HashMap<String, Object>();
//        user.put("username", "userTestZauberMule");
//        user.put("password", "pass4e511Mule");
//        user.put("email", "pablomatiasdiez@gmail.com");
//        facade.create(ServiceType.USER_CREATE, user);
//    }

//    /**Register a new user with all the user data.
//     * */
//    @Ignore
//    @Test
//    public final void newUserWithUserData() {
//        final Long magicNumber = 23L;
//        Map<String, Object> user = new HashMap<String, Object>();
//        user.put("creationDate", Calendar.getInstance());
//        user.put("email", System.getenv("SandboxEmail"));
//        user.put("emailVisible", true);
//        user.put("enabled", true);
//        user.put("firstName", "Paul");
//        user.put("ID", magicNumber);
//        user.put("lastName", "Federer");
//        user.put("modificationDate", Calendar.getInstance());
//        user.put("name", "name");
//        user.put("nameVisible", true);
//        user.put("password", System.getenv("SandboxPass"));
//        user.put("username", System.getenv("SandboxUser"));
//        facade.create(ServiceType.USER_CREATE_USER_WITH_USER, user);
//    }

    /**Test the creation of entities.
     * Creates a new blog, make a get request to the new blog to verify the creation.
     * Deletes the blog and verifies the deletion.
     * */
    @Test
    public final void operationFlowTest() {
        final Map<String, Object> blog = new HashMap<String, Object>();
        final Map<String, Object> createResponse;
        final Map<String, Object> getResponse;
        final Map<String, Object> deleteResponse;
        blog.put("userID", facade.getUserID());
        blog.put("blogName", "fooBlog");
        blog.put("displayName", "fooDisplayBlogName");
        
        //Creates the blog
        createResponse = facade.create(EntityType.BLOG, blog);
        assertEquals("fooDisplayBlogName", createResponse.get("displayName"));
        
        //Get the blog just created
        getResponse = facade.execute(CustomOp.BLOG_GET_BLOG_BY_ID,
            createResponse.get("ID").toString());
        assertEquals(createResponse, getResponse);
        
        //Deletes the blog just created and verifies
        //that the server doesn't return an error
        deleteResponse = facade.delete(EntityType.BLOG,
            createResponse.get("ID").toString());
        assertEquals("deleteBlogResponse", deleteResponse.get("response"));
    }
    
    /**Attemps to create a blog already created and handles the error.*/
    @Test
    public final void errorHandlingTest() {
        final Map<String, Object> blog = new HashMap<String, Object>();
        blog.put("userID", facade.getUserID());
        blog.put("blogName", "fooBlog");
        blog.put("displayName", "fooDisplayBlogName");
        
        //Creates the blog
        facade.create(EntityType.BLOG, blog);
        
        //Attemps to create the same blog should throw an error
        facade.create(EntityType.BLOG, blog);
    }

    /**Test the get count.*/
    @Ignore
    @Test
    public final void getCount() {
        facade.count(EntityType.BLOG);
    }

    /**Test the delete service.
     * */
    @Ignore
    @Test
    public final void testDeleteSingular() {
        facade.delete(EntityType.ADDRESSBOOK, "123");
    }

    /**Test the delete service.
     * */
    @Ignore
    @Test
    public final void testDeletePlural() {
        facade.delete(EntityType.ATTACHMENT, "123");
    }

}