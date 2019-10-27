package com.spring.movi.dto;

import java.util.List;

public class MoviDTO extends NoteDate{

	private int id;
	private String title;
	private int moviTypeId;
	private int typeId;
	private int order;
	private int imageId;
	private String description;
	private List<ImagesDTO> imagesDTO;

	public MoviDTO(int status, String createDate, String createBy, String modifyDate, String modifyBy, int id, String title, int moviTypeId, int typeId, int order, int imageId, String description, List<ImagesDTO> imagesDTO) {
		super(status, createDate, createBy, modifyDate, modifyBy);
		this.id = id;
		this.title = title;
		this.moviTypeId = moviTypeId;
		this.typeId = typeId;
		this.order = order;
		this.imageId = imageId;
		this.description = description;
		this.imagesDTO = imagesDTO;
	}

	public MoviDTO(int id, String title, int moviTypeId, int typeId, int order, int imageId, String description, List<ImagesDTO> imagesDTO) {
		this.id = id;
		this.title = title;
		this.moviTypeId = moviTypeId;
		this.typeId = typeId;
		this.order = order;
		this.imageId = imageId;
		this.description = description;
		this.imagesDTO = imagesDTO;
	}

	public MoviDTO(){
		super();
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

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ImagesDTO> getImagesDTO() {
		return imagesDTO;
	}

	public void setImagesDTO(List<ImagesDTO> imagesDTO) {
		this.imagesDTO = imagesDTO;
	}

	@Override
	public String toString() {
		return "MoviDTO{" +
				"id=" + id +
				", title='" + title + '\'' +
				", moviTypeId=" + moviTypeId +
				", typeId=" + typeId +
				", order=" + order +
				", imageId=" + imageId +
				", description='" + description + '\'' +
				", imagesDTO=" + imagesDTO +
				'}';
	}
}
