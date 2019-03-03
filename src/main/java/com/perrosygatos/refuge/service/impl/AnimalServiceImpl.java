package com.perrosygatos.refuge.service.impl;

import com.perrosygatos.refuge.domain.Animal;
import com.perrosygatos.refuge.repository.AnimalRepository;
import com.perrosygatos.refuge.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;
    private final ModelMapper modelMapper;

    @Override
    public Animal findById(Long id) {
        Assert.notNull(id, "The id is null");
        return animalRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Animal save(Animal animal) {
        Assert.notNull(animal, "The animal is null");
        Assert.notNull(animal.getKind(), "The kind is null");
        return animalRepository.save(animal);
    }

    @Override
    public Animal update(Animal animal) {
        Assert.notNull(animal, "The animal is null");
        Animal animalToUpdate = findById(animal.getId());
        modelMapper.map(animal, animalToUpdate);
        return animalToUpdate;
    }
}
