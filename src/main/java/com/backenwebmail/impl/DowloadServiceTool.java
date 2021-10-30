package com.backenwebmail.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.FileInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.stereotype.Component;


@Component
public class DowloadServiceTool {

    protected static final Log logger = LogFactory.getLog(DowloadServiceTool.class);

    public byte[] readBytesFromFile(String filePaths) {

        String filePath = filePaths;
        FileInputStream fileInputStream = null;
        byte[] bytesArray = null;

        try {
            logger.info("inicia la generacion de byte");
            File file = new File(filePath);
            bytesArray = new byte[(int) file.length()];
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);
            logger.info("finaliza la generacion de byte");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Ourre error inesperado la generacion de byte" + e);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bytesArray;
    }

}
