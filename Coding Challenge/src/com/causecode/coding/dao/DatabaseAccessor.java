package com.causecode.coding.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.causecode.coding.daoImpl.DatabaseManager;
import com.causecode.coding.model.DBModel;
import com.causecode.coding.util.HibernateUtil;

public class DatabaseAccessor {

	DatabaseManager dbManager = new DatabaseManager();
	Session session = null;
	Transaction transaction = null;
	
	@SuppressWarnings("unchecked")
	public List<DBModel> getStores(){
		session = HibernateUtil.getSessionFactory().openSession();
		List<DBModel> listOfStores = new ArrayList<>();
		try{
			transaction = session.beginTransaction();
			listOfStores = (List<DBModel>)session.createQuery("from DBModel").list();
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return listOfStores;
	}
	
	public void addStore(DBModel dbModel){
		session = HibernateUtil.getSessionFactory().openSession();
		try{
			transaction = session.beginTransaction();
			session.save(dbModel);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
}
