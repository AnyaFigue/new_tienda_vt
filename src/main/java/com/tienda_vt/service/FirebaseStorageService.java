package com.tienda_vt.service;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);// recibe un archivo local del cliente y lo ubica en una carpeta en firebase y le pone un id

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName ="tecshop-vt.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage ="tecshop";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile ="firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile ="tecshop-vt-firebase-adminsdk-nxghf-152a4b79bb.json";
}
