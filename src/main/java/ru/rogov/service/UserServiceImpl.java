package ru.rogov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.rogov.dao.UserDao;
import ru.rogov.entity.User;

@Repository("userService")
public class UserServiceImpl implements UserService
{
	@Autowired
	UserDao userDao;

	public User getUser(String login)
	{
		return userDao.getUser(login);
	}

}
