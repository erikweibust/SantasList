package com.habuma.santaslist.child;

public class Child {

	private long id;
	
	private String name;
	
	private String address;
	
	private boolean naughty;

	public Child(long id, String name, String address, boolean naughty) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.naughty = naughty;
	}

	public Child(String name, String address, boolean naughty) {
		this.name = name;
		this.address = address;
		this.naughty = naughty;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isNaughty() {
		return naughty;
	}

	public void setNaughty(boolean naughty) {
		this.naughty = naughty;
	}
	
}
