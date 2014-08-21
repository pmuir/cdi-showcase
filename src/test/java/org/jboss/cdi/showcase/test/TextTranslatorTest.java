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

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.cdi.showcase.translate.SentenceParser;
import org.jboss.cdi.showcase.translate.TextTranslator;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TextTranslatorTest {
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
        		// Add all our beans
                .addPackage(SentenceParser.class.getPackage())
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    TextTranslator translator;

    @Test
    public void testTranslate() throws Exception {
        String input = "Excuse me, Could you tell me the way to the station?";
        assertEquals("My hovercraft is full of eels.", translator.translate(input));
    }
    
    @Test
    public void testTranslateMultiSentence() throws Exception {
        String input = "I'm lost. Could you tell me the way to the station?";
        assertEquals("My hovercraft is full of eels.My hovercraft is full of eels.", translator.translate(input));
    }

}
