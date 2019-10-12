/*
     Name        : Type api
     Author Name : Ean Dalin
     Date        : 06-10-2019
 */
package com.spring.movi.api;

import java.util.List;

import com.spring.movi.constants.Status;
import com.spring.movi.dto.ReturnStatus;
import com.spring.movi.utils.SystemDateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.movi.dao.TypeDAO;
import com.spring.movi.dto.TypeDTO;

@RestController
@RequestMapping(value = "/@m!n/api/type")
public class TypeRecontroller {

	private static final Logger log = LoggerFactory.getLogger(TypeRecontroller.class);
	
	@Autowired
	TypeDAO typeDAO;
	
	@GetMapping(value = "/getlist")
	public List<TypeDTO> getList(){
		List<TypeDTO> list = null;
		try {
			list = typeDAO.getListType(Status.Active.getValueInt());
		}catch (Exception e) {
			log.error("/@m!n/type getList()", e);
		}
		return list;
	}

	@PostMapping(value = "/save")
	public ResponseEntity<ReturnStatus> save(@RequestBody TypeDTO typeDTO){
		ReturnStatus returnStatus = new ReturnStatus();
		try {
			typeDTO.setCreateDate( SystemDateUtil.getDateYyyyMdDd() );
			typeDTO.setCreateBy("login not yet");
			typeDTO.setModifyDate( SystemDateUtil.getDateYyyyMdDd() );
			typeDTO.setModifyBy("login not yet");
			typeDTO.setStatus( Status.Active.getValueInt() );

			Long add = typeDAO.save(typeDTO);
			if(add > 0) {
				returnStatus = set(true, "YInserted", "Movie type inserted");
				return new ResponseEntity<>( returnStatus ,HttpStatus.OK);
			}

		}catch (Exception e) {
			log.error("\n /@m!n/movitype save()", e.getMessage());
			returnStatus = set(false, "NInsert", "Can not insert movie type"+e.getMessage());
			new ResponseEntity<>( returnStatus ,HttpStatus.NOT_FOUND);
			throw  e;
		}

		return new ResponseEntity<>( returnStatus ,HttpStatus.OK);
	}

	@GetMapping(value = "/getvaluebyid")
	public  TypeDTO getValueById(@RequestParam("id") int id){
		TypeDTO typeDTO = new  TypeDTO();
		try {
            typeDTO = typeDAO.getValueById(id);
        }catch (Exception e){
		    log.error("\n /@m!n/type getvaluebyid()", e.getMessage());
		    throw  e;
        }
		return typeDTO;
	}

    @PostMapping(value = "/update")
	public ResponseEntity<ReturnStatus> update(@RequestBody TypeDTO typeDTO){
        ReturnStatus returnStatus = new ReturnStatus();
        try {
            typeDTO.setModifyDate(SystemDateUtil.getDateYyyyMdDd());
            typeDTO.setModifyBy("log not yet");
            Long update = typeDAO.update(typeDTO);

            returnStatus = set(false, "NUpdated", "Movie type can not update");
            if (update > 0 ) {
                returnStatus = set(true, "YUpdated", "Movie type updated");
                return new ResponseEntity<>( returnStatus ,HttpStatus.OK);
            }
        }catch (Exception e){
            log.error("\n @m!n api type upadte()", e.getMessage());
            returnStatus = set(true, "error", e.getMessage());
            return  new ResponseEntity<>(returnStatus,HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(returnStatus,HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<ReturnStatus> delete(@RequestParam("id") int id){
        ReturnStatus returnStatus = new ReturnStatus();
        try {
            TypeDTO typeDTO = new TypeDTO();
            typeDTO.setId(id);
            typeDTO.setStatus(Status.Delete.getValueInt());
            Long update = typeDAO.delete(typeDTO);

            returnStatus = set(false, "NUpdated", "Movie type can not delete");
            if (update > 0 ) {
                returnStatus = set(true, "YDeleted", "Movie type deleted");
                new ResponseEntity<>( returnStatus ,HttpStatus.OK);
            }
        }catch (Exception e){
            log.error("\n @m!n api type delete()", e.getMessage());
            returnStatus = set(true, "error", e.getMessage());
            return  new ResponseEntity<>(returnStatus,HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(returnStatus,HttpStatus.OK);
    }

    private ReturnStatus set(boolean b, String s, String d) {
		ReturnStatus status;
		status = new ReturnStatus();
		status.setStatus(b);
		status.setSetStatus(s);
		status.setDescription(d);
		return status;
	}
}
