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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.cdi.showcase.cart.Checkout;
import org.jboss.cdi.showcase.cart.Item;
import org.jboss.cdi.showcase.cart.PaymentMethods;
import org.jboss.cdi.showcase.cart.ShoppingCart;
import org.jboss.cdi.showcase.documents.Document;
import org.jboss.cdi.showcase.documents.UpdatedLiteral;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class DocumentTest {
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class, "test.war")
				// Add all our beans
				.addPackage(Document.class.getPackage())
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Inject
	@Any
	Event<Document> documentEvent;

	@Test
	public void testDocumentObserver() throws Exception {
		Document d = new Document();
		documentEvent.fire(d);
		assertTrue(d.getObserved().isObserved());
		Document d1 = new Document();
		documentEvent.select(UpdatedLiteral.INSTANCE).fire(d1);
		assertTrue(d1.getObserved().isObserved());
		assertTrue(d1.getUpdated().isObserved());
	}

}