package com.causecode.coding.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StoreModel {
	
	private long storeId;
	private String storeName;
	private String city;
	private String zip;
	
	public StoreModel(){
	}
	
	public StoreModel(long storeId, String storeName, String city, String zip) {
		this();
		this.storeId = storeId;
		this.storeName = storeName;
		this.city = city;
		this.zip = zip;
	}
	
	public long getStoreId() {
		return storeId;
	}
	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
}
