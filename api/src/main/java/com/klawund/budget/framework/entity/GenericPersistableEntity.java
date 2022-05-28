package com.klawund.budget.framework.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public abstract class GenericPersistableEntity<I extends Serializable>
{
	@Id
	private I id;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public I id()
	{
		return id;
	}

	public LocalDateTime createdAt()
	{
		return createdAt;
	}

	public LocalDateTime updatedAt()
	{
		return updatedAt;
	}

	@PrePersist
	private void prePersist()
	{
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}

	@PreUpdate
	private void preUpdate()
	{
		this.updatedAt = LocalDateTime.now();
	}
}
