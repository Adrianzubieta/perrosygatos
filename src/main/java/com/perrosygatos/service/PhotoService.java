package com.perrosygatos.service;

import com.perrosygatos.domain.Photo;

import java.io.IOException;

public interface PhotoService {

    Photo save(Photo photo) throws IOException;

}
