package com.perrosygatos.service.impl;

import com.perrosygatos.domain.Photo;
import com.perrosygatos.repository.PhotoRepository;
import com.perrosygatos.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;

    @Override
    public Photo save(Photo photo) {
        return null;
    }

}
