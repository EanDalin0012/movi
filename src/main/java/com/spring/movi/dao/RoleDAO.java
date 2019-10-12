package com.spring.movi.dao;

import com.spring.movi.dto.MoviTypeDTO;
import com.spring.movi.dto.RolesDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleDAO {
    List<RolesDTO> getListRole(int status);
    Long save(RolesDTO rolesDTO);
    Long delete(RolesDTO rolesDTO);
    RolesDTO getValueById(int id);
    Long update(RolesDTO rolesDTO);
}
