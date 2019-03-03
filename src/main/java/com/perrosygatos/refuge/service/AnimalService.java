package com.perrosygatos.refuge.service;

import com.perrosygatos.refuge.domain.Animal;

public interface AnimalService {

    Animal findById(Long id);

    Animal save(Animal animal);

    Animal update(Animal animal);
}
