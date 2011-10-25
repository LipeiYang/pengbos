package com.kiwi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.kiwi.helper.SellerHelper;

public class SellerFormController extends SimpleFormController
{
	private UserService userService;
	private SellerHelper sellerHelper;
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors)  throws Exception {
        User user = userService.getCurrentUser();
        if (user != null) {
        	sellerHelper.addSeller(user.getEmail());
            return new ModelAndView(new RedirectView(getSuccessView()));
        } else {
            return new ModelAndView(new RedirectView(userService.createLoginURL(request.getRequestURI())));
        }

	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public SellerHelper getSellerHelper() {
		return sellerHelper;
	}

	public void setSellerHelper(SellerHelper sellerHelper) {
		this.sellerHelper = sellerHelper;
	}	
	
	
}
