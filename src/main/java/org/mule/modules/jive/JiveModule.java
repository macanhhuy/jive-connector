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

import java.util.Map;

import javax.annotation.PostConstruct;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Module;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.param.Optional;
import org.mule.modules.jive.api.JiveModuleAdaptor;

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

    @PostConstruct
    public void init() {
        if (facade == null) {
            JiveFacade newFacade = new JerseyJiveFacade();
            facade.setPassword(password);
            facade.setUsername(username);
            facade.setGatewayUri(gatewayUri);
            facade.init();
            this.facade = JiveModuleAdaptor.getFacadeProxy(newFacade);
        }
        facade.init();
    }

    @Processor
    public Map<String, Object> execute(final Operation op, 
        @Optional final Map<String, Object> entity, @Optional final String id) {
        if (entity != null) {
            return facade.execute(op, entity);
        }
        return facade.execute(op, id);
    }

    @Processor
    public Map<String, Object> delete(final EntityType type, final String id) {
        return facade.delete(type, id);
    }

    @Processor
    public Long count(final EntityType type) {
        return facade.count(type);
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
