package com.kiwi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.kiwi.helper.ItemHelper;
import com.kiwi.viewobject.ItemVO;

public class ItemController extends MultiActionController {

	private UserService _userService;
	
	private ItemHelper _itemHelper;
	
	public ModelAndView show(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			String itemCode = request.getParameter("id");
			User user = _userService.getCurrentUser();
			ItemVO item = _itemHelper.getItem(user.getEmail(), itemCode);
			return new ModelAndView("item/show", "item", item);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			//TODO handle to show error msg to user
			return new ModelAndView("show");
		}
	}

	public ModelAndView listItems(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		User user = _userService.getCurrentUser();
		List<ItemVO> items =  _itemHelper.getBySeller(user.getEmail(), 0);
		return new ModelAndView("list-by-user").addObject("items", items);
	}
	
	public UserService getUserService() {
		return _userService;
	}

	public void setUserService(UserService userService) {
		this._userService = userService;
	}
	


}
