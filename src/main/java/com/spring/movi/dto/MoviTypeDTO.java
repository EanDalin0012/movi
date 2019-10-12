package com.spring.movi.dto;

public class MoviTypeDTO {

	private int id;
	private String name;
	private String description;
	private String createDate;
	private String createBy;
	private String modifyDate;
	private String modifyBy;
	private int status;
	
	public MoviTypeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MoviTypeDTO(int id, String name, String description, String createDate, String createBy,
			String modifyDate, String modifyBy, int status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.createDate = createDate;
		this.createBy = createBy;
		this.modifyDate = modifyDate;
		this.modifyBy = modifyBy;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MoviTypeController [id=" + id + ", name=" + name + ", description=" + description + ", createDate="
				+ createDate + ", createBy=" + createBy + ", modifyDate=" + modifyDate + ", modifyBy=" + modifyBy
				+ ", status=" + status + "]";
	}
	
}
