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

import static javax.xml.stream.XMLStreamConstants.*;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Module;
import org.mule.api.annotations.Processor;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

import javax.ws.rs.core.MediaType;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.UnhandledException;
import org.apache.commons.lang.Validate;

/***/
@Module(name = "jive",
    namespace = "http://repository.mulesoft.org/releases/org/"
              + "mule/modules/mule-module-jive",
    schemaLocation = "http://repository.mulesoft.org/releases/org/"
                   + "mule/modules/mule-module-jive/1.0-SNAPSHOT/mule-jive.xsd")

public class JiveModule implements JiveFacade {
    /**The jersey webresource to access rest resources.*/
    private WebResource gateway;
    /**The username to access the jive instance.*/
    private String user;
    /**The password.*/
    private String pass;
    /**The userID.*/
    private Long userID;

    /**JiveConnector.
     * @param gatewayUri The base uri
     * @param username Username
     * @param password Password
     * */
    public JiveModule(final String gatewayUri,
                      final String username, final String password) {
        this.setUser(username);
        this.setPass(password);
        this.createGateway(gatewayUri, createClient());
        getUserIdByUsername();
    }

    /***/
    public JiveModule() {

    }

    /***/
    @Configurable
    private String myProperty;

    /**
     * @param myProperty myProperty
     * */
    public final void setMyProperty(final String myProperty) {
        this.myProperty = myProperty;
    }

    /***/
    @Processor
    public String myProcessor(final String content) {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */

        return content;
    }

    /**XML output factory to write xml.
     * */
    private final XMLOutputFactory xmlOutputFactory =
        XMLOutputFactory.newInstance();

    /**XML input factory to read xml.
     * */
    private final XMLInputFactory xmlInputFactory =
        XMLInputFactory.newInstance();

    /**Sets the userID requesting it by username.*/
    private void getUserIdByUsername() {
        final String response = this.gateway.path("/userService/users/"
            + this.getUser()).type(MediaType.APPLICATION_FORM_URLENCODED)
            .get(String.class);
        this.setUserID(Long.parseLong(
            StringUtils.substringBetween(response, "<ID>", "</ID>")));
    }

    /* Creates an entity.
     * @see org.mule.modules.jive.JiveFacade#create(
     * org.mule.modules.jive.JiveFacade.ServiceType, java.util.Map)
     */
    @Override
    public final Map<String, Object> create(final ServiceType type,
                                    final Map<String, Object> entity) {
        final Writer writer = new StringWriter();
        // validacion
        // directiva de conversion?
        map2xml(type, entity, writer);


        String response = this.gateway.path(type.getCreateServiceName())
            .type(MediaType.APPLICATION_FORM_URLENCODED)
            .post(String.class, writer.toString());
        // vamos a hacer el request
        // validar error
        return xml2map(new StringReader(writer.toString()));
    }

    /* Deletes an entity
     * @param type The service type, in this case indicating what entity to
     * delete
     * @param id The id of the entity to be deleted
     * @see org.mule.modules.jive.JiveFacade#delete(
     * org.mule.modules.jive.JiveFacade.ServiceType)
     */
    @Override
    public final Map<String, Object> delete(final ServiceType type,
        final String id) {
        final Writer writer = new StringWriter();
        // validacion
        // directiva de conversion?
        // vamos a hacer el request
        ClientResponse response = this.gateway.path(type.getDeleteServiceName()
            + "/" + id).delete(ClientResponse.class);
        // validar error
        return xml2map(new StringReader(writer.toString()));
    }
    
    /**Call the get count service.
     * @return The count as a {@link Long}
     * @param type The service type
     * */
    public final Long count(final ServiceType type) {
        // validacion
        // directiva de conversion?
        // vamos a hacer el request
        String response = this.gateway.path(type.getCountServiceName())
            .get(String.class);
        // validar error
        return Long.parseLong(StringUtils.substringBetween(
            response, "<return>", "</return>"));
    }

    /**Maps a {@link Map} to an XML and writes it to the writer given.
     * @param type The service type
     * @param entity The map containing the entity data
     * @param writer The writer in which we'll write the xml
     * */
    public final void map2xml(final ServiceType type,
                       final Map<String, Object> entity, final Writer writer) {
        try {
            final XMLStreamWriter w =
                    xmlOutputFactory.createXMLStreamWriter(writer);

            w.writeStartDocument();

            w.writeStartElement(type.getRootTagName());
            if (type.hasExtraTag()) {
                w.writeStartElement(type.getEntityName());
            }

            writeXML(w, entity);

            if (type.hasExtraTag()) {
                w.writeEndElement();
            }

            w.writeEndElement();

            w.writeEndDocument();
        } catch (XMLStreamException e) {
            throw new UnhandledException(e);
        }
    }
    
    /**Maps an xml from a {@link Reader} to a {@link Map}.
     * @param reader The {@link Reader} with the xml data
     * @return The map with the entity
     * */
    @SuppressWarnings("unchecked")
    public Map<String, Object> xml2map(final Reader reader) {
        final Map<String, Object> ret = new HashMap<String, Object>();
        final Stack<Map<String, Object>> maps =
            new Stack<Map<String, Object>>();
        Map<String, Object> current = ret;

        try {
            final XMLStreamReader r =
                xmlInputFactory.createXMLStreamReader(reader);
            StringBuilder lastText = new StringBuilder();
            String currentElement = null;
            while (r.hasNext()) {
                final int eventType = r.next();
                if (eventType == CHARACTERS || eventType == CDATA
                        || eventType == SPACE
                        || eventType == ENTITY_REFERENCE) {
                    lastText.append(r.getText());
                } else if (eventType == PROCESSING_INSTRUCTION
                        || eventType == COMMENT) {
                    // skip
                } else if (eventType == END_DOCUMENT) {
                    break;
                } else if (eventType == START_ELEMENT) {
                    if (currentElement != null) {
                        maps.push(current);
                        final Map<String, Object> map =
                            new HashMap<String, Object>();
                        current.put(currentElement, map);
                        current = map;
                    }
                    currentElement = r.getLocalName();
                } else if (eventType == END_ELEMENT) {
                    if (currentElement == null) {
                        current = maps.pop();
                    } else {
                        current.put(currentElement, lastText.toString().trim());
                        currentElement = null;
                        lastText = new StringBuilder();
                    }
                } else {
                    throw new XMLStreamException("Unexpected event type "
                        + eventType);
                }
            }

            final Map<String, Object> returnXMLElement = (Map<String, Object>)
            ret.get(ret.keySet().iterator().next());

            return (Map<String, Object>) returnXMLElement.get("return");
            
        } catch (XMLStreamException e) {
            throw new UnhandledException(e);
        }
    }


    ///////////////////////////Private methods//////////////////////////////////

    

    /**Writes the xml of the internal data.
     * @param w The writer in which it'll write the xml
     * @param model The entity
     * @throws XMLStreamException When fails
     * */
    @SuppressWarnings("unchecked")
    private void writeXML(final XMLStreamWriter w,
                   final Map<String, Object> model) throws XMLStreamException {
        final Set<Entry<String, Object>> entries = model.entrySet();
        for (final Entry<String, Object> entry : entries) {
                w.writeStartElement(entry.getKey());
                if (!HashMap.class.isInstance(entry.getValue())) {
                    w.writeCharacters(entry.getValue().toString());
                } else {
                    writeXML(w, (HashMap<String, Object>) entry.getValue());
                }
                w.writeEndElement();
        }
    }

    /**Creates the client.
     * @return The jersey client
     * */
    private Client createClient() {
        final ClientConfig config = new DefaultClientConfig();
        return Client.create(config);
    }

    /**Creates the webresource.
     * @param gatewayUri The resource uri
     * @param client The jersey client
     * */
    private void createGateway(final String gatewayUri, final Client client) {
        Validate.notNull(client, "Client cannot be empty");
        Validate.notEmpty(gatewayUri, "Gateway cannot be empty");
        client.addFilter(new HTTPBasicAuthFilter(this.getUser(), this.getPass()));
        this.gateway = client.resource(gatewayUri);
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user)
    {
        this.user = user;
    }

    /**
     * @return the user
     */
    public String getUser()
    {
        return user;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass)
    {
        this.pass = pass;
    }

    /**
     * @return the pass
     */
    public String getPass()
    {
        return pass;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(Long userID)
    {
        this.userID = userID;
    }

    /**
     * @return the userID
     */
    public Long getUserID()
    {
        return userID;
    }

}
