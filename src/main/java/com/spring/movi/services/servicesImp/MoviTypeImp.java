package com.spring.movi.services.servicesImp;

import com.spring.movi.dao.MoviTypeDAO;
import com.spring.movi.dto.MoviTypeDTO;
import com.spring.movi.dto.TypeDTO;
import com.spring.movi.services.MoviTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MoviTypeImp implements MoviTypeService {
    @Autowired
    private MoviTypeDAO moviTypeDAO;

    @Override
    public List<MoviTypeDTO> getListMoviType(int status) {
        return moviTypeDAO.getListMoviType(status);
    }

    @Override
    public Long save(MoviTypeDTO moviTypeDTO) {
        return moviTypeDAO.save(moviTypeDTO);
    }

    @Override
    public Long delete(MoviTypeDTO moviTypeDTO) {
        return moviTypeDAO.delete(moviTypeDTO);
    }

    @Override
    public MoviTypeDTO getValueById(int id) {
        return moviTypeDAO.getValueById(id);
    }

    @Override
    public Long update(MoviTypeDTO moviTypeDTO) {
        return moviTypeDAO.update(moviTypeDTO);
    }
}
