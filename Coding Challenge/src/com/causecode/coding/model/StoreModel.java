package com.causecode.coding.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StoreModel {
	
	//Primary Key
	private long storeId;
	private String storeName;
	private String storeContact;
	private String storeAddress1;
	private String storeAddress2;
	private String city;
	private String zip;
	
	public StoreModel(){
	}
	
	public StoreModel(long storeId, String storeName, String storeContact, String storeAddress1, String storeAddress2,
			String city, String zip) {
		this();
		this.storeId = storeId;
		this.storeName = storeName;
		this.storeContact = storeContact;
		this.storeAddress1 = storeAddress1;
		this.storeAddress2 = storeAddress2;
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
	public String getStoreContact() {
		return storeContact;
	}
	public void setStoreContact(String storeContact) {
		this.storeContact = storeContact;
	}
	public String getStoreAddress1() {
		return storeAddress1;
	}
	public void setStoreAddress1(String storeAddress1) {
		this.storeAddress1 = storeAddress1;
	}
	public String getStoreAddress2() {
		return storeAddress2;
	}
	public void setStoreAddress2(String storeAddress2) {
		this.storeAddress2 = storeAddress2;
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
