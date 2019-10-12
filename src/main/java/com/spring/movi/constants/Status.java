package com.spring.movi.constants;

public enum Status {

	Active("1", "Active "),
	InActive("2", "InActive"),
	Modify("3", "Modify"),
	Request("4","Modify"),
	Cancel("5","Modify"),
	Delete("6", "Delete"),
	Expired("7","Modify");
	
	String value;
	String description;
	
	Status(String v, String d) {
		this.value = v;
		this.description = d;
	}
	
	public int getValueInt() {
		return Integer.parseInt(value);
	}
	
	public String getValueStr() {
		return value;
	}
	
	public String getDescription() {
		return description;
	}
}
