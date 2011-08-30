/*
 * $Id$
 * ----------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.jive.utils;

import org.mule.modules.jive.CustomOp;
import org.mule.modules.jive.EntityType;

import org.apache.commons.lang.StringUtils;

/**Service uri factory.*/
public final class ServiceUriFactory {

    /**Constructor.*/
    private ServiceUriFactory() {
        super();
    }

    /**Generates the entity uri.
     * Using the service name and the op name to generate the resource uri.
     * @return The uri for this operation
     * @param type The service
     * @param opName The name of the operation to be called
     * */
    public static String generateCustomUri(final EntityType type,
                                                 final String opName) {
        return type.getServiceUri() + "/" + getOpUri(opName);
    }

    /**Generates the entity uri.
     * Using the custom operation type to generate the resource uri.
     * This operation is used in the operations with a unique uri.
     * @return The uri for this operation
     * @param customType The operation*/
    public static String generateCustomUri(final CustomOp customType) {
        return customType.getServiceType().getServiceUri() + "/"
                                        + customType.getOpUri();
    }

    /**Generates the base uri for the service type given.
     * @return The service base uri. E.g. For the AVATAR service, the base
     * uri would be /avatarService/avatars
     * @param type The service
     * */
    public static String generateBaseUri(final EntityType type) {
        final StringBuilder uri = new StringBuilder(type.getServiceUri() + "/");
        if (type.getStrategy() == EntityType.PLURAL) {
            uri.append(pluralize(type.toString().toLowerCase()));
        } else if (type.getStrategy() == EntityType.SINGULAR) {
            uri.append(type.toString().toLowerCase());
        }
        return uri.toString();
    }

    /**Removes the 'get' or 'set' from the beginning.
     * @return The operation uri
     * @param opName The operation entire name. Eg: 'set_Active_Avatar'
     * */
    private static String getOpUri(final String opName) {
        final String[] opSplit = StringUtils.split(opName, "_");
        final StringBuilder res = new StringBuilder();
        for (int i = 1; i < opSplit.length; i++) {
            res.append(opSplit[i]);
        }
        return res.toString();
    }

    /**Pluralizes the service name.
     * @param str The {@link String} to pluralize
     * @return str in plural*/
    private static String pluralize(final String str) {
        if (str.endsWith("y")) {
            return StringUtils.substringBeforeLast(str, "y") + "ies";
        }
        return str + "s";
    }
}