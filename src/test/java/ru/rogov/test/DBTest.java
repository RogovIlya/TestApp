package ru.rogov.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.mockito.verification.VerificationMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import ru.rogov.dao.UserDAO;
import ru.rogov.entity.User;


@RunWith(MockitoJUnitRunner.class)
public class DBTest
{
	DriverManagerDataSource dataSource;
	
	JdbcTemplate jdbc;
	
	UserDAO userDao;
	
	User admin;
	User user;
	
	
	@Before 
	public void setup()
	{
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		
		jdbc = new JdbcTemplate();
		jdbc.setDataSource(dataSource);
		
		userDao = new UserDAO();
		userDao.setJdbc(jdbc);
		
		admin = new User("admin","5f4dcc3b5aa765d61d8327deb882cf99","ROLE_ADMIN");
		user = new User("user1","5f4dcc3b5aa765d61d8327deb882cf99","ROLE_USER");
	  
	}
	@Test
	public void testUserDao() throws SQLException
	{
		assertEquals(user,userDao.getUser("user1"));
		assertEquals(admin,userDao.getUser("admin"));
		assertEquals(null,userDao.getUser(null));
	}
	
}
