package com.klawund.budget.framework.service;

import com.klawund.budget.framework.entity.PersistableEntity;
import java.io.Serializable;
import java.util.List;

public interface PersistableEntityService<I extends Serializable, T extends PersistableEntity<I>>
{
	I save(T entity) throws ServiceException;

	T merge(T entity) throws ServiceException;

	List<T> findAll() throws ServiceException;

	T findById(I id) throws ServiceException;

	default void remove(I id) throws ServiceException
	{
		T entity = findById(id);
		remove(entity);
	}

	void remove(T entity) throws ServiceException;
}
