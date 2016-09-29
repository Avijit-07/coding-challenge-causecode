package com.causecode.coding.daoImpl;

import java.util.List;

import org.hibernate.Session;

import com.causecode.coding.model.DBModel;

public interface DatabaseManager {
	
	List<DBModel> getStores();
	
	int addStore(DBModel dbModel);
	
	DBModel updateStore(int storeId, DBModel dbModel);
	
	void deleteStore(int storeId);
}
