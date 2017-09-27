package com.yunfeic.test.entity;

public class Card {
	private int cid;
	private String cname;
	private Person p;
	public Card() {}
	
	
	public Card(String cname) {
		this.cname = cname;
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


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}

}
