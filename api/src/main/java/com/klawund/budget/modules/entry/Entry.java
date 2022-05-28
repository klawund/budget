package com.klawund.budget.modules.entry;

import com.klawund.budget.framework.entity.GenericPersistableEntity;
import com.klawund.budget.framework.entity.PersistableEntity;
import com.klawund.budget.modules.budget.Budget;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Entry extends GenericPersistableEntity<Long> implements PersistableEntity<Long>
{
	private String title;
	private BigDecimal amount;
	private LocalDate dueDate;
	private EntryStatus status;

	@ManyToOne
	private Budget budget;

	public Entry()
	{
	}

	public Entry(String title, BigDecimal amount, LocalDate dueDate, EntryStatus status, Budget budget)
	{
		this.title = title;
		this.amount = amount;
		this.dueDate = dueDate;
		this.status = status;
		this.budget = budget;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public BigDecimal getAmount()
	{
		return amount;
	}

	public void setAmount(BigDecimal amount)
	{
		this.amount = amount;
	}

	public LocalDate getDueDate()
	{
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate)
	{
		this.dueDate = dueDate;
	}

	public EntryStatus getStatus()
	{
		return status;
	}

	public void setStatus(EntryStatus status)
	{
		this.status = status;
	}

	public Budget getBudget()
	{
		return budget;
	}

	public void setBudget(Budget budget)
	{
		this.budget = budget;
	}
}
