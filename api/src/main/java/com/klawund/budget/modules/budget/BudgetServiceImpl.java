package com.klawund.budget.modules.budget;

import com.klawund.budget.framework.service.GenericPersistableEntityService;
import java.time.LocalDate;
import java.util.HashSet;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class BudgetServiceImpl extends GenericPersistableEntityService<Long, Budget> implements BudgetService
{
	@Inject
	private BudgetDAO budgetDAO;

	@Inject
	public BudgetServiceImpl(BudgetDAO dao)
	{
		super(dao);
	}

	@Override
	public Budget getBudgetByEntryDueDate(LocalDate entryDueDate)
	{
		Budget budget = budgetDAO.findBudgetByEntryDueDate(entryDueDate);
		if (budget != null)
		{
			return budget;
		}
		return buildCurrentMonthBudget();
	}

	@Override
	public Budget buildCurrentMonthBudget()
	{
		LocalDate now = LocalDate.now();
		LocalDate onFirstDay = now.withDayOfMonth(1);
		LocalDate onLastDay = now.withDayOfMonth(now.getMonth().length(now.isLeapYear()));
		return new Budget(onFirstDay, onLastDay, new HashSet<>());
	}
}
