package com.softtek.PruebaImagenes.controlador;

import com.softtek.PruebaImagenes.modelo.Image;
import com.softtek.PruebaImagenes.servicio.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/images")
@CrossOrigin(origins="http://localhost:4200")
public class ImageController {

    @Autowired
    private ImageService serviceImagen;


    @PostMapping(value = "/subirImagen", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Integer> guardarImagen(@RequestParam("adjunto") MultipartFile file) throws Exception{
        int rpta = 0;
        Image img = new Image();
        img.setType(file.getContentType());
        img.setName(file.getOriginalFilename());
        img.setData(file.getBytes());
        rpta = serviceImagen.guardar(img);
        return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
    }

    @GetMapping(value = "/leerImagen/{idImagen}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> leerImagen(@PathVariable("idImagen") Integer idArchivo) throws IOException {
        byte[] arr = serviceImagen.leerArchivo(idArchivo);
        return new ResponseEntity<>(arr, HttpStatus.OK);
    }

}
