package com.spring.movi.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.movi.dto.TypeDTO;

@Repository
public interface TypeSerivice {
	List<TypeDTO> getListType(int type);
	Long save(TypeDTO typeDTO);
	Long delete(TypeDTO typeDTO);
	TypeDTO getValueById(int id);
	Long update(TypeDTO typeDTO);
}
