/*
    API     : Roles
    Date    : 09-10-2019
    Author  : Ean Dalin
 */
package com.spring.movi.api;

import com.spring.movi.constants.Status;
import com.spring.movi.dto.ReturnStatus;
import com.spring.movi.dto.RolesDTO;
import com.spring.movi.services.servicesImp.RoleServiceImp;
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
@RequestMapping(value = "/@m!n/api/role")
public class RoleRescontroller {

    private static final Logger log = LoggerFactory.getLogger(RoleRescontroller.class);

    @Autowired
    private RoleServiceImp roleServiceImp;
    String userName = "User not yet";

    @GetMapping(value = "/getlistrole")
    public List<RolesDTO> getListRole(){
        List<RolesDTO> list = null;
        try {
            list = roleServiceImp.getListRole(Status.Active.getValueInt());
        }catch (Exception e){
            log.error("\n role api get list role", e.getMessage());
            e.printStackTrace();
        }
        return  list;
    }

    @GetMapping(value = "/getrolebyid")
    public RolesDTO getValueById(@RequestParam("id") int id){
        RolesDTO rolesDTO = new RolesDTO();
        try {
            rolesDTO = roleServiceImp.getValueById(id);
        }catch (Exception e){
            log.error("\n @m!n api role", e.getMessage());
            e.printStackTrace();
        }
        return  rolesDTO;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ReturnStatus> save(@RequestBody RolesDTO rolesDTO){
        ReturnStatus returnStatus = new ReturnStatus();
        try{

            rolesDTO.setCreateDate(SystemDateUtil.getDateYyyyMdDd());
            rolesDTO.setCreateBy( userName );
            rolesDTO.setModifyDate(SystemDateUtil.getDateYyyyMdDd());
            rolesDTO.setCreateBy( userName );
            rolesDTO.setStatus(Status.Active.getValueInt());

            Long save = roleServiceImp.save(rolesDTO);
            returnStatus = SetStatusReturn.setStatus(false, "NSave", "Can not save role");
            if (save > 0 ){
                returnStatus = SetStatusReturn.setStatus(true, "YSaved", "Role saved");
                return  new ResponseEntity<>(returnStatus, HttpStatus.OK);
            }
        }catch (Exception e) {
            log.error("", e.getMessage());
            e.printStackTrace();
        }
        return  new ResponseEntity<>(returnStatus, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<ReturnStatus> delete(@RequestParam("id") int id) {
        ReturnStatus returnStatus = new ReturnStatus();
        try {
            RolesDTO rolesDTO = new RolesDTO();
            rolesDTO.setId(id);
            rolesDTO.setStatus(Status.Delete.getValueInt());

            Long update = roleServiceImp.update(rolesDTO);
            returnStatus = SetStatusReturn.setStatus(false,"NDelete","Can not delete role");
            if (update > 0 ) {
                returnStatus = SetStatusReturn.setStatus(true, "YDeleted","Role deleted");
                return  new ResponseEntity<>(returnStatus, HttpStatus.OK);
            }
        }catch (Exception e){
            log.error("\n @m!n api role delete", e.getMessage());
            e.printStackTrace();
        }
        return  new ResponseEntity<>(returnStatus, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/update")
    public  ResponseEntity<ReturnStatus> update (@RequestBody RolesDTO rolesDTO) {
        ReturnStatus returnStatus = new ReturnStatus();
        try {
            rolesDTO.setModifyDate(SystemDateUtil.getDateYyyyMdDd());
            rolesDTO.setCreateBy(userName);

            Long update = roleServiceImp.update(rolesDTO);
            returnStatus = SetStatusReturn.setStatus(false,"NUpdate","Can not update role id:"+rolesDTO.getId());
            if (update > 0){
                returnStatus = SetStatusReturn.setStatus(true,"YUpdated","Role updated");
                return  new ResponseEntity<>(returnStatus, HttpStatus.OK);
            }
        }catch (Exception e) {
            log.error("\n @m!n api role update", e.getMessage());
            e.printStackTrace();
        }
        return  new ResponseEntity<>(returnStatus,HttpStatus.NOT_FOUND);
    }
}
