package ru.rogov.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class User
{
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null)
		{
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null)
		{
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (username == null)
		{
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	private String	username;
	private String	password;
	private String	role;

	public User()
	{
		super();
	}

	@Override
	public String toString()
	{
		return "User [username=" + username + ", password=" + password + ", role=" + role + "]";
	}

	public User(String username, String password, String role)
	{
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}

	public static RowMapper<User> getMapper()
	{
		return new RowMapper<User>()
		{
			public User mapRow(ResultSet rs, int row) throws SQLException
			{
				return new User(rs.getString("LOGIN"), rs.getString("PASSWORD"), rs.getString("ROLE"));
			}
		};

	}

}
