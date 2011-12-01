package com.habuma.santaslist.toy;

public class Toy {
	
	private long id;
	
	private String name;
	
	private String description;
	
	private long onhand;

	public Toy(long id, String name, String description, long onhand) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.onhand = onhand;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setOnhand(long onhand) {
		this.onhand = onhand;
	}

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public long getOnhand() {
		return onhand;
	}

}
