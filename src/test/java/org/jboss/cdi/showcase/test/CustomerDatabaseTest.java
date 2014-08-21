/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.cdi.showcase.test;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import static org.junit.Assert.*;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.cdi.showcase.customers.Customer;
import org.jboss.cdi.showcase.customers.CustomerDatabase;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Arquillian.class)
@Transactional
public class CustomerDatabaseTest {
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
        		// Add all our beans
                .addPackage(CustomerDatabase.class.getPackage())
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml");
    }

    @Inject
    EntityManager em;

    @Test
    public void testCustomerManager() throws Exception {
        em.persist(new Customer("Pete"));
        List<Customer> customers = em.createQuery("select c from Customer c").getResultList();
        assertEquals(1, customers.size());
        assertEquals("Pete", customers.get(0).getName());
    }

}
