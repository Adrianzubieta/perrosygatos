package com.perrosygatos.service;

import com.perrosygatos.domain.Kind;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KindService {

    Kind findById(Long id);

    Page<Kind> findAll(Pageable pageable);

    Kind save(Kind kindToSave);

    Kind update(Kind kindToUpdate);

}
