package com.klawund.budget.framework.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface PersistableEntity<I extends Serializable>
{
	I id();
	LocalDateTime createdAt();
	LocalDateTime updatedAt();
}
