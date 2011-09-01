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

import static org.junit.Assert.assertEquals;

import org.mule.modules.jive.api.EntityType;
import org.mule.modules.jive.api.Operation;

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
public class JiveModuleFooTest 
{
    /**The gateway uri.*/
    private final String gatewayUri =
        "https://app-sandbox.jivesoftware.com/rpc/rest";
    /**Facade instance.*/
    private static JiveFacade facade;

    /**Instantiates the JiveModule with the test properties.*/
    @Before
    public final void init() 
    {
        facade = new JerseyJiveFacade();
        facade.setGatewayUri(gatewayUri);
        facade.setUsername(System.getenv("SandboxUser"));
        facade.setPassword(System.getenv("SandboxPass"));
        facade.init();
    }
    
    @Test
    /**Testing create method.
     * Creates an Avatar*/
    public void create()
    {
        Map<String, Object> avatar = new HashMap<String, Object>();
        avatar.put("ownerID", facade.getUserID());
        avatar.put("name", "avatarTest");
        avatar.put("contentType", "image/jpg");
        List<String> data = new ArrayList<String>();
        data.add("qwertyui");
        data.add("12345678");
        avatar.put("data", data);
        facade.create(EntityType.AVATAR, avatar);
    }
    
    @Test
    @Ignore
    /**Test the delete method.
     * Deletes an Avatar*/
    public void delete() 
    {
        final String avatarID = String.valueOf(123);
        facade.delete(EntityType.AVATAR, avatarID);
    }
    
    @Test
    @Ignore
    /**Test the create method.
     * Creates an addressbook*/
    public void createAddressbook() 
    {
        final Map<String, Object> fooData = new HashMap<String, Object>();
        facade.create(EntityType.ADDRESSBOOK, fooData);
    }
    
    @Test
    @Ignore
    /**Test the create method.
     * Creates an addressbook*/
    public void deleteAddressbook() 
    {
        final String id = "bla/foo";
        facade.delete(EntityType.ADDRESSBOOK, id);
    }
    
    @Test
    @Ignore
    /**Test the create method.
     * Creates an addressbook*/
    public void createBlog() 
    {
        final Map<String, Object> fooData = new HashMap<String, Object>();
        facade.create(EntityType.BLOG, fooData);
    }
    
    @Test
    @Ignore
    /**Test the create method.
     * Creates an addressbook*/
    public void deleteBlog() 
    {
        final String id = "bla/foo";
        facade.delete(EntityType.BLOG, id);
    }
    
    @Test
    @Ignore
    /**Test the execution of an {@link Operation} with a {@link CustomOp}.*/
    public void executeOperationWithCustomOp() 
    {
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
    @Ignore
    public void executeOperationWithBaseUri() 
    {
        final Map<String, Object> entity = new HashMap<String, Object>();
        entity.put("userID", facade.getUserID());
        entity.put("blogName", "Great Blog");
        entity.put("displayName", "Great Blog Display Name!");
        facade.execute(Operation.BLOG_CREATE_BLOG, entity);
    }
    
    @Test
    @Ignore
    public void executeRegularOperation() 
    {
        final Map<String, Object> entity = new HashMap<String, Object>();
        entity.put("userID", facade.getUserID());
        entity.put("blogID", "Great Blog");
        entity.put("subject", "Great Blog Display Name!");
        entity.put("body", "The blog post for testing purpuses...");
        facade.execute(Operation.BLOG_CREATE_BLOG_POST, entity);
    }

    /**Test the creation of entities.
     * Creates a new blog, make a get request to the new blog to verify the creation.
     * Deletes the blog and verifies the deletion.
     * */
    @Test
    @Ignore
    public final void operationFlowTest() 
    {
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
        getResponse = facade.get(EntityType.BLOG, 
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
    @Ignore
    public final void errorHandlingTest() 
    {
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
    public final void getCount() 
    {
        facade.count(EntityType.BLOG, "");
    }

    /**Test the delete service.
     * */
    @Ignore
    @Test
    public final void testDeleteSingular() 
    {
        facade.delete(EntityType.ADDRESSBOOK, "123");
    }

}