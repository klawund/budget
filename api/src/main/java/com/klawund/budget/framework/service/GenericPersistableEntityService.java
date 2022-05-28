package com.klawund.budget.framework.service;

import com.klawund.budget.framework.dao.PersistableEntityDAO;
import com.klawund.budget.framework.entity.PersistableEntity;
import java.io.Serializable;
import java.util.List;

public class GenericPersistableEntityService<I extends Serializable, T extends PersistableEntity<I>> implements PersistableEntityService<I, T>
{
	protected final PersistableEntityDAO<I, T> dao;

	protected GenericPersistableEntityService(PersistableEntityDAO<I, T> dao)
	{
		this.dao = dao;
	}

	public I save(T entity) throws ServiceException
	{
		I id;
		try
		{
			id = dao.save(entity);
		}
		catch (Exception e)
		{
			throw new ServiceException(e.getMessage());
		}
		return id;
	}

	public T merge(T entity) throws ServiceException
	{
		try
		{
			entity = dao.merge(entity);
		}
		catch (Exception e)
		{
			throw new ServiceException(e.getMessage());
		}
		return entity;
	}

	public T findById(I id) throws ServiceException
	{
		T entity;
		try
		{
			entity = dao.findById(id);
		}
		catch (Exception e)
		{
			throw new ServiceException(e.getMessage());
		}
		return entity;
	}

	public List<T> findAll() throws ServiceException
	{
		List<T> entities;
		try
		{
			entities = dao.findAll();
		}
		catch (Exception e)
		{
			throw new ServiceException(e.getMessage());
		}
		return entities;
	}

	public void remove(T entity) throws ServiceException
	{
		try
		{
			dao.remove(entity);
		}
		catch (Exception e)
		{
			throw new ServiceException(e.getMessage());
		}
	}
}
