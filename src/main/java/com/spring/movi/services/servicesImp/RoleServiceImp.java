package com.spring.movi.services.servicesImp;


import com.spring.movi.dao.RoleDAO;
import com.spring.movi.dto.RolesDTO;
import com.spring.movi.services.RoleSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleSerivice {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public List<RolesDTO> getListRole(int status) {
        return roleDAO.getListRole(status);
    }

    @Override
    public Long save(RolesDTO rolesDTO) {
        return roleDAO.save(rolesDTO);
    }

    @Override
    public Long delete(RolesDTO rolesDTO) {
        return roleDAO.delete(rolesDTO);
    }

    @Override
    public RolesDTO getValueById(int id) {
        return roleDAO.getValueById(id);
    }

    @Override
    public Long update(RolesDTO rolesDTO) {
        return roleDAO.update(rolesDTO);
    }
}
