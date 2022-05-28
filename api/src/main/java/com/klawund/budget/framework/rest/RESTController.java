package com.klawund.budget.framework.rest;

import com.klawund.budget.framework.entity.PersistableEntity;
import com.klawund.budget.framework.service.PersistableEntityService;
import com.klawund.budget.framework.service.ServiceException;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
public abstract class RESTController<I extends Long, T extends PersistableEntity<I>>
{
	private PersistableEntityService<I, T> service;

	protected RESTController()
	{
	}

	protected RESTController(PersistableEntityService<I, T> service)
	{
		this.service = service;
	}

	@POST
	@Path("/")
	public Response save(T entity)
	{
		try
		{
			I id = service.save(entity);
			return Response.status(Response.Status.OK).entity(id).build();
		}
		catch (ServiceException e)
		{
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") I id)
	{
		T entity;
		try
		{
			entity = service.findById(id);
			return Response.status(Response.Status.OK).entity(entity).build();
		}
		catch (ServiceException e)
		{
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/")
	public Response findAll()
	{
		List<T> entities;
		try
		{
			entities = service.findAll();
			return Response.status(Response.Status.OK).entity(entities).build();
		}
		catch (ServiceException e)
		{
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@DELETE
	@Path("/{id}")
	public Response remove(@PathParam("id") I id)
	{
		try
		{
			service.remove(id);
			return Response.status(Response.Status.OK).build();
		}
		catch (ServiceException e)
		{
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@PUT
	@Path("/")
	public Response merge(T entity)
	{
		try
		{
			entity = service.merge(entity);
			return Response.status(Response.Status.OK).entity(entity).build();
		}
		catch (ServiceException e)
		{
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
}
