/*
 * Copyright (c) 2011 Zauber S.A.  -- All rights reserved
 */
package org.mule.modules.jive;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * TODO: Description of the class, Comments in english by default  
 * 
 * 
 * @author Pablo Diez
 * @since Jul 20, 2011
 */
public interface JiveFacade 
{

    Map<String, Object> callService(ServiceType type, Map<String, Object> entity);
    Map<String, Object> callService(ServiceType type);

    /**Services enum.
     * */
    enum ServiceType {
        /**Avatar create reference.*/
        AVATAR_CREATE,
        /**Avatar delete reference.*/
        AVATAR_DELETE;

        /**@return the rootElement of the xml request
         * */
        public final String getXmlRootElementName() {
            String[] aux = StringUtils.split(this.toString(), '_');
            final StringBuffer rootElementName = new StringBuffer();
            rootElementName.append(StringUtils.lowerCase(aux[1]));
            rootElementName.append(StringUtils.capitalize(
                StringUtils.lowerCase(aux[0])));
            return rootElementName.toString();
        }
        
        
    }
}
