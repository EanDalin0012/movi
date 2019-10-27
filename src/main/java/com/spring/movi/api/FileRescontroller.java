package com.spring.movi.api;


import com.spring.movi.constants.Status;
import com.spring.movi.dto.FileResponse;
import com.spring.movi.dto.ImagesDTO;
import com.spring.movi.dto.ReturnStatus;
import com.spring.movi.services.servicesImp.FileSystemStorageService;
import com.spring.movi.services.servicesImp.ImageServiceImp;
import com.spring.movi.utils.SetStatusReturn;
import com.spring.movi.utils.SystemDateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/upload")
public class FileRescontroller {

    private static final Logger log = LoggerFactory.getLogger(RoleRescontroller.class);

    @Autowired
    private ImageServiceImp imageServiceImp;

    private FileSystemStorageService storageService;

    String loginName = "Not yet api login";
    public FileRescontroller(FileSystemStorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String listAllFiles(Model model) {

        model.addAttribute("files", storageService.loadAll().map(
                path -> ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/download/")
                        .path(path.getFileName().toString())
                        .toUriString())
                .collect(Collectors.toList()));

        return "listFiles";
    }

    @GetMapping("/download/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {

        Resource resource = storageService.loadAsResource(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping("/upload-file")
    @ResponseBody
    public FileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String name = "";
        String uri = "";
        try{
            System.out.println("Test" + storageService.store(file));
            name = storageService.store(file);
            uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/upload/download/")
                    .path(name)
                    .toUriString();
            System.out.println("uri= " + uri);

        }catch (Exception e) {
            log.error("\n api/upload/upload-file", e.getCause());
            e.printStackTrace();
        }

        return new FileResponse(name, uri, file.getContentType(), file.getSize());
    }

    @PostMapping("/upload-multiple-files")
    @ResponseBody
    public List<FileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.stream(files)
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/file-upload")
    public  ResponseEntity<ImagesDTO> fileUpload(@RequestParam("file") MultipartFile file){
        ReturnStatus returnStatus = new ReturnStatus();
        ImagesDTO imagesDTO = new ImagesDTO();
        try{
            String  name = storageService.store(file);
            String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/upload/download/")
                    .path(name)
                    .toUriString();

//            List<ImagesDTO> list = imageServiceImp.getListImages();
            int count = imageServiceImp.count();
            int id = ++count;


            imagesDTO.setId(id);
            imagesDTO.setCreateBy(loginName);
            imagesDTO.setCreateDate(SystemDateUtil.getDateYyyyMdDd());
            imagesDTO.setModifyBy(loginName);
            imagesDTO.setModifyDate(SystemDateUtil.getDateYyyyMdDd());
            imagesDTO.setStatus(Status.Active.getValueInt());
            imagesDTO.setUri(uri);
            imagesDTO.setName(name);
            imagesDTO.setSize(file.getSize());
            imagesDTO.setType( file.getContentType() );

            System.out.println(imagesDTO.toString());


            Long save = imageServiceImp.save(imagesDTO);
            returnStatus = SetStatusReturn.setStatus(false,"NSaved","File upload successfully");
            if (save > 0 ){
                returnStatus = SetStatusReturn.setStatus(true,"YSaved","File upload successfully");
                return  new ResponseEntity<>(imagesDTO, HttpStatus.OK);
            }

        }catch (Exception e) {
            log.error("\n api/uploadfile/file-upload", e.getMessage());
            e.printStackTrace();
        }
        return  new ResponseEntity<>(imagesDTO, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/getlistimg")
    public List<ImagesDTO> getlistImage(){
        List<ImagesDTO> list = null;
        try{
            list = imageServiceImp.getListImages(Status.Active.getValueInt());
        }catch (Exception e) {
            log.error("", e.getMessage());
        }
        return  list;
    }
}
