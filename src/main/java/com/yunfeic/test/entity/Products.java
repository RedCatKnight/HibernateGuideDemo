package com.yunfeic.test.entity;

import java.util.HashSet;
import java.util.Set;

public class Products {
	private String productNo;
	private String productName;
	private float productPrice;
	private String photoPath;
	private String productDescn;

	private Cateries catery;
	private Set<Suppliers> supplys=new HashSet<Suppliers>();

	public Products() {
		// TODO Auto-generated constructor stub
	}

	public Products(String productName, float productPrice, String photoPath, String productDescn) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.photoPath = photoPath;
		this.productDescn = productDescn;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public Cateries getCatery() {
		return catery;
	}

	public void setCatery(Cateries catery) {
		this.catery = catery;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getProductDescn() {
		return productDescn;
	}

	public void setProductDescn(String productDescn) {
		this.productDescn = productDescn;
	}

	public Set<Suppliers> getSupplys() {
		return supplys;
	}

	public void setSupplys(Set<Suppliers> supplys) {
		this.supplys = supplys;
	}

}
