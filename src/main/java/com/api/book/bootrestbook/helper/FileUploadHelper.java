package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    // public final String UPLOAD_DIR = "/Users/ishusingh/vscode_springboot/bootrestbook/src/main/resources/static/images";
    public final String UPLOAD_DIR =new ClassPathResource("static/images/").getFile().getAbsolutePath();


    public FileUploadHelper()throws IOException {
    }


    public boolean uploaded(MultipartFile file) {
        boolean f = false;
        try {

            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

}
