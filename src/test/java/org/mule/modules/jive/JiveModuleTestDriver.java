/**
 * Mule Jive Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

/**
 * This file was automatically generated by the Mule Development Kit
 */

package org.mule.modules.jive;

import static org.junit.Assert.*;
import static org.mule.modules.jive.api.EntityTypeName.*;

import org.mule.modules.jive.api.impl.StandardCreateOperation;

import com.sun.jersey.api.client.UniformInterfaceException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * JiveConnector Test.
 * 
 * @author Pablo Diez
 * @since Jul 20, 2011
 */
public class JiveModuleTestDriver
{
    /** The gateway uri. */
    private final String gatewayUri = "https://app-sandbox.jivesoftware.com/rpc/rest";
    /** Facade instance. */
    private JiveModule facade;

    /** Instantiates the JiveModule with the test properties. */
    @Before
    public final void init()
    {
        facade = new JiveModule();
        facade.setGatewayUri(gatewayUri);
        facade.setUsername(System.getenv("SandboxUser"));
        facade.setPassword(System.getenv("SandboxPass"));
        facade.init();
        
//        facade.execute(CustomOp.BLOG_GET_BLOGS_FOR_USER, null, facade.getUserID().toString());
    }
    
    @Test
    public void testGetUserIdIsNotNull() throws Exception
    {
        assertNotNull(facade.getUserId());
    }
    
    @Test
    /**Testing create method.
     * Creates an Avatar*/
    public void getExistingBlogIsNotNull()
    {
        String id = (String) facade.create(BLOG, newBlog()).get("ID");
        try
        {
            Map<String, Object> blog = facade.get(BLOG, id);
            assertNotNull(blog);
        }
        finally
        {
            facade.delete(BLOG, id);
        }
    }

    @SuppressWarnings("serial")
    private HashMap<String, Object> newAvatar()
    {
        return new HashMap<String, Object>()
        {
            {
                put("ownerID", facade.getUserId());
                put("name", "avatarTest10");
                put("contentType", "image/jpg");
                put("data", Arrays.asList("qwertyui", "12345678"));
            }
        };
    }

    @Test(expected = UniformInterfaceException.class)
    // TODO check
    public void getInexistentBlogFails() throws Exception
    {
        facade.get(BLOG, "foobar1234");
    }

    /**
     * Test the delete method. Deletes an Avatar
     */
    @Test(expected = UniformInterfaceException.class)
    public void deleteInexistentBlogFails()
    {
        facade.delete(BLOG, "foobar1234");
    }

    /**
     * Test the delete method. Deletes an Avatar
     */
    @Test
    public void deleteExistentSucceeds()
    {
        String id = (String) facade.create(BLOG, newBlog()).get("ID");
        facade.delete(BLOG, id);
    }
    
    /**Test the retrieving of the fault message generated by creating the same blog twice*/
    @Test(expected = RuntimeException.class)
    public void createExistentBlogFails()
    {
        final String blogID = facade.create(BLOG, newBlog()).get("ID").toString();
        try 
        {
            assertNotNull(blogID);
            assertFalse(blogID.isEmpty());
            facade.create(BLOG, newBlog());
        }
        finally
        {
            facade.delete(BLOG, blogID);
        }
    }
    
    /**Test the execution of a {@link StandardCreateOperation}.*/
    @Test
    public void createBlogReturnsNonNullObjectWithNonNullId() throws Exception
    {
        Map<String, Object> blog = facade.create(BLOG, newBlog());
        
        assertNotNull(blog);
        assertNotNull(blog.get("ID"));
        facade.delete(BLOG, (String) blog.get("ID"));
    }
    
    
    @Test
    public void createAvatarReturnsNonNullObjectWithNonNullId() throws Exception
    {
        Map<String, Object> blog = facade.create(AVATAR, newAvatar());
        
        try
        {
            assertNotNull(blog);
            assertNotNull(blog.get("ID"));
        }
        finally
        {
            facade.delete(AVATAR, (String) blog.get("ID"));
        }
    }
    

    @SuppressWarnings("serial")
    private LinkedHashMap<String, Object> newBlog()
    {
        return new LinkedHashMap<String, Object>()
        {
            {
                put("userID", facade.getUserId());
                put("blogName", "foob0as07");
                put("displayName", "foobzzb1ar1");
            }
        };
    }
    
    /**Test the execution of a {@link CustomOp} with the wrong quantity of arguments.*/
    @Test(expected = UniformInterfaceException.class)
    public void executeOperationWithBadArgumentsCountThrowsIllegalArgumentException()
    {
        facade.execute(CustomOp.COMMENT_GET_ALL, null, "434");
    }

    @Test
    /**Test the execution of an {@link Operation} with a {@link CustomOp}.*/
    public void executeOperationWithCustomOpAndIdSucceeds()
    {
        Map<String, Object> blog = facade.create(BLOG, newBlog());
        Map<String, Object> result = facade.execute(CustomOp.BLOG_DELETE, null, (String) blog.get("ID"));
        System.out.println(result);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
    
    @Test
    /**Test the execution of a {@link CustomOp}.*/
    public void executeCustomOpSucceeds()
    {
        Map<String, Object> users = facade.execute(CustomOp.USER_GET_USERS, null, null);
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

    @Test
    public final void getCountAnswersANonNullPostiveLong()
    {
        assertTrue(facade.count(BLOG) >= 0);
    }

}
