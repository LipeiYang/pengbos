package com.kiwi.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.google.appengine.api.users.UserService;
import com.kiwi.helper.ItemFormHelper;
import com.kiwi.viewobject.ItemVO;

public class ItemFormController extends SimpleFormController {

    
	private UserService _userService;
	
	private ItemFormHelper _itemFormHelper;
	
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		ItemVO itemVO = (ItemVO) command;
		_itemFormHelper.addSellItem(itemVO, _userService.getCurrentUser().getEmail());
		return new ModelAndView(getSuccessView());
	}
	
    public UserService getUserService() {
		return _userService;
	}

	public void setUserService(UserService userService) {
		this._userService = userService;
	}

	public ItemFormHelper getItemFormHelper() {
		return _itemFormHelper;
	}

	public void setItemFormHelper(ItemFormHelper itemFormHelper) {
		_itemFormHelper = itemFormHelper;
	}

}