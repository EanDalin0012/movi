package com.spring.movi.services;

import com.spring.movi.dto.RolesDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleSerivice {
    List<RolesDTO> getListRole(int status);
    Long save(RolesDTO rolesDTO);
    Long delete(RolesDTO rolesDTO);
    RolesDTO getValueById(int id);
    Long update(RolesDTO rolesDTO);
}
