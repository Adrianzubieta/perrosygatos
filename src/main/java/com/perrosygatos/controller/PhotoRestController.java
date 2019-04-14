package com.perrosygatos.controller;

import com.perrosygatos.domain.Photo;
import com.perrosygatos.service.PhotoService;
import com.perrosygatos.vo.RequestPhotoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/photos")
@RequiredArgsConstructor
public class PhotoRestController {

    @Value("${com.perrosygatos.s3-bucket-base-url}")
    private String baseUrl;

    private final PhotoService photoService;

    @PostMapping
    public Photo save(@RequestBody RequestPhotoVo requestPhotoVo) throws IOException {
        Photo photoSaved = photoService.save(requestPhotoVo);
        photoSaved.setUrl(baseUrl.concat(photoSaved.getPath()));
        return photoSaved;
    }

}
