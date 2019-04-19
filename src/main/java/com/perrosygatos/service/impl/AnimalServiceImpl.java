package com.perrosygatos.service.impl;

import com.perrosygatos.domain.Animal;
import com.perrosygatos.repository.AnimalRepository;
import com.perrosygatos.service.AnimalService;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.DslExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
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

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "El id no puede ser vacio");
        try {
            animalRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Page<Animal> findAll(Predicate predicate, Pageable pageable) {
        log.debug("predicate service {}",predicate);
        return animalRepository.findAll(predicate, pageable);
    }

}
