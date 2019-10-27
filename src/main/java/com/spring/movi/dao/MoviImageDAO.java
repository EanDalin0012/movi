package com.spring.movi.dao;

import com.spring.movi.dto.MoviImageDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MoviImageDAO {
    Long save(MoviImageDTO moviImageDTO);
    Long update(MoviImageDTO moviImageDTO);
}
