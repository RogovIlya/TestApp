package ru.rogov.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.rogov.entity.User;

public interface UserService
{
	static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	User getUser(String login,String password);
	User getUser(String login);
}
