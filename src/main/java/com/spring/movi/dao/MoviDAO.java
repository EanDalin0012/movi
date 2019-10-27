package com.spring.movi.dao;

import com.spring.movi.dto.ImagesDTO;
import com.spring.movi.dto.MoviDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MoviDAO {
    List<MoviDTO> getListMovi(int status);
    Long save(MoviDTO moviDTO);
    Long delete(MoviDTO moviDTO);
    MoviDTO getValueById(int id);
    Long update(MoviDTO moviDTO);
    int count();
    int checkUniqueName(MoviDTO moviDTO);
}
