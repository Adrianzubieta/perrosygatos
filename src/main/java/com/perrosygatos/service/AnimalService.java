package com.perrosygatos.service;

import com.perrosygatos.domain.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnimalService {

    Animal findById(Long id);

    Animal save(Animal animal);

    Animal update(Animal animal);

    Page<Animal> findAll(Pageable pageable);
}
