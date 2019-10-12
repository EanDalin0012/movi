package com.spring.movi.api;

import com.spring.movi.constants.Status;
import com.spring.movi.dto.ImagesDTO;
import com.spring.movi.dto.ReturnStatus;
import com.spring.movi.services.servicesImp.ImageServiceImp;
import com.spring.movi.utils.SetStatusReturn;
import com.spring.movi.utils.SystemDateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/@m!n/api/images")
public class ImageRescontroller {
    private static final Logger log = LoggerFactory.getLogger(MoviTypeRescontroller.class);

    @Autowired
    private ImageServiceImp imageServiceImp;
    String name = "log bot yet";
    @GetMapping(value = "/getlistimage")
    public List<ImagesDTO> getListImage(){
        List<ImagesDTO> list = null;
        try {
            list = imageServiceImp.getListImages(Status.Active.getValueInt());
        }catch (Exception e) {
            log.error("\n @m!n api images get list images",e.getMessage());
            e.printStackTrace();
        }
        return  list;
    }

    @GetMapping(value = "/getvaluebyid")
    public ImagesDTO getValueById(@RequestParam("id") int id){
        ImagesDTO imagesDTO = new ImagesDTO();
        try {
            imagesDTO = imageServiceImp.getValueById(id);
        }catch (Exception e) {
            log.error("\n @m!n api image get value by id",e.getMessage());
        }
        return  imagesDTO;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ReturnStatus> save(@RequestBody ImagesDTO imagesDTO){
        ReturnStatus returnStatus = new ReturnStatus();
        try {

            imagesDTO.setCreateBy(name);
            imagesDTO.setCreateDate(SystemDateUtil.getDateYyyyMdDd());
            imagesDTO.setModifyBy(name);
            imagesDTO.setModifyDate(SystemDateUtil.getDateYyyyMdDd());
            imagesDTO.setStatus(Status.Active.getValueInt());

            Long save = imageServiceImp.save(imagesDTO);
            returnStatus = SetStatusReturn.setStatus(false,"NSave","Can not Save");
            if (save > 0) {
                returnStatus = SetStatusReturn.setStatus(true, "YSaved", "Image Saved");
                return  new ResponseEntity<>(returnStatus, HttpStatus.OK);
            }
        }catch ( Exception e) {
            log.error("\n @m!n api image save", e.getMessage());
            e.printStackTrace();
        }
        return  new ResponseEntity<>(returnStatus, HttpStatus.NOT_FOUND);
    }
}
