package com.klawund.budget.modules.budget;

import com.klawund.budget.framework.service.PersistableEntityService;
import java.time.LocalDate;

public interface BudgetService extends PersistableEntityService<Long, Budget>
{
	Budget getBudgetByEntryDueDate(LocalDate entryDueDate);

	Budget buildCurrentMonthBudget();
}
