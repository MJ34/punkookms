package com.mujidev.punkookms.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadUtil {

    private final String UPLOAD_FOLDER = "C:\\Users\\MSII\\Documents\\project\\punkookms\\src\\main\\resources\\static\\img\\photos\\";

    public boolean uploadImage(MultipartFile imageProduct){
        boolean isUpload = false;
        try {
            Files.copy(imageProduct.getInputStream(),
                    Paths.get(UPLOAD_FOLDER + File.separator, imageProduct.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            isUpload = true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return isUpload;
    }

    public boolean checkExisted(MultipartFile imageProduct){
        boolean isExisted = false;
        try {
            File file = new File(UPLOAD_FOLDER + "\\" + imageProduct.getOriginalFilename());
            isExisted = file.exists();
        }catch (Exception e){
            e.printStackTrace();
        }
        return isExisted;
    }
    
}
