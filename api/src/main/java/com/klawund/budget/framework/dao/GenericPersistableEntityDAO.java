package com.klawund.budget.framework.dao;

import com.klawund.budget.framework.entity.PersistableEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericPersistableEntityDAO<I extends Serializable, T extends PersistableEntity<I>> implements PersistableEntityDAO<I, T>, Serializable
{
	@PersistenceContext
	protected transient EntityManager entityManager;

	public I save(T entity)
	{
		entityManager.persist(entity);
		return entity.id();
	}

	public T merge(T entity)
	{
		return entityManager.merge(entity);
	}

	public T findById(I id)
	{
		return entityManager.find(getEntityClass(), id);
	}

	public T findProxyById(I id)
	{
		return entityManager.getReference(getEntityClass(), id);
	}

	public List<T> findAll()
	{
		return entityManager.createQuery("SELECT * FROM " + getEntityClass().getSimpleName() + " _vo")
			.getResultList();
	}

	public void remove(T entity)
	{
		entityManager.remove(entity);
	}
}
