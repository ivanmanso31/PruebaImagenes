package com.softtek.PruebaImagenes.servicio;

import com.softtek.PruebaImagenes.modelo.Image;

public interface IImageService {
    int guardar(Image imagen);
    byte[] leerArchivo(Integer idImagen);

}
