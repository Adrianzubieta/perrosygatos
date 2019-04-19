package com.perrosygatos.service;

import com.perrosygatos.domain.Animal;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnimalService {

    Animal findById(Long id);

    Animal save(Animal animal);

    Animal update(Animal animal);

    void delete(Long id);

    Page<Animal> findAll(Predicate predicate, Pageable pageable);

}
