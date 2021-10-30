package com.backenwebmail.controller;


import com.backenwebmail.impl.DowloadServiceTool;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cv")
public class DowloadController {

    protected static final Log logger = LogFactory.getLog(DowloadController.class);


    @Autowired
    private DowloadServiceTool DowloadServiceTool;


    private String nameCv = "CV_ALEJANDRO_SUBERO_2021.pdf";
    private String  separador = java.nio.file.FileSystems.getDefault().getSeparator();
    private String paht = System.getProperty("user.dir") + separador+ "lib"+ separador+ nameCv;

    @GetMapping("/download")
    public ResponseEntity<byte[]> getFiles() {
        try {
            logger.info("inicia la respuesta ResponseEntity.ok() ");
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+ nameCv + "\"")
                    .body(DowloadServiceTool.readBytesFromFile(paht));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

}
