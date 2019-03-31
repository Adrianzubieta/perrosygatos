package com.perrosygatos.service;

import com.perrosygatos.domain.Animal;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnimalService {

    Animal findById(Long id);

    Animal save(Animal animal);

    Animal update(Animal animal);

    Page<Animal> findAll(Pageable pageable);

    void delete(Long id);

    Page<Animal> filter(Predicate predicate, Pageable pageable);

//    List<Animal> filterByCity(Long cityId);
//
//    List<Animal> filterByCityAndKind(Long cityId, Long kindId);
//
//    List<Animal> filterByCityAndKindAndSize(Long cityId, Long kindId, Long sizeId);
}
