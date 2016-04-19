package ru.rogov.service;


import java.util.List;
import ru.rogov.entity.User;

public interface UserService
{
	User getUser(String login);
	User getUser(Long id);
	List<User> getUserAll();
	User save (User user);
	User update (User user) throws Exception;
	User delete(User user);

}
