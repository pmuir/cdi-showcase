package org.jboss.cdi.showcase.payments;

public class ChequePaymentStrategy implements PaymentStrategy {

	@Override
	public PaymentStrategyType getPaymentStrategyType() {
		return PaymentStrategyType.CHEQUE;
	}

}
