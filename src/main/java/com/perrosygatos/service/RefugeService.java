package com.perrosygatos.service;

import com.perrosygatos.domain.Refuge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RefugeService {

    Refuge save(Refuge refuge);

    Refuge findById(Long id);

    Refuge update(Refuge refugeToUpdate);

    Page<Refuge> findAll(Pageable pageable);

}
