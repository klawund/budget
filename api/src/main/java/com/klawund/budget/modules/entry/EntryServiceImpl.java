package com.klawund.budget.modules.entry;

import com.klawund.budget.framework.service.GenericPersistableEntityService;
import com.klawund.budget.framework.service.ServiceException;
import com.klawund.budget.modules.budget.BudgetService;
import java.time.LocalDate;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class EntryServiceImpl extends GenericPersistableEntityService<Long, Entry> implements EntryService
{
	@Inject
	private BudgetService budgetService;

	@Inject
	public EntryServiceImpl(EntryDAO dao)
	{
		super(dao);
	}

	@Override
	public Long save(Entry entry) throws ServiceException
	{
		if (entry.getDueDate() == null)
		{
			entry.setDueDate(LocalDate.now());
		}
		entry.setBudget(budgetService.getBudgetByEntryDueDate(entry.getDueDate()));
		return super.save(entry);
	}
}
