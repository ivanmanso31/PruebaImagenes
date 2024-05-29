package com.softtek.PruebaImagenes.servicio;

import com.softtek.PruebaImagenes.modelo.Image;
import com.softtek.PruebaImagenes.repositorio.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService implements IImageService{

    @Autowired
    private ImageRepository repo;

    @Override
    public int guardar(Image imagen) {
        Image img = repo.save(imagen);
        return img.getId() > 0 ? 1 : 0;
    }

    @Override
    public byte[] leerArchivo(Integer idImagen) {
        Optional<Image> op = repo.findById(idImagen);
        return op.isPresent() ? op.get().getData() : new byte[0];
    }


    /*@Autowired
    private ImageRepository imageRepository;

    public Image saveImage(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getOriginalFilename());
        System.out.println("nombre"+image.getName());
        image.setType(file.getContentType());
        System.out.println("tipo"+image.getType());
        image.setData(file.getBytes());
        System.out.println("datos" + Arrays.toString(image.getData()));
        String base64EncodedData = Base64.getEncoder().encodeToString(image.getData());
        System.out.println("datos Base64: " + base64EncodedData);

        return imageRepository.save(image);
    }

    public Optional<Image> getImage(Long id) {
        return imageRepository.findById(id);
    }

    // Método para obtener todas las imágenes
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }*/
}
