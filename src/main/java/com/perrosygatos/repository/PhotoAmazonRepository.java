package com.perrosygatos.repository;

import java.io.InputStream;

public interface PhotoAmazonRepository {

    void saveInS3(String filename, InputStream inputStream);

}
