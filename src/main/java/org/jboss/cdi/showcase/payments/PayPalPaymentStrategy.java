package org.jboss.cdi.showcase.payments;

public class PayPalPaymentStrategy implements PaymentStrategy {

	@Override
	public PaymentStrategyType getPaymentStrategyType() {
		return PaymentStrategyType.PAYPAL;
	}

}
