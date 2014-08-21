package org.jboss.cdi.showcase.payments;

public class CreditCardPaymentStrategy implements PaymentStrategy {

	@Override
	public PaymentStrategyType getPaymentStrategyType() {
		return PaymentStrategyType.CREDIT_CARD;
	}

}
