package ru.rogov.service;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.rogov.entity.User;
import ru.rogov.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService
{
	
	@Resource
	UserRepository userRepository;
	
	@Override
	@Transactional
	public User getUser(String login)
	{
		return userRepository.getUser(login);
	}

	@Override
	@Transactional
	public User getUser(Long id)
	{
		return userRepository.findOne(id);
	}

	@Override
	@Transactional
	public List<User> getUserAll()
	{
		return userRepository.findAll();
	}

	@Override
	@Transactional
	public User save(User user)
	{
		return userRepository.saveAndFlush(user);
	}

	@Override
	@Transactional
	public User update(User user) throws Exception
	{
		/*User updateUser = userRepository.findOne(user.getId());
		if (updateUser == null)
	            throw new Exception("Не нашел юзера для обновления по афйди = "+user.getId());
	        
		updateUser.setPassword(user.getPassword());
		updateUser.setUsername(user.getUsername());
		updateUser.setRole_id(user.getRole_id());*/
		
		return userRepository.saveAndFlush(user);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public User delete(User user)
	{
		userRepository.delete(user.getId());
		return user;
	}
	
}
