package com.klawund.budget.resources;

import com.klawund.budget.modules.budget.BudgetRESTController;
import com.klawund.budget.modules.entry.EntryRESTController;
import java.util.HashSet;
import java.util.Set;
import javax.interceptor.InvocationContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationPath("/api")
public class APIConfig extends Application
{
	@Override
	public Set<Class<?>> getClasses()
	{
		Set<Class<?>> classes = new HashSet<>();
		classes.add(EntryRESTController.class);
		classes.add(BudgetRESTController.class);

		return classes;
	}

	@Produces
	public Logger produceLogger(InvocationContext context)
	{
		return LoggerFactory.getLogger(context.getTarget().getClass());
	}
}