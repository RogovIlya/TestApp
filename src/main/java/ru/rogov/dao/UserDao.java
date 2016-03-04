package ru.rogov.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.rogov.entity.User;

public interface UserDao
{
	static final Logger logger = LoggerFactory.getLogger(UserDao.class);
	
	User getUser(String login,String password);
	User getUser(String login);
}
