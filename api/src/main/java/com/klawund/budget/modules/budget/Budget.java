package com.klawund.budget.modules.budget;

import com.klawund.budget.framework.entity.GenericPersistableEntity;
import com.klawund.budget.framework.entity.PersistableEntity;
import com.klawund.budget.modules.entry.Entry;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Budget extends GenericPersistableEntity<Long> implements PersistableEntity<Long>
{
	private LocalDate startDate;
	private LocalDate dueDate;

	@OneToMany
	private Set<Entry> entries = new HashSet<>();

	public Budget()
	{
	}

	public Budget(LocalDate startDate, LocalDate dueDate, Set<Entry> entries)
	{
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.entries = entries;
	}

	public LocalDate getStartDate()
	{
		return startDate;
	}

	public void setStartDate(LocalDate startDate)
	{
		this.startDate = startDate;
	}

	public LocalDate getDueDate()
	{
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate)
	{
		this.dueDate = dueDate;
	}

	public Set<Entry> getEntries()
	{
		return entries;
	}

	public void setEntries(Set<Entry> entries)
	{
		this.entries = entries;
	}
}
