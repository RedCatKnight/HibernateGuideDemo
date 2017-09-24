package com.yunfeic.test.entity;

public class Card {
//	private static final long serialVersionUID = 3422034426606825434L;
	private int cid;
	private int cunm;
	private Person p;
	public Card() {}
	public Card(int cunm, Person p) {
		super();
		this.cunm = cunm;
		this.p = p;
	}
	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCunm() {
		return cunm;
	}
	public void setCunm(int cunm) {
		this.cunm = cunm;
	}
	
	
}
