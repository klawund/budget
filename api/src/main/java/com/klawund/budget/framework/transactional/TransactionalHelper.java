package com.klawund.budget.framework.transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.slf4j.Logger;

@ApplicationScoped
public class TransactionalHelper
{
	@Inject
	private Logger logger;

	@Transactional
	public void doWorkOnManagedTransaction(Runnable runnable)
	{
		try
		{
			runnable.run();
		}
		catch (Exception e)
		{
			logger.error(e.getMessage());
		}
	}
}
