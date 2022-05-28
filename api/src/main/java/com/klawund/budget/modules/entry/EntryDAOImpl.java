package com.klawund.budget.modules.entry;

import com.klawund.budget.framework.dao.GenericPersistableEntityDAO;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class EntryDAOImpl extends GenericPersistableEntityDAO<Long, Entry> implements EntryDAO
{
}
