package com.klawund.budget.modules.budget;

import com.klawund.budget.framework.rest.RESTController;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/budget")
@RequestScoped
public class BudgetRESTController extends RESTController<Long, Budget>
{
	@Inject
	public BudgetRESTController(BudgetService service)
	{
		super(service);
	}
}
