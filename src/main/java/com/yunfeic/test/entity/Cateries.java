package com.yunfeic.test.entity;

import java.util.Set;

public class Cateries {
	private int cateryId;
	private String cateryName;
	private String cateryDescn;

	private Set<Products> pros;

	public Cateries() {
		// TODO Auto-generated constructor stub
	}

	public Cateries(int cateryId, String cateryName, String cateryDescn) {
		this.cateryId = cateryId;
		this.cateryName = cateryName;
		this.cateryDescn = cateryDescn;
	}

	public Cateries(String cateryName, String cateryDescn) {
		this.cateryName = cateryName;
		this.cateryDescn = cateryDescn;
	}

	public int getCateryId() {
		return cateryId;
	}

	public void setCateryId(int cateryId) {
		this.cateryId = cateryId;
	}

	public String getCateryName() {
		return cateryName;
	}

	public void setCateryName(String cateryName) {
		this.cateryName = cateryName;
	}

	public String getCateryDescn() {
		return cateryDescn;
	}

	public void setCateryDescn(String cateryDescn) {
		this.cateryDescn = cateryDescn;
	}

	public Set<Products> getPros() {
		return pros;
	}

	public void setPros(Set<Products> pros) {
		this.pros = pros;
	}

}
