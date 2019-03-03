package com.perrosygatos.refuge.service;

import com.perrosygatos.refuge.domain.Kind;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KindService {

    Kind findById(Long id);

    Page<Kind> findAll(Pageable pageable);

    Kind save(Kind kindToSave);

    Kind update(Kind kindToUpdate);

}
