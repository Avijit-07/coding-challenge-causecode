package com.causecode.coding.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.causecode.coding.model.StoreModel;

public class StoreService {
	
	//Find a store within "x" miles of a USA zip code
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Welcome to Store Service!";
	}
	
	//Create a Store
	@POST
	public String createStore(StoreModel storeModel){
		return null;
	}
	
	//Update a Store
	@PUT
	public String updateStore(StoreModel storeModel){
		return null;
	}
	
	//Delete a Store
	@DELETE
	public String removeStore(String storeId){
		return null;
	}
}
