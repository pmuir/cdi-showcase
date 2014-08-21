package org.jboss.cdi.showcase.cart;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Transactional
@Interceptor
public class TransactionInterceptor implements Serializable {
	
	private static final Logger log = Logger.getLogger(TransactionInterceptor.class.getName());

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ctx) throws Exception {
		try {
			log.info("Starting Transaction");
			log.info("Calling Original method");
			Object ret = ctx.proceed();
			log.info("Ending Transaction");
			return ret;
		} catch (Exception e) {
			log.info("Rolling back Transaction");
			throw e;
		}
	}
	
}