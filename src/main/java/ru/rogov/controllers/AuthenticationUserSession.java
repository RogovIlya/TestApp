package ru.rogov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import ru.rogov.entity.User;

@Controller
@SessionAttributes(value = {"user"},types = {User.class})
public class AuthenticationUserSession
{
	@ModelAttribute("user")
    public User createUserSession() {
        return new User();
    }
}
