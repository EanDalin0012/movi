package com.spring.movi.dao;

import com.spring.movi.dto.MoviTypeDTO;
import com.spring.movi.dto.TypeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MoviTypeDAO {
    List<MoviTypeDTO> getListMoviType(int status);
    Long save(MoviTypeDTO moviTypeDTO);
    Long delete(MoviTypeDTO moviTypeDTO);
    MoviTypeDTO getValueById(int id);
    Long update(MoviTypeDTO moviTypeDTO);
}
