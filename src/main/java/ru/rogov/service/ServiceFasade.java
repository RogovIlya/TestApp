package ru.rogov.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fasade")
public class ServiceFasade
{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	UserService userService;

	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	public UserService getUserService()
	{
		return userService;
	}
	
}