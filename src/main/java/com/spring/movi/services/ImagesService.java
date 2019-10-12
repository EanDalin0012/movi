package com.spring.movi.services;

import com.spring.movi.dto.ImagesDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagesService {
    List<ImagesDTO> getListImages(int status);
    Long save(ImagesDTO imagesDTO);
    Long delete(ImagesDTO imagesDTO);
    ImagesDTO getValueById(int id);
    Long update(ImagesDTO imagesDTO);
}
