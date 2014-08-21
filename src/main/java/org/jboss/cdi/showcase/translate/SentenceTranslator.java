package org.jboss.cdi.showcase.translate;

import javax.ejb.Stateless;

/**
 * A stateless session bean front-end for an external system that is able to
 * translate sentences from one language to another.
 * 
 */
@Stateless
public class SentenceTranslator implements Translator {

	public String translate(String sentence) {
		return "My hovercraft is full of eels.";
	}
}