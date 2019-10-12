package com.spring.movi.services;

import com.spring.movi.dto.MoviTypeDTO;
import com.spring.movi.dto.TypeDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MoviTypeService {
    List<MoviTypeDTO> getListMoviType(int status);
    Long save(MoviTypeDTO moviTypeDTO);
    Long delete(MoviTypeDTO moviTypeDTO);
    MoviTypeDTO getValueById(int id);
    Long update(MoviTypeDTO moviTypeDTO);
}
