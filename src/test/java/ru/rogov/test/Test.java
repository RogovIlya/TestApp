package ru.rogov.test;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.ServletContextAware;

import ru.rogov.configuration.SpringConfiguration;

@Component
@ComponentScan(basePackages = "ru.rogov")
public class Test 
{
	private static final Logger logger = LoggerFactory.getLogger(Test.class);
	
	@Autowired
	public static ServletContext servletContext;
	
	public static void main(String[] args)
	{
		test();
	}

	public static void test()
	{
		System.out.println(servletContext.getMinorVersion());
	}	
}
