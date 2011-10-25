package com.kiwi.helper;

import com.kiwi.dao.ItemDAO;
import com.kiwi.viewobject.ItemVO;

public class ItemFormHelper {

	private ItemDAO _itemDAO;

	public void addSellItem(ItemVO itemVO, String userEmail)
	{
		_itemDAO.addItem(itemVO.getUrl(), userEmail);
	}

	public ItemDAO getItemDAO() {
		return _itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		_itemDAO = itemDAO;
	}
}
