/*
     Name        :  Movi Type api
     Author Name : Ean Dalin
     Date        : 07-10-2019
 */

package com.spring.movi.api;

import com.spring.movi.constants.Status;
import com.spring.movi.dto.MoviTypeDTO;
import com.spring.movi.dto.ReturnStatus;
import com.spring.movi.services.servicesImp.MoviTypeImp;
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
@RequestMapping(value = "/@m!n/api/movitype")
public class MoviTypeRescontroller {

    private static final Logger log = LoggerFactory.getLogger(MoviTypeRescontroller.class);

    @Autowired
    private MoviTypeImp moviTypeImp;

    @GetMapping(value = "/getmovitypelist")
    public List<MoviTypeDTO> getMoviTypeList(){
        List<MoviTypeDTO> list = null;
        try {
            list = moviTypeImp.getListMoviType(Status.Active.getValueInt());
        }catch (Exception e){
            log.error("\n @m!n api movi type get movi type list",e.getMessage());
            e.printStackTrace();
        }
        return  list;
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<ReturnStatus> delete(@RequestParam("id") int id){
        ReturnStatus returnStatus = new ReturnStatus();
        try{
            MoviTypeDTO moviTypeDTO = new MoviTypeDTO();
            moviTypeDTO.setId(id);
            moviTypeDTO.setStatus( Status.Delete.getValueInt() );

           Long delete = moviTypeImp.delete(moviTypeDTO);
           returnStatus = SetStatusReturn.setStatus(false,"NDelete","Can not delete movi type id:"+id);
           if (delete > 0 ) {
             returnStatus = SetStatusReturn.setStatus(true,"YDeleted","movi type deleted");
           }
        }catch (Exception e){
            log.error("\n @m!n api movi type delete", e.getMessage());
            e.printStackTrace();
        }
        return  new ResponseEntity<>(returnStatus, HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ReturnStatus> save(@RequestBody MoviTypeDTO moviTypeDTO){
        ReturnStatus returnStatus = new ReturnStatus();
        try {

            moviTypeDTO.setCreateDate(SystemDateUtil.getDateYyyyMdDd());
            moviTypeDTO.setCreateBy("log in not yet");
            moviTypeDTO.setModifyDate(SystemDateUtil.getDateYyyyMdDd());
            moviTypeDTO.setModifyBy("log in yet");
            moviTypeDTO.setStatus(Status.Active.getValueInt());

            Long save = moviTypeImp.save(moviTypeDTO);
            returnStatus = SetStatusReturn.setStatus(false, "NSaved", "Can not save movi type");
            if (save > 0){
                returnStatus = SetStatusReturn.setStatus(true, "YSaved", "Movi type saved");
                return  new ResponseEntity<>(returnStatus, HttpStatus.OK);
            }

        }catch (Exception e){
            log.error("\n movi type api save", e.getMessage());
            e.printStackTrace();
        }
        return  new ResponseEntity<>(returnStatus, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<ReturnStatus> update (@RequestBody MoviTypeDTO moviTypeDTO) {
        ReturnStatus returnStatus = new ReturnStatus();
        try {

            moviTypeDTO.setModifyBy("Update not log in");
            moviTypeDTO.setModifyDate(SystemDateUtil.getDateYyyyMdDd());

            Long update = moviTypeImp.update(moviTypeDTO);
            returnStatus = SetStatusReturn.setStatus(false, "NUpdate", "Can not update movi type id :" + moviTypeDTO.getId() );
            if (update > 0 ){
                returnStatus = SetStatusReturn.setStatus(true, "YUpdated", "Movi Type updated" );
                return  new ResponseEntity<>(returnStatus, HttpStatus.OK);
            }

        }catch (Exception e){
            log.error("\n @m!n movi type update", e.getMessage());
            e.printStackTrace();
        }
        return  new ResponseEntity<>(returnStatus, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/getvaluebyid")
    public MoviTypeDTO getValueById(@RequestParam("id") int id){
        MoviTypeDTO moviTypeDTO = new MoviTypeDTO();
        try {
            moviTypeDTO = moviTypeImp.getValueById(id);
        }catch (Exception e){
            log.error("\n @m!n api movi type get value by id: "+id, e.getMessage());
            e.printStackTrace();
        }
        return moviTypeDTO;
    }
}
