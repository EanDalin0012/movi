package com.spring.movi.services.servicesImp;

import com.spring.movi.dao.TypeDAO;
import com.spring.movi.dto.TypeDTO;
import com.spring.movi.services.TypeSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeSeriviceImp implements TypeSerivice {
    @Autowired
    private TypeDAO typeDAO;
    @Override
    public List<TypeDTO> getListType(int type) {
        return typeDAO.getListType(type);
    }

    @Override
    public Long save(TypeDTO typeDTO) {
        return typeDAO.save(typeDTO);
    }

    @Override
    public TypeDTO getValueById(int id) {
        return typeDAO.getValueById(id);
    }

    @Override
    public Long delete(TypeDTO typeDTO) {
        return typeDAO.delete(typeDTO);
    }

    @Override
    public Long update(TypeDTO typeDTO) {
        return typeDAO.update(typeDTO);
    }
}
