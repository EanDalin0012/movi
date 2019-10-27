package com.spring.movi.api;

import com.spring.movi.constants.Status;
import com.spring.movi.dao.MoviDetailsDAO;
import com.spring.movi.dao.MoviImageDAO;
import com.spring.movi.dto.MoviDTO;
import com.spring.movi.dto.MoviDetailsDTO;
import com.spring.movi.dto.MoviImageDTO;
import com.spring.movi.dto.ReturnStatus;
import com.spring.movi.services.servicesImp.MoviServiceImp;
import com.spring.movi.utils.SetStatusReturn;
import com.spring.movi.utils.SystemDateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/@m!n/api/movi")
public class MoviResController {
    private static final Logger log = LoggerFactory.getLogger(MoviTypeRescontroller.class);

    @Autowired
    private MoviServiceImp moviServiceImp;
    @Autowired
    private MoviImageDAO moviImageDAO;
    @Autowired
    private MoviDetailsDAO moviDetailsDAO;

    String name = "log in yot yet" ;
    int imageId = 0;
    @GetMapping(value = "/getlistmovi")
    public List<MoviDetailsDTO> getListMovi(){
        List<MoviDetailsDTO> list = null;
        try {
            list = moviDetailsDAO.getListMovi(Status.Active.getValueInt());
        }catch (Exception e){
            log.error("\n @m!n api movi get list mov ", e.getMessage());
            e.printStackTrace();
        }
        return  list;
    }

    @PostMapping(value = "save")
    public ResponseEntity<ReturnStatus> save(@RequestBody MoviDTO moviDTO){
        ReturnStatus returnStatus = new ReturnStatus();
        try{
            int count = moviServiceImp.count();
            int id = ++count;
            moviDTO.setId(id);
            moviDTO.setCreateBy(name);
            moviDTO.setCreateDate(SystemDateUtil.getDateYyyyMdDd());
            moviDTO.setModifyBy(name);
            moviDTO.setModifyDate(SystemDateUtil.getDateYyyyMdDd());
            moviDTO.setStatus(Status.Active.getValueInt());

            int checkName = moviServiceImp.checkUniqueName(moviDTO);
            if (checkName > 0 ){
                returnStatus = SetStatusReturn.setStatus(false, "Duplicate", "Your title is duplicate. please change it!");
                return  new ResponseEntity<>(returnStatus, HttpStatus.OK);
            }

            Long save = moviServiceImp.save(moviDTO);
            if ( save > 0 ){
                returnStatus = SetStatusReturn.setStatus(false, "NSave", "Can not save!!");
                MoviImageDTO moviImageDTO = new MoviImageDTO();
                moviImageDTO.setMoviId(id);
                moviImageDTO.setImageId(moviDTO.getImageId());
                moviImageDTO.setStatus(Status.Active.getValueInt());

                Long insert = moviImageDAO.save(moviImageDTO);
                if (insert > 0 ){
                    returnStatus = SetStatusReturn.setStatus(true, "YSaved", "Movie saved");
                    return  new ResponseEntity<>(returnStatus, HttpStatus.OK);
                }

            }
        }catch (Exception e){
            log.error("\n admin api movi save",e.getMessage());
            e.printStackTrace();
        }
        return  new ResponseEntity<>(returnStatus, HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/getvaluebyid")
    public MoviDTO getValueById(@RequestParam("id") int id){
        MoviDTO moviDTO = new MoviDTO();
        try{
            moviDTO = moviServiceImp.getValueById(id);
            imageId = moviDTO.getImageId();
        }catch (Exception e){
            log.error("\n admin api movi get value by id = " + id, e.getMessage());
            e.printStackTrace();
        }
        return moviDTO;
    }

    @PostMapping(value = "update")
    public ResponseEntity<ReturnStatus> update(@RequestBody MoviDTO moviDTO, @RequestParam("newImageId") int newImageId){
        ReturnStatus returnStatus = new ReturnStatus();
        try{
            moviDTO.setModifyDate(SystemDateUtil.getDateYyyyMdDd());
            moviDTO.setModifyBy(name);

            Long save = moviServiceImp.update(moviDTO);
            returnStatus = SetStatusReturn.setStatus(false, "NUpdate", "Can not update movie id="+moviDTO.getId());
            if (save > 0 ) {
                if (newImageId != moviDTO.getImageId() && newImageId != 0) {
                    // update status image to unActive cause use image load new image
                    MoviImageDTO upMoviImageDTO = new MoviImageDTO();
                    upMoviImageDTO.setMoviId(moviDTO.getId());
                    upMoviImageDTO.setImageId(imageId);
                    upMoviImageDTO.setStatus(Status.UnActive.getValueInt());

                    long updateImgMovi = moviImageDAO.update(upMoviImageDTO);
                    // and new image to movie image
                    if (updateImgMovi > 0) {
                        MoviImageDTO insMoviImageDTO = new MoviImageDTO();
                        insMoviImageDTO.setMoviId(moviDTO.getId());
                        insMoviImageDTO.setImageId(newImageId);
                        insMoviImageDTO.setStatus(Status.Active.getValueInt());

                        Long insert = moviImageDAO.save(insMoviImageDTO);
                        System.out.println(insert);

//                        if (insert > 0) {
//                            returnStatus = SetStatusReturn.setStatus(true, "YUpdated", "Movie updated id=" + moviDTO.getId());
//                            return new ResponseEntity<>(returnStatus, HttpStatus.OK);
//                        }
                    }
                }
                returnStatus = SetStatusReturn.setStatus(true, "YUpdated", "Movie updated id=" + moviDTO.getId());
                return new ResponseEntity<>(returnStatus, HttpStatus.OK);

            }
        }catch (Exception e){
            log.error("\n admin api movi update", e.getMessage());
            e.printStackTrace();
        }
        return  new ResponseEntity<>(returnStatus, HttpStatus.NOT_FOUND);
    }
}
