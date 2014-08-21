package org.jboss.cdi.showcase.shop;

import javax.enterprise.inject.Typed;

@Typed(Shop.class)
public class ToyShop extends Business implements Shop<Toy> {
}