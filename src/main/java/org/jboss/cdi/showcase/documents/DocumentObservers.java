package org.jboss.cdi.showcase.documents;

import javax.enterprise.event.Observes;

public class DocumentObservers {

	public void onAnyDocumentEvent(@Observes Document document) {
		document.getObserved().ack();
	}

	public void afterDocumentUpdate(@Observes @Updated Document document, User user) { 
		document.getObserved().ack();
		document.getUpdated().ack();
	}

}
