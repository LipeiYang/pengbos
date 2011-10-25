package com.kiwi.dao;

import java.util.Date;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class ItemDAO {

	final static String KIND = "item";
	final static String F_URL = "url";
	final static String F_CREATE_DATE = "create_date";
	private final static int DEFAULT_LIMIT = 20;
	
	private DatastoreService _datastoreService;
	private SellerDAO _sellerDAO;

	public void addItem(String url, String userEmail)
	{
		addItem(url, new Date(), userEmail);
	}
	
	public void addItem(String url, Date crtDate, String userEmail)
	{
		Entity sellItem = new Entity(KIND, getKeyName(url), getParentKey(userEmail));
		sellItem.setProperty(F_URL, url);
		sellItem.setProperty(F_CREATE_DATE, crtDate);
		_datastoreService.put(sellItem);
	}

	public final List<Entity> getBySeller(String userEmail, int offset)
	{
		return getBySeller(userEmail, offset, DEFAULT_LIMIT);
	}
	
	public final List<Entity> getBySeller(String userEmail, int offset , int limit)
	{
		Query q = new Query(KIND).setAncestor(_sellerDAO.getKey(userEmail));
		PreparedQuery pq = _datastoreService.prepare(q);
		return pq.asList(FetchOptions.Builder.withLimit(limit).offset(offset));
	}
	
	public final Entity getItem(String userEmail, String itemCode) throws EntityNotFoundException
	{
		return _datastoreService.get(getKey(userEmail, itemCode));
	}
	
	public final String getUrl(Entity e)
	{
		return (String)e.getProperty(F_URL);
	}
	
	final Key getParentKey(String userEmail)
	{
		return _sellerDAO.getKey(userEmail);
	}
	
	final Key getKey(String userEmail, String url)
	{
		return KeyFactory.createKey(getParentKey(userEmail), KIND, getKeyName(url));
	}
	
	private final int getKeyName(String url)
	{
		return url.hashCode();
	}
	
	public DatastoreService getDatastoreService() {
		return _datastoreService;
	}

	public void setDatastoreService(DatastoreService datastoreService) {
		this._datastoreService = datastoreService;
	}
	
}
