package org.jboss.cdi.showcase.customers;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resources {
	
	@Produces
	@PersistenceContext
	EntityManager customerDatabasePersistenceContext;
	
}
