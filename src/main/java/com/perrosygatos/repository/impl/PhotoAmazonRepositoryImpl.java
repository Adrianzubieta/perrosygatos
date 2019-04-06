package com.perrosygatos.repository.impl;

import com.amazonaws.services.s3.AmazonS3Client;
import com.perrosygatos.repository.PhotoAmazonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
@RequiredArgsConstructor
public class PhotoAmazonRepositoryImpl implements PhotoAmazonRepository {

    @Value("${com.perrosygatos.s3-bucket-name}")
    private String bucketName;

    private final AmazonS3Client amazonS3Client;

    @Override
    public void saveInS3(String filename, InputStream inputStream) {

    }
}
