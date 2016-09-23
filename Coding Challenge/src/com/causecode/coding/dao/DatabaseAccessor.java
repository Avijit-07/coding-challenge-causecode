package com.causecode.coding.dao;

import java.util.List;

import org.hibernate.Session;

import com.causecode.coding.daoImpl.DatabaseManager;
import com.causecode.coding.model.DBModel;
import com.causecode.coding.util.HibernateUtil;

public class DatabaseAccessor {

	DatabaseManager dbManager = new DatabaseManager();
	
	public List<DBModel> getStores(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<DBModel> listOfStores = dbManager.getStores(session);
		HibernateUtil.shutdown();
		System.out.println("Store name in DBAccessor");
		return listOfStores;
	}
}
