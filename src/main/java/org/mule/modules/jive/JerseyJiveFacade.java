package org.mule.modules.jive;

import static javax.xml.stream.XMLStreamConstants.CDATA;
import static javax.xml.stream.XMLStreamConstants.CHARACTERS;
import static javax.xml.stream.XMLStreamConstants.COMMENT;
import static javax.xml.stream.XMLStreamConstants.END_DOCUMENT;
import static javax.xml.stream.XMLStreamConstants.END_ELEMENT;
import static javax.xml.stream.XMLStreamConstants.ENTITY_REFERENCE;
import static javax.xml.stream.XMLStreamConstants.PROCESSING_INSTRUCTION;
import static javax.xml.stream.XMLStreamConstants.SPACE;
import static javax.xml.stream.XMLStreamConstants.START_ELEMENT;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Map.Entry;

import javax.ws.rs.core.MediaType;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.UnhandledException;
import org.apache.commons.lang.Validate;
import org.mule.api.annotations.Configurable;
import org.mule.modules.jive.utils.ServiceUriFactory;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class JerseyJiveFacade implements JiveFacade {
	
	   /**The jersey webresource to access rest resources.*/
    private WebResource gateway;
    /**The userID.*/
    private Long userID;
    private String username;
    /**The password.*/
    private String password;

	/**XML output factory to write xml.
     * */
    private final XMLOutputFactory xmlOutputFactory =
        XMLOutputFactory.newInstance();

    /**XML input factory to read xml.
     * */
    private final XMLInputFactory xmlInputFactory =
        XMLInputFactory.newInstance();
	private String gatewayUri;

    /**Sets the userID requesting it by username.*/
    private void setUserIdByUsername() {
        final String response = this.gateway.path("/userService/users/"
            + this.getUser()).type(MediaType.APPLICATION_FORM_URLENCODED)
            .get(String.class);
        this.setUserID(Long.parseLong(
            StringUtils.substringBetween(response, "<ID>", "</ID>")));
    }
    
    @Override
    /**{@inheritDoc}*/
    public final Map<String, Object> execute(final CustomOp customType,
        final Map<String, Object> entity) {
        final Writer writer = new StringWriter();
        final String response;

        final Builder partialRequest = this.gateway.path(ServiceUriFactory.
                generateCustomUri(customType))
            .type(MediaType.APPLICATION_FORM_URLENCODED)
            .header("content-type", "text/xml");

        if (customType.getProtocol().equals("POST")) {
            map2xml(customType.getRootTagElementName(), entity, writer);
            response = partialRequest.post(String.class, writer.toString());
        } else if(customType.getProtocol().equals("GET")) {
            response = partialRequest.get(String.class);
        } else if (customType.getProtocol().equals("PUT")) {
        	response = partialRequest.put(String.class);
        } else { //It's a DELETE request
            response = partialRequest.delete(String.class);
        }
        return xml2map(new StringReader(response));
    }

    @Override
    /**{@inheritDoc}*/
    public final Map<String, Object> execute(final CustomOp customType,
        final String id) {

        final String response;
        final Builder partialRequest = this.gateway.path(
            getCompleteUriForCustomOp(customType, id))
            .type(MediaType.APPLICATION_FORM_URLENCODED)
            .header("content-type", "text/xml");

        if(customType.getProtocol().equals("GET")) {
            response = partialRequest.get(String.class);
        } else { //It's a DELETE request
            response = partialRequest.delete(String.class);
        }
        return xml2map(new StringReader(response));
    }

    @Override
    /**{@inheritDoc}*/
    public final Map<String, Object> execute(final String uri,
        final String id) {

        throw new NotImplementedException();
    }
    
    public final Map<String, Object> execute(final Operation op,
    		final Map<String, Object> entity) {
    	final String response;
        final Builder partialRequest = this.gateway.path(op.getResourceUri())
            .type(MediaType.APPLICATION_FORM_URLENCODED)
            .header("content-type", "text/xml");
        final Writer writer = new StringWriter();
        map2xml(op.getRootTagElementName(), entity, writer);
        if (op.getProtocol().equals("POST")) {
        	response = partialRequest.post(String.class, writer.toString());
        } else if (op.getProtocol().equals("PUT")) {
        	response = partialRequest.put(String.class);
        } else {
        	response = "";
        }
        return xml2map(new StringReader(response));
    }
    
    public final Map<String, Object> execute(final Operation op,
    		final String id) {
    	final String response;
    	
    	final StringBuffer opUri = new StringBuffer(op.getResourceUri());
    	for(final String part : StringUtils.split(id, ':')) {
    		opUri.append("/" + part);
    	}

        final Builder partialRequest = this.gateway.path(opUri.toString())
            .type(MediaType.APPLICATION_FORM_URLENCODED)
            .header("content-type", "text/xml");

        if (op.getProtocol().equals("GET")) {
        	response = partialRequest.get(String.class);
        } else {
        	response = "";
        }
        return xml2map(new StringReader(response));
    }

    /**Generates the complete uri for the get or delete {@link CustomOp}.
     * @param customType The {@link CustomOp} that is being executed
     * @param id A {@link String} containing the path parameters to add
     * @return The resouce uri with the path parameters added
     */
    private String getCompleteUriForCustomOp(final CustomOp customType,
                                             final String id) {
        final StringBuffer completeUri = new StringBuffer();
        final String[] pathParams = StringUtils.split(id, ':');

        completeUri.append(ServiceUriFactory
            .generateCustomUri(customType));
        for(int i = 0; i < pathParams.length; i++) {
            completeUri.append("/" + pathParams[i]);
        }
        return completeUri.toString();
    }

    /**Generates the complete uri for the get or delete service.
     * @param type The {@link EntityType} that is being executed
     * @param id A {@link String} containing the path parameters to add
     * @return The resouce uri with the path parameters added
     */
    private String getCompleteUri(final EntityType type, final String id) {
        final StringBuffer completeUri = new StringBuffer();
        final String[] pathParams = StringUtils.split(id, ':');

        completeUri.append(ServiceUriFactory.generateBaseUri(type));
        for(int i = 0; i < pathParams.length; i++) {
            completeUri.append("/" + pathParams[i]);
        }
        return completeUri.toString();
    }

    @Override
    /**{@inheritDoc}*/
    public final Map<String, Object> create(final EntityType type,
                                    final Map<String, Object> entity) {
        final Writer writer = new StringWriter();
        map2xml("create" + type.getXmlRootElementName(), entity, writer);

        String response = this.gateway.path(ServiceUriFactory.generateBaseUri(type))
            .type(MediaType.APPLICATION_FORM_URLENCODED)
            .header("content-type", "text/xml")
            .post(String.class, writer.toString());
        // validar error
        return xml2map(new StringReader(response));
    }

    @Override
    /**{@inheritDoc}*/
    public final Map<String, Object> delete(final EntityType type,
        final String id) {
        final String response = this.gateway.path(
            getCompleteUri(type, id))
            .delete(String.class);
        // validar error
        // is the response of a successful delete req always ""?
        return xml2map(new StringReader(response));
    }

    /**Call the get count service.
     * @return The count as a {@link Long}
     * @param type The service type
     * */
    public final Long count(final EntityType type) {
        // validacion
        // directiva de conversion?
        // vamos a hacer el request
        String response = this.gateway.path(ServiceUriFactory.generateBaseUri(type))
            .get(String.class);
        // validar error
        return Long.parseLong(StringUtils.substringBetween(
            response, "<return>", "</return>"));
    }

    @Override
    /**{@inheritDoc}*/
    public final void map2xml(final String xmlRootTag,
                       final Map<String, Object> entity, final Writer writer) {
        try {
            final XMLStreamWriter w =
                    xmlOutputFactory.createXMLStreamWriter(writer);

            w.writeStartDocument();

            w.writeStartElement(xmlRootTag);

            writeXML(w, entity);

            w.writeEndElement();

            w.writeEndDocument();
        } catch (XMLStreamException e) {
            throw new UnhandledException(e);
        }
    }

    /**Maps an xml from a {@link Reader} to a {@link Map}.
     * @param reader The {@link Reader} with the xml data
     * @return The map with the entity data
     * */
    @SuppressWarnings("unchecked")
    public final Map<String, Object> xml2map(final Reader reader) {
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

            final Object obj = ret.get(ret.keySet().iterator().next());
            if(obj instanceof String) {
                Map<String, Object> responseTag = new HashMap<String, Object>();
                responseTag.put("response",
                    ret.keySet().iterator().next().toString());
                return responseTag;
            } else {
                final Map<String, Object> returnXMLElement = (Map<String, Object>)
                ret.get(ret.keySet().iterator().next());

                return (Map<String, Object>) returnXMLElement.get("return");
            }
            
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
        	if (List.class.isInstance(entry.getValue())) {
        		for(final String elem : (List<String>)entry.getValue()) {
        			w.writeStartElement(entry.getKey());
        			w.writeCharacters(elem);
        			w.writeEndElement();
        		}
        	} else {
        		w.writeStartElement(entry.getKey());
        		if (!HashMap.class.isInstance(entry.getValue())) {
        			w.writeCharacters(entry.getValue().toString());
        		} else {
        			writeXML(w, (HashMap<String, Object>) entry.getValue());
        		}
        		w.writeEndElement();
        	}
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
        client.addFilter(new HTTPBasicAuthFilter(this.getUser(), this.getPassword()));
        this.gateway = client.resource(gatewayUri);
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

    /**
     * @param user the user to set
     */
    public void setUser(String user)
    {
        this.username = user;
    }

    /**
     * @return the user
     */
    public String getUser()
    {
        return username;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass)
    {
        this.password = pass;
    }

    /**
     * @return the pass
     */
    public String getPassword()
    {
        return password;
    }
    
    @Override
    public void setGatewayUri(String gatewayUri) {
    	this.gatewayUri  = gatewayUri;
    }

	@Override
	public void init() {
		this.createGateway(gatewayUri, createClient());
        setUserIdByUsername();		
	}

	@Override
	public void setUsername(String user) {
		this.username = user;
	}

	@Override
	public void setPassword(String pass) {
		this.password = pass;
	}
}
