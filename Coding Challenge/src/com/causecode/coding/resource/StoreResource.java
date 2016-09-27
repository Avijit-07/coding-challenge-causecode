package com.causecode.coding.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.causecode.coding.model.StoreModel;
import com.causecode.coding.service.StoreService;

@Path("/store")
public class StoreResource {

	StoreService storeService = new StoreService();
	
		//Find a store within "x" miles of a USA zip code
		@Path("/getStore")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<StoreModel> getStore(@QueryParam("zip") String zip){
			List<StoreModel> storeList = new ArrayList<>();
			if(null != zip)
				storeList =storeService.getAllStores(zip);
			else
				storeList = storeService.getAllStores(null);
			/*for (StoreModel storeModel : storeList) {
				System.out.println("Store name: "+storeModel.getStoreName());
			}*/
			return storeList;
		}
		
		//Create a Store
		@Path("/addStore")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response createStore(StoreModel storeModel){
			return Response.status(Status.CREATED)
					.entity(storeService.addStore(storeModel))
					.build();
		}
		
		//Update a Store
		@Path("/{storeId}")
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public StoreModel updateStore(@PathParam("storeId") long storeId, StoreModel storeModel){
			storeModel.setStoreId(storeId);
			return storeService.updateStore(storeModel);
		}
		
		//Delete a Store
		@Path("/{storeId}")
		@DELETE
		@Produces(MediaType.TEXT_PLAIN)
		public String removeStore(@PathParam("storeId") long storeId){
			storeService.removeStore(storeId);
			return "Store has been removed";
		}
}
