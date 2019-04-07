package com.perrosygatos.service.impl;

import com.perrosygatos.domain.Animal;
import com.perrosygatos.domain.Photo;
import com.perrosygatos.repository.PhotoAmazonRepository;
import com.perrosygatos.repository.PhotoRepository;
import com.perrosygatos.service.AnimalService;
import com.perrosygatos.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;
    private final PhotoAmazonRepository photoAmazonRepository;
    private final AnimalService animalService;

    @Override
    @Transactional
    public Photo save(Photo photo) throws IOException {
        Assert.notNull(photo.getContentBase64(), "El contenido de la foto no puede estar vacio");
        Assert.notNull(photo.getAnimalId(), "El id del animal no puede estar vacio");
        Animal animal = animalService.findById(photo.getAnimalId());
        photo.setAnimal(animal);
        Photo photoSaved = photoRepository.save(photo);
        saveInAmazonS3(photoSaved);
        return photo;
    }

    private void saveInAmazonS3(Photo photo) throws IOException {
        InputStream byteArrayPhoto = new ByteArrayInputStream(Base64.getDecoder().decode(photo.getContentBase64()));
        photo.setPath(getFilePosition(photo.getId().toString(), byteArrayPhoto));
        photoAmazonRepository.saveInS3(photo.getPath(), byteArrayPhoto);
    }

    private String getFilePosition(String namePhoto, InputStream inputStream) throws IOException {
        return namePhoto + "." + getExtension(inputStream);
    }

    private String getExtension(InputStream inputStream) throws IOException {
        String type = URLConnection.guessContentTypeFromStream(inputStream);
        try {
            return type.split("/")[1];
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("El contentBase64 es invalido.");
        }
    }

}
