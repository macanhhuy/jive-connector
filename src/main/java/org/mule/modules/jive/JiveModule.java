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
 * @author Mulesoft
 */

package org.mule.modules.jive;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Module;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.lifecycle.Start;
import org.mule.api.annotations.param.Optional;
import org.mule.modules.jive.api.EntityTypeName;
import org.mule.modules.jive.api.EntityTypes;
import org.mule.modules.jive.api.JiveGenericException;
import org.mule.modules.jive.api.JiveModuleAdaptor;

import java.util.Map;

/**
 * Provides Jive connectivity to Mule:
 * <ul>
 * <li>Allows CRUD operations on Jive objects</li>
 * </ul>
 * 
 * @author MuleSoft, Inc.
 */
@Module(name = "jive", schemaVersion = "1.0")
public class JiveModule
{
    /** The username to access the jive instance. */
    @Configurable
    private String username;
    /** The password. */
    @Configurable
    private String password;
    /**The base rest server url*/
    @Configurable
    private String gatewayUri;

    /**The jive facade*/
    @Optional
    @Configurable
    private JiveFacade facade;

    /**Initialise the facade*/
    @Start
    public void init() 
    {
        if (facade == null) 
        {
            this.facade = JiveModuleAdaptor.getFacadeProxy(newFacade());
        }
    }

    /**Creates a {@link JerseyJiveFacade} for and sets the password, username and gatewayUri.
     * @return The facade ready to make requests*/
    protected JiveFacade newFacade()
    {
        JiveFacade facade = new JerseyJiveFacade();
        facade.setPassword(password);
        facade.setUsername(username);
        facade.setGatewayUri(gatewayUri);
        return facade;
    }
    
    /**
     * Creates an entity of the given type. 
     *
     * If the entity already exists or cannot be created the system throws a {@link JiveGenericException}
     * with the correspondat message.
     * 
     * If the data pass in entity it's not the data expected the system will throw a {@link JiveGenericException}
     * with the correspondant message.
     * 
     * {@sample.xml ../../../doc/mule-module-jive.xml.sample jive:create}
     * 
     * @param type the type of entity to create
     * @param entity the entity attributes
     * @return The jive response as a {@link Map}. Generally it will return the entity just created with additional data added by jive.
     */
    @Processor
    public Map<String, Object> create(EntityTypeName type, Map<String, Object> entity) 
    {
        return facade.create(EntityTypes.fromName(type), entity);
    }
    
    /**
     * Updates an existent entity
     * 
     * If the entity you are trying to update doesn't exist, the system thorws a {@link JiveGenericException}
     * with an aclaratory message.
     * 
     * {@sample.xml ../../../doc/mule-module-jive.xml.sample jive:update}
     * 
     * @param type the type of entity to update
     * @param entity the attributes of the entity 
     */
    @Processor
    public void update(EntityTypeName type, Map<String, Object> entity)
    {
        facade.update(EntityTypes.fromName(type), entity);
    }
    
    /**
     * Deletes an existent entity 
     * 
     * If there is no entity with the given id the system will throw a {@link JiveGenericException}
     * with the message returned from the server.
     * 
     * If the number of arguments is wrong the system will throw a {@link JiveGenericException}
     * 
     * {@sample.xml ../../../doc/mule-module-jive.xml.sample jive:delete}
     * 
     * @param type the entity type
     * @param id the id of the entity to delete
     */
    @Processor
    public void delete(final EntityTypeName type, final String id) 
    {
        facade.delete(EntityTypes.fromName(type), id);
    }
    
    /**
     * Counts all the instances of the given entity type
     * 
     * {@sample.xml ../../../doc/mule-module-jive.xml.sample jive:count}
     * 
     * @param type the entity type to be counted
     * @return The number of instances of the given type
     */
    @Processor
    public Long count(final EntityTypeName type) 
    {
        return facade.count(EntityTypes.fromName(type));
    }

    /**
     * Executes a custom operation
     * 
     * {@sample.xml ../../../doc/mule-module-jive.xml.sample jive:execute}
     * 
     * If a wrong number of attributes is sent, or the operation requires an entity an none is sent,
     * the system will repond with a {@link JiveGenericException}.
     * 
     * @param operation The custom operation to be executed
     * @param entity The {@link Map} with the entity data to be send as payload
     * @param id The path parameters to be added to the operation uri
     * @return A {@link Map} with the server response
     */
    @Processor
    public Map<String, Object> execute(final CustomOp operation, 
        @Optional final Map<String, Object> entity, @Optional  final String id) 
    {
        return facade.execute(operation, entity, id);
    }

    /**
     * Retrieves the attributes for the entity of the given type and id.
     * 
     * {@sample.xml ../../../doc/mule-module-jive.xml.sample jive:get}
     * 
     * If the entity you are trying to get doesn't exist, the system will throw a
     * {@link JiveGenericException} with the correponging message.
     * 
     * @param type the entity type
     * @param id the entity id
     * @return the entity attributes, as a String-Object Map
     */
    @Processor
    public Map<String, Object> get(EntityTypeName type, 
        final String id) 
    {
        return facade.get(EntityTypes.fromName(type), id);
    }

    /**
     * Answers the id of the logged user
     * 
     * {@sample.xml ../../../doc/mule-module-jive.xml.sample jive:getUserId}
     * 
     * @return the user id
     */
    @Processor
    public Long getUserId()
    {
        return facade.getUserID();
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setGatewayUri(String gatewayUri)
    {
        this.gatewayUri = gatewayUri;
    }

    public void setFacade(JiveFacade facade)
    {
        this.facade = facade;
    }

    

}
