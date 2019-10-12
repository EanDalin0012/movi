package com.spring.movi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.movi.dto.TypeDTO;

@Mapper
public interface TypeDAO {
	List<TypeDTO> getListType(int status);
	Long save(TypeDTO typeDTO);
	Long delete(TypeDTO typeDTO);
	TypeDTO getValueById(int id);
	Long update(TypeDTO typeDTO);
}
