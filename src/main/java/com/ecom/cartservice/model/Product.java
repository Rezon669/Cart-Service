package com.ecom.cartservice.model;



public class Product {

	private long productid;

	private String productname;

	
	private int price;

	private int quantity;

	private String category;

	private String searchkeyword;

	public long getProductid() {
		return productid;
	}

	public void setProductid(long productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSearchkeyword() {
		return searchkeyword;
	}

	public void setSearchkeyword(String searchkeyword) {
		this.searchkeyword = searchkeyword;
	}

	

	

}
