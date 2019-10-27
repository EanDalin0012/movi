package com.spring.movi.services;

import com.spring.movi.dto.MoviDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MoviService {
    List<MoviDTO> getListMovi(int status);
    Long save(MoviDTO moviDTO);
    Long delete(MoviDTO moviDTO);
    MoviDTO getValueById(int id);
    Long update(MoviDTO moviDTO);
    int count();
    int checkUniqueName(MoviDTO moviDTO);
}
