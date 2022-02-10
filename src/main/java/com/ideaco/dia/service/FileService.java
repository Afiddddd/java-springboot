package com.ideaco.dia.service;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@Service
public class FileService {
    private final Path root = Paths.get( "/home/afiddddd/Documents/Uploads");

    public boolean saveFile(MultipartFile file){
        try {
            if(!Files.exists(root)){
                Files.createDirectory(root);
            }
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
