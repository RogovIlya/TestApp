package ru.rogov.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import ru.rogov.entity.User;
import ru.rogov.service.UserService;

@Repository
public class UserDAO implements UserService
{
	@Autowired
	private JdbcTemplate		jdbc;

	private static final String	SQL_GET_USER_LOGIN_AND_PASSWORD	= "SELECT " + "    LOGIN, " + "    PASSWORD, " + "    R.ROLE " + "FROM " + "    db.USERS AS U " + "LEFT JOIN " + "    db.ROLES AS R " + "ON " + "    U.ROLE = R.ID " + "WHERE " + "    U.LOGIN = ? " + "AND U.PASSWORD = ?  LIMIT 1";

	private static final String	SQL_GET_USER_LOGIN				= "SELECT " + "    LOGIN, " + "    PASSWORD, " + "    R.ROLE " + "FROM " + "    db.USERS AS U " + "LEFT JOIN " + "    db.ROLES AS R " + "ON " + "    U.ROLE = R.ID " + "WHERE " + "    U.LOGIN = ?  LIMIT 1";

	public void setJdbc(JdbcTemplate jdbc)
	{
		this.jdbc = jdbc;
	}

	public User getUser(String login, String passsword)
	{
		try
		{
			User user = (User) jdbc.queryForObject(SQL_GET_USER_LOGIN_AND_PASSWORD, new Object[] { login, passsword }, User.getMapper());
			return user;
		} catch (Exception e)
		{
			logger.error(e.getMessage(),e);
			return null;
		}
	}

	public User getUser(String login)
	{ 
		try
		{
			User user = (User) jdbc.queryForObject(SQL_GET_USER_LOGIN, new Object[] { login }, User.getMapper()); 
			logger.info(user.toString());
			return user;
		} catch (Exception e)
		{
			logger.error(e.getMessage(),e);
			return null;
		}
	}

	public static void main(String[] args)
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db");
		dataSource.setUsername("root");
		dataSource.setPassword("password");

		JdbcTemplate j = new JdbcTemplate(dataSource);
		User user = (User) j.queryForObject(SQL_GET_USER_LOGIN, new Object[] { "user1" }, User.getMapper());
		//System.out.println(user);
	}
}
