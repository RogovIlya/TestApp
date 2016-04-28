package ru.rogov.commons;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.google.gson.Gson;


public class Commons
{
	private final static Gson gson = new Gson();

	public static String toJSon(Object obj)
	{
		return gson.toJson(obj);
	}

	public static String getPrincipal()
	{
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
		{
			userName = ((UserDetails) principal).getUsername();
		} else
		{
			userName = principal.toString();
		}
		return userName;
	}

}
