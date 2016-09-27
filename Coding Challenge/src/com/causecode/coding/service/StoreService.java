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
	
	//Fetching specific store based on the ZIP code
	public List<StoreModel> getNearbyStore(String zip){
		return null;
	}
	
	//Creating a Store
	public StoreModel addStore(StoreModel storeModel){
		DBModel dbModel = new DBModel();
		dbModel.setStoreId((int)storeModel.getStoreId());
		dbModel.setStoreName(storeModel.getStoreName());
		dbModel.setCity(storeModel.getCity());
		dbModel.setZip(Long.parseLong(storeModel.getZip()));
		dbAccessor.addStore(dbModel);
		return storeModel;
	}
	
	//Updating a Store detail
	public StoreModel updateStore(StoreModel storeModel){
		if(storeModel.getStoreId() == 0){
			return null;
		}
		else{
			stores.put(storeModel.getStoreId(), storeModel);
		}
		return storeModel;
	}
	
	//Removing a Store Detail
	public void removeStore(long storeId){
		stores.remove(storeId);
	}
}
