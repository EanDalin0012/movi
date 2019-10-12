package com.spring.movi.dto;

public class ImagesDTO {

	private int id;
	private String imgName;
	private String urlImg;
	private int status;
	private String createDate;
	private String createBy;
	private String modifyDate;
	private String modifyBy;

	public ImagesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImagesDTO(int id, String imgName, String urlImg, int status, String createDate, String createBy , String modifyDate, String modifyBy) {
		super();
		this.id = id;
		this.imgName = imgName;
		this.urlImg = urlImg;
		this.status = status;
		this.createDate = createDate;
		this.createBy = createBy;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getModifyDate() { return modifyDate;	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModifyBy() { return modifyBy;	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "ImagesDTO [id=" + id + ", imgName=" + imgName + ", urlImg=" + urlImg + ", status=" + status
				+ ", createDate=" + createDate + ", createBy=" + createBy + ", modifyDate=" + modifyDate +
				", modifyBy=" + modifyBy +"]";
	}
	
}
