package org.jboss.cdi.showcase.cart;

public class Item {
	
	private String name;
	
	public Item(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
