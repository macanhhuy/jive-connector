/*
 * Copyright (c) 2011 Zauber S.A.  -- All rights reserved
 */
package org.mule.modules.jive;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.NotImplementedException;

import junit.framework.TestCase;

import org.mule.modules.jive.JiveFacade.ServiceType;

/**Test for the creation of entities..
 * @author Pablo Diez
 * @since Jul 20, 2011
 */
public class JiveModuleFooTest extends TestCase {
    /**Facade instance.*/
    private static final JiveFacade FACADE = new JiveModule();

    /**Test the creation of an entity with entities within.
     * Using the {@link JiveFacade#callService(ServiceType, Map)}
     * */
    public final void testCreateComplex() {
        final Map<String, Object> entity = newTestMap();
        entity.put("internal", newTestMap());
        entity.put("anotherKey", "anotherValue");
        final Map<String, Object> complexEntity = newTestMap();
        complexEntity.put("complex", newTestMap());
        entity.put("internalComplex", complexEntity);

        testCreate(entity);

    }

    /**Test the creation of a simple entity.
     * Using the {@link JiveFacade#callService(ServiceType, Map)}
     * */
    public final void testCreateSimple() {
        testCreate(newTestMap());
    }

    /**Test the delete service.
     * */
    public final void testDelete() {

        //throw new NotImplementedException();

    }

    /**Test the Avatar create service.
     * @param map The mapping of the Avatar entity
     * */
    private void testCreate(final Map<String, Object> map) {
        FACADE.callService(ServiceType.AVATAR_CREATE, map);
    }

    /**Creates a simple entity for testing purposes.
     * @return {@link Map} representing an Avatar entity
     * */
    private Map<String, Object> newTestMap() {
        final Map<String, Object> entity = new HashMap<String, Object>();
        final int magicNumber = 123;

        entity.put("ownerID", magicNumber);
        entity.put("name", "paul");
        entity.put("contentType", "image/jpeg");
        entity.put("data", "adfwd3s2");
        return entity;
    }
}
