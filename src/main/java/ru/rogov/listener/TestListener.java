package ru.rogov.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class TestListener implements ServletContextListener
{
	private static final Logger	logger	= LoggerFactory.getLogger(TestListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce)
	{
		ServletContext context = sce.getServletContext();
		context.setInitParameter("test", "testInitParam");
		String t = context.getInitParameter("test");
		context.setAttribute("testAttr", t+"kkk");
		System.out.println("The application started");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce)
	{
		ServletContext context = sce.getServletContext();
		context.removeAttribute("test");
		System.out.println("The application stopped");
		
	}

}
