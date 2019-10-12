package com.spring.movi.dto;

public class ReturnStatus {

	private boolean status;
	private String setStatus;
	private String description;
	
	public ReturnStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReturnStatus(boolean status, String setStatus, String description) {
		super();
		this.status = status;
		this.setStatus = setStatus;
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getSetStatus() {
		return setStatus;
	}

	public void setSetStatus(String setStatus) {
		this.setStatus = setStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ReturnStatus [status=" + status + ", setStatus=" + setStatus + ", description=" + description + "]";
	}
	
	
	public ReturnStatus set(boolean b, String s, String d) {
		ReturnStatus status = new ReturnStatus();
		status.setStatus(b);
		status.setSetStatus(s);
		status.setDescription(d);
		return status;
	}
}
