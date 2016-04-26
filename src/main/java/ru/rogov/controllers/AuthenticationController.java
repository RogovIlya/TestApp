package ru.rogov.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import ru.rogov.commons.Commons;
import ru.rogov.entity.User;
import ru.rogov.service.ServiceFasade;

@Controller
@SessionAttributes(value = {"user"},types = {User.class})
public class AuthenticationController
{
	@Autowired
	ServiceFasade fasade;

	private static final Logger	logger	= LoggerFactory.getLogger(AuthenticationController.class);
	
	@RequestMapping(value = "/authentication", method = RequestMethod.GET)
	public ModelAndView authentication(@RequestParam(value="error",required=false) String error)
	{
		
		if(error != null && !error.isEmpty())
		{
			logger.info("Произошла ошибка при авторизации пользователя! Тип ошибки = "+error);
		}
		
		ModelAndView mv = new ModelAndView();
		User user = fasade.getUserService().getUser(Commons.getPrincipal());
		if(user == null)
		{
			logger.info("Пользователь не найден!");
			user = new User();
		}
		else
		{
			logger.info("Авторизовался пользователь = "+user);
		}
		
		mv.addObject("user", user);
		mv.setViewName("index");
		
		return mv;
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response,SessionStatus status)
	{
		ModelAndView mv = new ModelAndView();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null)
		{
			System.out.println("*************удалил user");
			status.setComplete();
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@ModelAttribute("user")
    public User createUserSession() {
        return new User();
    }

}
