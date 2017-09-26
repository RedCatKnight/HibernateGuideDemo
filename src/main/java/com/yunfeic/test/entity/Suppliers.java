package com.yunfeic.test.entity;

import java.util.Set;

public class Suppliers {
	private String supplyNo;
	private String supplyName;
	private String supplyDescn;
	private Set<Products> pros;

	public Suppliers() {
	}

	public Suppliers(String supplyName, String supplyDescn) {
		this.supplyName = supplyName;
		this.supplyDescn = supplyDescn;
	}

	public String getSupplyNo() {
		return supplyNo;
	}

	public void setSupplyNo(String supplyNo) {
		this.supplyNo = supplyNo;
	}

	public String getSupplyName() {
		return supplyName;
	}

	public void setSupplyName(String supplyName) {
		this.supplyName = supplyName;
	}

	public String getSupplyDescn() {
		return supplyDescn;
	}

	public void setSupplyDescn(String supplyDescn) {
		this.supplyDescn = supplyDescn;
	}

	public Set<Products> getPros() {
		return pros;
	}

	public void setPros(Set<Products> pros) {
		this.pros = pros;
	}

}
