package com.perrosygatos.service;

import com.perrosygatos.domain.Photo;
import com.perrosygatos.vo.RequestPhotoVo;

import java.io.IOException;

public interface PhotoService {

    Photo save(RequestPhotoVo requestPhotoVo) throws IOException;

}
