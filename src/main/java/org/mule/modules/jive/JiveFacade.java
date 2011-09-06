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

import org.mule.modules.jive.api.EntityType;
import org.mule.modules.jive.api.Operation;
import org.mule.modules.jive.utils.ServiceUriFactory;

import java.util.Map;

/**Facade for the Jive connector.
 * @author Pablo Diez
 * @since Jul 20, 2011
 */
public interface JiveFacade 
{

    /**Creates an entity.
     * Sends a POST request for the given {@link EntityType} generating the xml
     * payload corresponding with the <code>entity</code> map.
     * @return The xml response parse in a {@link Map}.
     * @param type The service type used to determine the url for this resource.
     * @param entity The {@link Map} with the entity data to parse to an xml and send
     * in the request.
     * */
    Map<String, Object> create(
        final EntityType type, Map<String, Object> entity);

    /**Deletes an entity.
     * @return The xml response parse in a {@link Map}.
     * @param type The service type used to determine the url for this resource.
     * @param id The id to be added in the url as path parameter.
     * */
    Map<String, Object> delete(final EntityType type, String id);
    
    /***/
    Map<String, Object> count(final EntityType type);
    
    /**
     * @param entityType
     * @param id
     * @return
     */
    Map<String, Object> get(EntityType entityType, String id);
    
    /**
     * @param entityType
     * @param id
     * @return
     */
    Map<String, Object> getAll(EntityType entityType, String id);
    
    /**
     * @param entityType
     * @param id
     * @return
     */
    Map<String, Object> update(EntityType entityType, Map<String, Object> entity);
    
    /**Executes a POST {@link CustomOp}.
     * @return The xml response parse in a {@link Map}.
     * @param customType The service to execute, used to determine the resource url, 
     * the http protocol to use and, if needed, the root tag for the xml to be
     * send in the request.
     * @param entity The {@link Map} with the entity data to parse to an xml and send
     * in the request.
     * */
    Map<String, Object> execute(final CustomOp customType,
        Map<String, Object> entity);

    /**TODO - Should create a new enum with the protocol to use
     * and the name of the operation, the uri will be determined
     * by the name of the operation using
     * {@link ServiceUriFactory#generateCustomUri(String, EntityType)}.
     * This new enum will exist mainly to give the user a proper
     * operations list.*/
    Map<String, Object> execute(final String uri,
            final String id);
    
    Map<String, Object> execute(final Operation op,
            final Map<String, Object> entity);


    /***/
    void setUsername(String user);
    /***/
    void setPassword(String pass);
    /***/
    Long getUserID();
    
    void setGatewayUri(String gatewayUri);
    
    void init();


    
}
