package com.yunfeic.test.entity;

public class Card {
//	private static final long serialVersionUID = 3422034426606825434L;
	private int cid;
	private int cnum;
	private Person p;
	public Card() {}
	
	
	
	public Card(int cid, int cnum) {
		this.cid = cid;
		this.cnum = cnum;
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

	public int getCnum() {
		return cnum;
	}

	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	
	
}
