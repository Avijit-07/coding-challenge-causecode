package com.causecode.coding.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.causecode.coding.model.DBModel;

public class DatabaseManager {
	
	public List<DBModel> getStores(Session session){
		List<DBModel> listOfStores = new ArrayList<>();
		session.beginTransaction();
		//DBModel store = (DBModel)
		System.out.println("Direct from DB "+session.get(DBModel.class, 1));
		session.close();
		//listOfStores.add(store);
		System.out.println("Store name in DBManager ");
		return listOfStores;
	}
}
