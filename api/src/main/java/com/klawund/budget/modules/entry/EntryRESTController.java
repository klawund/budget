package com.klawund.budget.modules.entry;

import com.klawund.budget.framework.rest.RESTController;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/entry")
@RequestScoped
public class EntryRESTController extends RESTController<Long, Entry>
{
	@Inject
	public EntryRESTController(EntryService service)
	{
		super(service);
	}
}
