package com.kiwi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.users.UserService;
import com.kiwi.helper.SellerHelper;
import com.kiwi.viewobject.SellerVO;

public class SellerController extends MultiActionController {

	private UserService userService;
	
	private SellerHelper sellerHelper;
	
	public ModelAndView show(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			SellerVO seller = sellerHelper.getSeller(userService.getCurrentUser().getEmail());
			return new ModelAndView("seller/show", "seller", seller);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			//TODO handle to show error msg to user
			return new ModelAndView("show");
		}
	}

	public ModelAndView listItems(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		userService.getCurrentUser().getEmail();
		
		
		
		
		return new ModelAndView("user", "message", "Add method called");
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
