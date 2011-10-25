package com.kiwi.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class SellerDAO {
    private final Logger _logger = LoggerFactory.getLogger(getClass());
	
	public final static String KIND = "seller";
	public final static String F_AMOUNT = "amount";
	public final static String F_COMING_AMOUNT = "coming_amount";
	public final static int DEFAULT_LIMIT = 20;

	private DatastoreService _datastoreService;

	public final Entity getSeller(String userEmail) throws EntityNotFoundException
	{
		return _datastoreService.get(getKey(userEmail));
	}
	
	public final void addSeller(String userEmail)
	{
		addSeller(userEmail, 0.0, 0.0);
	}
	
	public final void addSeller(String userEmail, Double amount, Double comingAmount)
	{
		Entity seller = new Entity(KIND, userEmail);
		seller.setProperty(F_AMOUNT, amount);
		seller.setProperty(F_COMING_AMOUNT, comingAmount);
		_datastoreService.put(seller);
	}
	
	public final Double getAmount(Entity e)
	{
		return (Double)e.getProperty(SellerDAO.F_AMOUNT);
	}
	
	public final Double getComingAmount(Entity e)
	{
		return (Double)e.getProperty(SellerDAO.F_COMING_AMOUNT);
	}
	
	final Key getKey(String userEmail)
	{
		return KeyFactory.createKey(KIND, userEmail);
	}
	
	public DatastoreService getDatastoreService() {
		return _datastoreService;
	}

	public void setDatastoreService(DatastoreService datastoreService) {
		this._datastoreService = datastoreService;
	}
	
}
