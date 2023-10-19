package com.proyecto.ecommerce.springecommerce.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//Clase para manejo de imágenes
@Service
public class UploadFileService {
    private String folder="images//"; //ubicacion- ruta de la imagen

    public String saveImage(MultipartFile file) throws IOException{
        if(file.isEmpty()){
            byte [] bytes=file.getBytes();
            Path path= Paths.get(folder + file.getOriginalFilename());
            Files.write(path,bytes); //envio de ruta y bytes
            return file.getOriginalFilename(); //retornar nombre de la imagen y guardar en bd
        }
        return "default.jpg"; //en caso de no seleccionar imagen, se guarda una por defecto
    }

    public void deleteImage(String nombre){
        String ruta="images//";
        File file = new File(ruta+ nombre);
        file.delete();          
    }
}
