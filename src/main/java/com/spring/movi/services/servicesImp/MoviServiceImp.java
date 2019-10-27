package com.spring.movi.services.servicesImp;

import com.spring.movi.dao.MoviDAO;
import com.spring.movi.dto.MoviDTO;
import com.spring.movi.services.MoviService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviServiceImp  implements MoviService {
    @Autowired
    private MoviDAO moviDAO;
    @Override
    public List<MoviDTO> getListMovi(int status) {
        return moviDAO.getListMovi(status);
    }

    @Override
    public Long save(MoviDTO moviDTO) {
        return moviDAO.save(moviDTO);
    }

    @Override
    public Long delete(MoviDTO moviDTO) {
        return moviDAO.delete(moviDTO);
    }

    @Override
    public MoviDTO getValueById(int id) {
        return moviDAO.getValueById(id);
    }

    @Override
    public Long update(MoviDTO moviDTO) {
        return moviDAO.update(moviDTO);
    }

    @Override
    public int count() {
        return moviDAO.count();
    }

    @Override
    public int checkUniqueName(MoviDTO moviDTO) {
        return moviDAO.checkUniqueName(moviDTO);
    }
}
