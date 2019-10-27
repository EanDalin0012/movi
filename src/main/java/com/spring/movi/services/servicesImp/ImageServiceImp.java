package com.spring.movi.services.servicesImp;

import com.spring.movi.dao.ImageDAO;
import com.spring.movi.dto.ImagesDTO;
import com.spring.movi.services.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImp implements ImagesService {
    @Autowired
    private ImageDAO imageDAO;

    @Override
    public int count() {
        return imageDAO.count();
    }

    @Override
    public List<ImagesDTO> getListImages(int status) {
        return imageDAO.getListImages(status);
    }

    @Override
    public Long save(ImagesDTO imagesDTO) {
        return imageDAO.save(imagesDTO);
    }

    @Override
    public Long delete(ImagesDTO imagesDTO) {
        return imageDAO.delete(imagesDTO);
    }

    @Override
    public ImagesDTO getValueById(int id) {
        return imageDAO.getValueById(id);
    }

    @Override
    public Long update(ImagesDTO imagesDTO) {
        return imageDAO.update(imagesDTO);
    }
}

