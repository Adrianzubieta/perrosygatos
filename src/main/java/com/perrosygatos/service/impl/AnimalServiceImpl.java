package com.perrosygatos.service.impl;

import com.perrosygatos.domain.Animal;
import com.perrosygatos.repository.AnimalRepository;
import com.perrosygatos.service.AnimalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
    public Page<Animal> findAll(Pageable pageable) {
        Assert.notNull(pageable, "The pageable is null");
        return animalRepository.findAll(pageable);
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
    public List<Animal> filterByCity(Long cityId) {
        List<Animal> animals = animalRepository.findAllByCity_Id(cityId);
        log.debug("Response [filterByCity]: {}", animals);
        return animals;
    }

    @Override
    public List<Animal> filterByCityAndKind(Long cityId, Long kindId) {
        List<Animal> animals = filterByCity(cityId).stream()
                .filter(animal -> animal.getKind().getId().equals(kindId)).collect(Collectors.toList());
        log.debug("Response [filterByCityAndKind]: {}", animals);
        return animals;
    }

    @Override
    public List<Animal> filterByCityAndKindAndSize(Long cityId, Long kindId, Long sizeId) {
        List<Animal> animals = filterByCityAndKind(cityId, kindId).stream()
                .filter(animal -> animal.getSize().getId().equals(sizeId)).collect(Collectors.toList());
        log.debug("Response [filterByCityAndKindAndSize]: {}", animals);
        return animals;
    }
}
