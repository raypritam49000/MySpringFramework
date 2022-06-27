package com.products.data;

public class Product {
	private Integer pid;
	private String pname;
	private String price;
	private String productImageNames;
	private String productImageUrl;
	private Object productImages;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProductImageNames() {
		return productImageNames;
	}

	public void setProductImageNames(String productImageNames) {
		this.productImageNames = productImageNames;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public Object getProductImages() {
		return productImages;
	}

	public void setProductImages(Object productImages) {
		this.productImages = productImages;
	}
}