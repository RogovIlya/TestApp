package ru.rogov.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ru.rogov.configuration.SecurityWebApplicationInitializer;
import ru.rogov.configuration.SpringConfiguration;
import ru.rogov.entity.Role;
import ru.rogov.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class, SecurityWebApplicationInitializer.class})
@WebAppConfiguration
public class UserTest
{
	User user;
	User user2;
	
	@Before
	public void init()
	{
		user2 = new User("admin","password",1L);
	}
	
	@Test
	public void isNull()
	{
		assertNotEquals(user, user2);
	}
	
	@Test
	public void GetTest()
	{
		assertEquals("admin", user2.getUsername());
		assertEquals("password", user2.getPassword());
		assertEquals("role_admin", user2.getRole().getName());
	}
	
	public void SetTest()
	{
		//user.setRole("role_admin");
		user.setPassword("password");
		user.setUsername("admin");
		
		assertEquals("admin", user.getUsername());
		assertEquals("password", user.getPassword());
		assertEquals("role_admin", user.getRole());
	}
}
