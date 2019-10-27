package com.spring.movi.dto;

public class MoviImageDTO {
    private  int moviId;
    private  int imageId;
    private  int status;

    public MoviImageDTO(int moviId, int imageId, int status) {
        this.moviId  = moviId;
        this.imageId = imageId;
        this.status  = status;
    }

    public MoviImageDTO() {
    }

    public int getMoviId() {
        return moviId;
    }

    public void setMoviId(int moviId) {
        this.moviId = moviId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MoviImageDTO{" +
                "moviId=    "  + moviId +
                ", imageId= "  + imageId +
                ", status=  "  + status+
                '}';
    }
}

