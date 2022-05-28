package com.klawund.budget.framework.dao;

import com.klawund.budget.framework.entity.PersistableEntity;
import com.klawund.budget.framework.transactional.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public interface PersistableEntityDAO<I extends Serializable, T extends PersistableEntity<I>>
{
	I save(T entity);

	T merge(T entity);

	List<T> findAll();

	T findById(I id);

	T findProxyById(I id);

	@Transactional
	default void remove(I id)
	{
		T entity = findProxyById(id);
		remove(entity);
	}

	void remove(T entity);

	default Class<T> getEntityClass()
	{
		return (Class<T>) ((ParameterizedType) this.getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0];
	}
}
