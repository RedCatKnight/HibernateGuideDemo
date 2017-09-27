package com.yunfeic.test.entity;

public class Person {
	// private static final long serialVersionUID = 4732711513313494849L;
	private int pid;
	private String pname;
	private Card c;

	public Person() {
	}

	public Person(int pid, String pname) {
		this.pid = pid;
		this.pname = pname;
	}

	public Card getC() {
		return c;
	}

	public void setC(Card c) {
		this.c = c;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

}
