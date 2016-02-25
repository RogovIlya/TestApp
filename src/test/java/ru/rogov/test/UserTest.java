package ru.rogov.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import ru.rogov.entity.User;

public class UserTest
{
	User user;
	User user2;
	
	@Before
	public void init()
	{
		user = new User();
		user2 = new User("admin","password","role_admin");
	}
	
	@Test
	public void isNull()
	{
		assertEquals(new User("admin","password","role_admin"), user2);
		assertNotEquals(user, user2);
	}
	
	@Test
	public void GetTest()
	{
		assertEquals("admin", user2.getUsername());
		assertEquals("password", user2.getPassword());
		assertEquals("role_admin", user2.getRole());
	}
	
	public void SetTest()
	{
		user.setRole("role_admin");
		user.setPassword("password");
		user.setUsername("admin");
		
		assertEquals("admin", user.getUsername());
		assertEquals("password", user.getPassword());
		assertEquals("role_admin", user.getRole());
	}
}
