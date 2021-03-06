package com.causecode.coding.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.causecode.coding.daoImpl.DatabaseManager;
import com.causecode.coding.model.DBModel;
import com.causecode.coding.util.HibernateUtil;

public class DatabaseAccessor implements DatabaseManager {

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
	
	public int addStore(DBModel dbModel){
		session = HibernateUtil.getSessionFactory().openSession();
		int storeId = 0;
		try{
			transaction = session.beginTransaction();
			storeId = (int) session.save(dbModel);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return storeId;
	}
	
	public DBModel updateStore(int storeId, DBModel dbModel){
		session = HibernateUtil.getSessionFactory().openSession();
		DBModel oldDBmodel = null;
		try{
			transaction = session.beginTransaction();
			oldDBmodel = (DBModel)session.get(DBModel.class, storeId);
			oldDBmodel.setStoreName(dbModel.getStoreName());
			oldDBmodel.setCity(dbModel.getCity());
			oldDBmodel.setZip(dbModel.getZip());
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return oldDBmodel;
	}
	
	public void deleteStore(int storeId){
		session = HibernateUtil.getSessionFactory().openSession();
		try{
			transaction = session.beginTransaction();
			DBModel storeDetail = (DBModel) session.get(DBModel.class, storeId);
			session.delete(storeDetail);
			transaction.commit();
		}
		catch (HibernateException he) {
			transaction.rollback();
			he.printStackTrace();
		}
		finally{
			session.close();
		}
	}
}
