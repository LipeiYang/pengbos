package com.kiwi.helper;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.kiwi.dao.SellerDAO;
import com.kiwi.viewobject.SellerVO;

public class SellerHelper {

	private SellerDAO _sellerDAO;

	public void addSeller(String userEmail)
	{
		_sellerDAO.addSeller(userEmail);
	}
	
	public SellerVO getSeller(String userEmail) throws EntityNotFoundException
	{
		Entity e = _sellerDAO.getSeller(userEmail);
		SellerVO vo = new SellerVO();
		vo.setEmail(userEmail);
		vo.setAmount(_sellerDAO.getAmount(e));
		vo.setComingAmount(_sellerDAO.getComingAmount(e));
		return vo;
	}
	
	public SellerDAO getSellerDAO() {
		return _sellerDAO;
	}

	public void setSellerDAO(SellerDAO sellerDAO) {
		_sellerDAO = sellerDAO;
	}

}
