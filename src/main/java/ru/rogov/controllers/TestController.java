package ru.rogov.controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ru.rogov.service.ServiceFasade;
import ru.rogov.service.UserService;

@Controller
public class TestController
{
	@Autowired
	ServiceFasade fasade;

	private static final Logger	logger	= LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	ServletContext context;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView homePage()
	{	
		ModelAndView model = new ModelAndView();
		model.addObject("greeting", "Hi, Welcome to mysite");
		model.setViewName("index");
		return model;
	}

	@RequestMapping("/test")
	public ModelAndView test()
	{
		ModelAndView mv = new ModelAndView();
		UserDetails userDetails =  (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mv.addObject("test", fasade.getUserService().getUser(1L));
		//mv.addObject("userDetails", userDetails);
		
		mv.setViewName("test");
		return mv;
	}

	@RequestMapping(value = "/login")
	public String login(ModelMap model)
	{
		model.addAttribute("user", getPrincipal());
		return "login";
	}

	@RequestMapping(value = "/result")
	public ModelAndView result()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", getPrincipal());
		mv.setViewName("result");
		return mv;
	}

	@RequestMapping(value = "/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null)
		{
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "login";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model)
	{
		model.addAttribute("user", getPrincipal());
		return "admin";
	}

	private String getPrincipal()
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