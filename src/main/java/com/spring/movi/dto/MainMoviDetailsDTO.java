package com.spring.movi.dto;

public class MainMoviDetailsDTO {
	private int id;
	private String title;
	private String urlImage;
	private int moviTypeId;
	private int typeId;
	private String description;
	private String createDate;
	private String createBy;
	private String modifyBy;
	private String modifyDate;
	private String imgName;
	private String moviName;
	private String typeName;
	
	public MainMoviDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MainMoviDetailsDTO(int id, String title, String urlImage, int moviTypeId, int typeId, String description,
			String createDate, String createBy, String modifyBy, String modifyDate, String imgName, String moviName,
			String typeName) {
		super();
		this.id = id;
		this.title = title;
		this.urlImage = urlImage;
		this.moviTypeId = moviTypeId;
		this.typeId = typeId;
		this.description = description;
		this.createDate = createDate;
		this.createBy = createBy;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.imgName = imgName;
		this.moviName = moviName;
		this.typeName = typeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public int getMoviTypeId() {
		return moviTypeId;
	}

	public void setMoviTypeId(int moviTypeId) {
		this.moviTypeId = moviTypeId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
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

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getMoviName() {
		return moviName;
	}

	public void setMoviName(String moviName) {
		this.moviName = moviName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "MainMoviDetailsDTO [id=" + id + ", title=" + title + ", urlImage=" + urlImage + ", moviTypeId="
				+ moviTypeId + ", typeId=" + typeId + ", description=" + description + ", createDate=" + createDate
				+ ", createBy=" + createBy + ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate + ", imgName="
				+ imgName + ", moviName=" + moviName + ", typeName=" + typeName + "]";
	}
	
	
}