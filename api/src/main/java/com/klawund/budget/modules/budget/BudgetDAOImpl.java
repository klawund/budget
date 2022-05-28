package com.klawund.budget.modules.budget;

import com.klawund.budget.framework.dao.GenericPersistableEntityDAO;
import com.klawund.budget.framework.transactional.Transactional;
import java.time.LocalDate;
import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RequestScoped
public class BudgetDAOImpl extends GenericPersistableEntityDAO<Long, Budget> implements BudgetDAO
{
	@Override
	@Transactional
	public Budget findBudgetByEntryDueDate(LocalDate entryDueDate)
	{
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Budget> criteriaQuery = criteriaBuilder.createQuery(Budget.class);
		Root<Budget> rootBudget = criteriaQuery.from(Budget.class);

		Predicate[] conditions = new Predicate[2];
		conditions[0] = criteriaBuilder.greaterThanOrEqualTo(rootBudget.get("startDate"), entryDueDate);
		conditions[1] = criteriaBuilder.lessThanOrEqualTo(rootBudget.get("dueDate"), entryDueDate);

		criteriaQuery.select(rootBudget).where(conditions);
		TypedQuery<Budget> typedQuery = entityManager.createQuery(criteriaQuery);
		return typedQuery.getSingleResult();
	}
}
