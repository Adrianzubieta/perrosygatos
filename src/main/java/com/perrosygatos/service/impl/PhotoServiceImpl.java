package com.perrosygatos.service.impl;

import com.perrosygatos.domain.Animal;
import com.perrosygatos.domain.Photo;
import com.perrosygatos.repository.PhotoAmazonRepository;
import com.perrosygatos.repository.PhotoRepository;
import com.perrosygatos.service.AnimalService;
import com.perrosygatos.service.PhotoService;
import com.perrosygatos.vo.RequestPhotoVo;
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
    public Photo save(RequestPhotoVo requestPhotoVo) throws IOException {
        Assert.notNull(requestPhotoVo.getContentBase64(), "El contenido de la foto no puede estar vacio");
        Assert.notNull(requestPhotoVo.getAnimalId(), "El id del animal no puede estar vacio");
        Animal animal = animalService.findById(requestPhotoVo.getAnimalId());
        Photo photoSaved = photoRepository.save(getPhoto());
        photoSaved.setAnimal(animal);
        photoSaved.setName(requestPhotoVo.getName());
        saveInAmazonS3(photoSaved, requestPhotoVo.getContentBase64());
        return photoSaved;
    }

    private void saveInAmazonS3(Photo photo, String contentBase64) throws IOException {
        InputStream byteArrayPhoto = new ByteArrayInputStream(Base64.getDecoder().decode(contentBase64));
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

    private Photo getPhoto(){
        return new Photo();
    }
}
