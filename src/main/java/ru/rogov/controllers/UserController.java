package ru.rogov.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ru.rogov.entity.User;
import ru.rogov.service.ServiceFasade;

@Controller
public class UserController extends AuthenticationUserSession
{
	@Autowired
	ServiceFasade fasade;

	private static final Logger	logger	= LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = { "/user" }, method = RequestMethod.GET)
	public ModelAndView getUserInfo(@ModelAttribute User user)
	{	
		ModelAndView model = new ModelAndView();
		model.addObject("user", user);
		
		model.setViewName("user");
		
		return model;
	}
	
}
