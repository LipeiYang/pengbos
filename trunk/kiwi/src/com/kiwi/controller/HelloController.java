package com.kiwi.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;

public class HelloController implements Controller {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    
	private UserService userService;

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String now = (new Date()).toString();
        logger.info("Returning hello view with {}", now);
        
        User user = userService.getCurrentUser();

        if (user != null) {
            return new ModelAndView("hello", "now", now);
        } else {
            return new ModelAndView(new RedirectView(userService.createLoginURL(request.getRequestURI())));
        }

//        return new ModelAndView("hello", "now", now);
        
    }

	
    public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}