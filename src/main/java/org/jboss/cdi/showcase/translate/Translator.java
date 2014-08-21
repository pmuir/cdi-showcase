package org.jboss.cdi.showcase.translate;

import javax.ejb.Local;

/**
 * Can translate a sentence in one language, to another
 *
 */
@Local
public interface Translator {
	public String translate(String sentence);
}
