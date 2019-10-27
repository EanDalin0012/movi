package com.spring.movi.dao;

import com.spring.movi.dto.ImagesDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImageDAO {
    List<ImagesDTO> getListImages(int status);
    Long save(ImagesDTO imagesDTO);
    Long delete(ImagesDTO imagesDTO);
    ImagesDTO getValueById(int id);
    Long update(ImagesDTO imagesDTO);
    int count();
}
