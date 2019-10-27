package com.spring.movi.dto;

import java.util.List;

public class MoviDetailsDTO extends NoteDate{

	private int id;
	private String title;
	private String moviTypeName;
	private String typeName;
	private int order;
	private String description;
	private List<ImagesDTO> imagesDTO;

	public MoviDetailsDTO(int status, String createDate, String createBy, String modifyDate, String modifyBy, int id, String title, String moviTypeName, String typeName, int order, String description, List<ImagesDTO> imagesDTO) {
		super(status, createDate, createBy, modifyDate, modifyBy);
		this.id = id;
		this.title = title;
		this.moviTypeName = moviTypeName;
		this.typeName = typeName;
		this.order = order;
		this.description = description;
		this.imagesDTO = imagesDTO;
	}

	public MoviDetailsDTO(int id, String title, String moviTypeName, String typeName, int order, String description, List<ImagesDTO> imagesDTO) {
		this.id = id;
		this.title = title;
		this.moviTypeName = moviTypeName;
		this.typeName = typeName;
		this.order = order;
		this.description = description;
		this.imagesDTO = imagesDTO;
	}

	public MoviDetailsDTO(){
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

	public String getMoviTypeName() {
		return moviTypeName;
	}

	public void setMoviTypeName(String moviTypeName) {
		this.moviTypeName = moviTypeName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
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
		return "MoviDetailsDTO{" +
				"id=" + id +
				", title='" + title + '\'' +
				", moviTypeName=" + moviTypeName +
				", typeName=" + typeName +
				", order=" + order +
				", description='" + description + '\'' +
				", imagesDTO=" + imagesDTO +
				'}';
	}
}
