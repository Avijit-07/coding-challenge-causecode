package com.causecode.coding.resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.causecode.coding.model.DBModel;

public class DBResource {

	public static void main(String[] args) {
		DBModel dbModel = new DBModel();
		dbModel.setStoreId(1);
		dbModel.setStoreName("Store 1");
		dbModel.setCity("Pune");
		dbModel.setZip(411057);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(dbModel);
		session.getTransaction().commit();
		session.close();
	}
}
