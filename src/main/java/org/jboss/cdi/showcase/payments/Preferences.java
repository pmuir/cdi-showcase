package org.jboss.cdi.showcase.payments;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

@SuppressWarnings("serial")
@SessionScoped
public class Preferences implements Serializable {

	private PaymentStrategyType paymentStrategy;

	@Produces
	@Preferred
	public PaymentStrategy getPaymentStrategy(CreditCardPaymentStrategy ccps,
			ChequePaymentStrategy cps, PayPalPaymentStrategy ppps) {
		switch (paymentStrategy) {
		case CREDIT_CARD:
			return ccps;
		case CHEQUE:
			return cps;
		case PAYPAL:
			return ppps;
		default:
			return null;
		}
	}
	
	public PaymentStrategyType getPaymentStrategy() {
		return paymentStrategy;
	}

	public void setPaymentStrategy(PaymentStrategyType paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}
	
}
