/**
 * Mule Development Kit Copyright 2010-2011 (c) MuleSoft, Inc. All rights
 * reserved. http://www.mulesoft.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

/**
 * This file was automatically generated by the Mule Development Kit
 */

package org.mule.modules.jive;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Module;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.lifecycle.Start;
import org.mule.api.annotations.param.Optional;
import org.mule.modules.jive.api.EntityTypeName;
import org.mule.modules.jive.api.EntityTypes;
import org.mule.modules.jive.api.JiveModuleAdaptor;

import java.util.Map;

/***/
@Module(name = "jive", namespace = "http://repository.mulesoft.org/releases/org/"
                                   + "mule/modules/mule-module-jive", schemaLocation = "http://repository.mulesoft.org/releases/org/"
                                                                                       + "mule/modules/mule-module-jive/1.0-SNAPSHOT/mule-jive.xsd")
public class JiveModule
{
    /** The username to access the jive instance. */
    @Configurable
    private String username;
    /** The password. */
    @Configurable
    private String password;

    @Configurable
    private String gatewayUri;

    @Optional
    @Configurable
    private JiveFacade facade;

    @Start
    public void init() 
    {
        if (facade == null) 
        {
            this.facade = JiveModuleAdaptor.getFacadeProxy(newFacade());
        }
    }

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
     * Example: 
     * {@code 
     *    <jive:create service="BLOG">
     *       <jive:entity>
     *         <creationDate>#[variable:creationDate]</creationDate>
     *         <author>#[variable:author]</author>
     *       </jive:entity>
     *     </jive:create>}
     * TODO what if already exists?
     * TODO what if bad data passed?
     * 
     * @param type the type of entity to create
     * @param entity the entity attributes
     * @return TODO what?
     */
    @Processor
    public Map<String, Object> create(EntityTypeName type, Map<String, Object> entity) 
    {
        return facade.create(EntityTypes.fromName(type), entity);
    }
    
    /**
     * Updates an existent entity
     * 
     * TODO overrides all the original value with the given one or merges both?
     * TODO if not exists?
     * 
     * {@code     
     *      <jive:update type="BLOG">
     *        <jive:entity>
     *            <author>#[variable:author]</author>
     *        </jive:entity>
     *      </jive:update>}
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
     * TODO if no exists?
     * Example:
     * {@code <jive:delete type="BLOG" id="#[map-payload:blogId]" />}
     * 
     * @param type the entity type
     * @param id the id of the entity to delete
     * @return TODO WHAT? 
     */
    @Processor
    public Map<String, Object> delete(final EntityTypeName type, final String id) 
    {
        return facade.delete(EntityTypes.fromName(type), id);
    }
    
    /**
     * Counts all the instances of the given entity type
     * 
     * Example:
     * {@code <jive:count type="BLOG" />}
     * 
     * @param type
     * @return TODO WHAT?
     */
    @Processor
    public Long count(final EntityTypeName type) 
    {
        return facade.count(EntityTypes.fromName(type));
    }

    @Processor
    public Map<String, Object> execute(final CustomOp op, 
        final Map<String, Object> entity) 
    {
        return facade.execute(op, entity);
    }

    /**
     * Retrieves the attributes for the entity of the given type and id.
     * 
     * TODO if not exists?
     * {@code <jive:get type="AVATAR" id="#[map-payload:avatarId]"/>}
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
     * @return the user id
     */
    @Processor
    public Long getUserID()
    {
        return facade.getUserID();
    }
    
    @Processor
    public Map<String, Object> getAll(EntityTypeName type, String id)
    {
        return facade.getAll(EntityTypes.fromName(type), id);
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
