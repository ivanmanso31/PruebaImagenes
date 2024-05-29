package com.softtek.PruebaImagenes.repositorio;

import com.softtek.PruebaImagenes.modelo.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
