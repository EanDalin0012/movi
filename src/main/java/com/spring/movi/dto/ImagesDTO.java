package com.spring.movi.dto;
public class ImagesDTO {

	private int id;
	private String name;
	private String uri;
	private int status;
	private Long size;
	private String type;
	private String description;
	private String createDate;
	private String createBy;
	private String modifyDate;
	private String modifyBy;

	public ImagesDTO(int id, String name, String uri, int status, Long size, String type, String description, String createDate, String createBy, String modifyDate, String modifyBy) {
		this.id = id;
		this.name = name;
		this.uri = uri;
		this.status = status;
		this.size = size;
		this.type = type;
		this.description = description;
		this.createDate = createDate;
		this.createBy = createBy;
		this.modifyDate = modifyDate;
		this.modifyBy = modifyBy;
	}

	public ImagesDTO() {
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

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "ImagesDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", uri='" + uri + '\'' +
				", status=" + status +
				", size=" + size +
				", type='" + type + '\'' +
				", description='" + description + '\'' +
				", createDate='" + createDate + '\'' +
				", createBy='" + createBy + '\'' +
				", modifyDate='" + modifyDate + '\'' +
				", modifyBy='" + modifyBy + '\'' +
				'}';
	}
}
