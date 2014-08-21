package org.jboss.cdi.showcase.cart;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

@SessionScoped
public class UserManager implements Serializable {

	private User currentUser = new User("Pete");
	
	@Produces
	public User getCurrentUser() {
		return currentUser;
	}
	
}
