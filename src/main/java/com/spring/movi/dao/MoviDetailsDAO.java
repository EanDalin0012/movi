package com.spring.movi.dao;

import com.spring.movi.dto.MoviDTO;
import com.spring.movi.dto.MoviDetailsDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MoviDetailsDAO {
    List<MoviDetailsDTO> getListMovi(int status);
}
