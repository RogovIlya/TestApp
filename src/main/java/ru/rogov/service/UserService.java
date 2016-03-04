package ru.rogov.service;

import ru.rogov.entity.User;

public interface UserService
{
	User getUser(String login);
}
