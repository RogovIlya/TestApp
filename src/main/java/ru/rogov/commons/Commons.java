package ru.rogov.commons;

import com.google.gson.Gson;

public class Commons
{
	private final static Gson gson = new Gson();
	
	public static String toJSon(Object obj)
	{
		return gson.toJson(obj);
	}
}
