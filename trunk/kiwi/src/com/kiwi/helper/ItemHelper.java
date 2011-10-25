package com.kiwi.helper;

import java.util.LinkedList;
import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.kiwi.dao.ItemDAO;
import com.kiwi.viewobject.ItemVO;

public class ItemHelper {

	private ItemDAO _itemDAO;
	
	public List<ItemVO> getBySeller(String userEmail, int offset)
	{
		List<Entity> lsIn = _itemDAO.getBySeller(userEmail, offset);
		List<ItemVO> lsOut = new LinkedList<ItemVO>();
		for(Entity e : lsIn)
		{
			lsOut.add(entity2Item(e));
		}
		return lsOut;
	}

	public ItemVO getItem(String userEmail, String itemCode) throws EntityNotFoundException
	{
		return entity2Item(_itemDAO.getItem(userEmail, itemCode));
	}
	
	private ItemVO entity2Item(Entity e)
	{
		ItemVO vo = new ItemVO();
		vo.setItemCode(e.getKey().getName());
		vo.setUrl(_itemDAO.getUrl(e));
		return vo;
	}
	
	public ItemDAO getItemDAO() {
		return _itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		_itemDAO = itemDAO;
	}
	
}
