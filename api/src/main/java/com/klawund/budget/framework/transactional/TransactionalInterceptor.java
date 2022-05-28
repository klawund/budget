package com.klawund.budget.framework.transactional;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Interceptor
public class TransactionalInterceptor
{
	@PersistenceContext
	private EntityManager entityManager;

	@AroundInvoke
	public Object transactionalCall(InvocationContext context) throws Exception
	{
		try
		{
			if (!entityManager.getTransaction().isActive())
			{
				entityManager.getTransaction().begin();
			}
			return context.proceed();
		}
		catch (Exception e)
		{
			entityManager.getTransaction().rollback();
			throw e;
		}
		finally
		{
			if (entityManager.getTransaction().isActive())
			{
				entityManager.getTransaction().commit();
			}
		}
	}
}
