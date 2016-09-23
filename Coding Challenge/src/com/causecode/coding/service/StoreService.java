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
		stores.put(1L, new StoreModel(1, "Store","12345678","Wakad","","Pune","411057"));
		stores.put(2L, new StoreModel(2, "Kolkata Store","1234321","Behala","","Kolkata","154512"));
	}
	
	//Fetching All stores
	public List<StoreModel> getAllStores(String zip){
		StoreModel storeModel = new StoreModel();
		List<StoreModel> storeList = new ArrayList<>();
		List<DBModel> listOfStores = dbAccessor.getStores();
		if(listOfStores.size() > 0){
			for (DBModel dbModel : listOfStores) {
				//System.out.println("Store name "+dbModel.getStoreName());
				storeModel.setStoreId(dbModel.getStoreId());
				storeModel.setStoreName(dbModel.getStoreName());
				storeModel.setCity(dbModel.getCity());;
				storeList.add(storeModel);
			}
		}
		
		/*if(null != zip){
			for (Long key : stores.keySet()) {
				storeModel = (StoreModel)stores.get(key);
				if(zip.equalsIgnoreCase(storeModel.getZip()))
						storeList.add(storeModel);
			}
		}
		else{
			storeList.addAll(stores.values());
		}*/
		return storeList;
	}
	
	//Fetching specific store based on the ZIP code
	public List<StoreModel> getNearbyStore(String zip){
		return null;
	}
	
	//Creating a Store
	public StoreModel addStore(StoreModel storeModel){
		storeModel.setStoreId(stores.size() + 1 );
		stores.put(storeModel.getStoreId(), storeModel);
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
