package com.causecode.coding.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.causecode.coding.dao.DatabaseAccessor;
import com.causecode.coding.model.DBModel;
import com.causecode.coding.model.StoreModel;

public class StoreService {
	
	public static Map<Long, StoreModel> stores = new HashMap<>();
	DatabaseAccessor dbAccessor = new DatabaseAccessor();
	
	public StoreService() {
	}
	
	//Fetching All stores
	public List<StoreModel> getAllStores(String zip){
		List<StoreModel> storeList = new ArrayList<>();
		List<DBModel> listOfStores = dbAccessor.getStores();
		if(listOfStores.size() > 0){
			for (DBModel dbModel : listOfStores) {
				StoreModel storeModel = new StoreModel();
				storeModel.setStoreId(dbModel.getStoreId());
				storeModel.setStoreName(dbModel.getStoreName());
				storeModel.setCity(dbModel.getCity());
				storeList.add(storeModel);
			}
		}
		return storeList;
	}
	
	
	//Creating a Store
	public int addStore(StoreModel storeModel){
		DBModel dbModel = new DBModel();
		dbModel.setStoreId((int)storeModel.getStoreId());
		dbModel.setStoreName(storeModel.getStoreName());
		dbModel.setCity(storeModel.getCity());
		dbModel.setZip(Long.parseLong(storeModel.getZip()));
		int storeId = dbAccessor.addStore(dbModel);
		return storeId;
	}
	
	//Updating a Store detail
	public StoreModel updateStore(long storeId, StoreModel storeModel){
		if(storeModel.getStoreId() == 0){
			return null;
		}
		else{
			DBModel dbModel = new DBModel();
			dbModel.setStoreId((int)storeModel.getStoreId());
			dbModel.setStoreName(storeModel.getStoreName());
			dbModel.setCity(storeModel.getCity());
			dbModel.setZip(Long.parseLong(storeModel.getZip()));
			System.out.println("Store value before updating "+storeModel.getStoreName());
			dbModel = dbAccessor.updateStore(dbModel.getStoreId(), dbModel);
			storeModel.setStoreId(dbModel.getStoreId());
			storeModel.setStoreName(dbModel.getStoreName());
			storeModel.setCity(dbModel.getCity());
			storeModel.setZip(String.valueOf(dbModel.getZip()));
			System.out.println("Store value after updating "+storeModel.getStoreName());
		}
		return storeModel;
	}
	
	//Removing a Store Detail
	public void removeStore(long storeId){
		stores.remove(storeId);
	}
}
