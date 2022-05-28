package com.klawund.budget.modules.budget;

import com.klawund.budget.framework.dao.PersistableEntityDAO;
import java.time.LocalDate;

public interface BudgetDAO extends PersistableEntityDAO<Long, Budget>
{
	Budget findBudgetByEntryDueDate(LocalDate entryDueDate);
}
