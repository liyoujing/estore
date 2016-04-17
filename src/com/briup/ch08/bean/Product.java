package com.briup.ch08.bean;

public class Product {
	private Long pro_id;
	private String pro_name;
	private String pro_address;
	private Double price;
	private String describle;
	
	public Product(){
		
	}
	
	public Product(String pro_name, String pro_address,
			Double price, String describle) {
		super();
		
		this.pro_name = pro_name;
		this.pro_address = pro_address;
		this.price = price;
		this.describle = describle;
	}

	public Long getPro_id() {
		return pro_id;
	}
	public void setPro_id(Long pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPro_address() {
		return pro_address;
	}
	public void setPro_address(String pro_address) {
		this.pro_address = pro_address;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescrible() {
		return describle;
	}
	public void setDescrible(String describle) {
		this.describle = describle;
	}

}
