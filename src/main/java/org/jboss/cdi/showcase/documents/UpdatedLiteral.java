package org.jboss.cdi.showcase.documents;

import javax.enterprise.util.AnnotationLiteral;

public class UpdatedLiteral extends AnnotationLiteral<Updated> implements Updated {

	public static final Updated INSTANCE = new UpdatedLiteral();
	
	private UpdatedLiteral() {}
	
}
