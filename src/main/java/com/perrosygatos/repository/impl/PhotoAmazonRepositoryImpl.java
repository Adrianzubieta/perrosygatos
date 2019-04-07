package com.perrosygatos.repository.impl;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.perrosygatos.repository.PhotoAmazonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.InputStream;

@Repository
@RequiredArgsConstructor
public class PhotoAmazonRepositoryImpl implements PhotoAmazonRepository {

    @Value("${com.perrosygatos.s3-bucket-name}")
    private String bucketName;

    private final AmazonS3Client amazonS3Client;

    @Override
    public void saveInS3(String filename, InputStream inputStream) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType("image/jpeg");
        amazonS3Client.putObject(bucketName, filename, inputStream, objectMetadata);
    }
}
