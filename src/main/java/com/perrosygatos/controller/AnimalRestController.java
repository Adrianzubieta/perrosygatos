package com.perrosygatos.controller;

import com.perrosygatos.domain.Animal;
import com.perrosygatos.service.AnimalService;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/animal")
@RequiredArgsConstructor
@Slf4j
public class AnimalRestController {

    private final AnimalService animalService;

    @GetMapping("/{id}")
    public Animal findById(@PathVariable Long id) {
        log.debug("Buscando Animal por Id: {}", id);
        Animal animal = animalService.findById(id);
        log.debug("Devuelvo Animal: {}", animal);
        return animal;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Animal save(@RequestBody Animal animal) {
        Animal animalSaved = animalService.save(animal);
        log.debug("Se guardo Animal: {}", animal);
        return animalSaved;
    }

    @PatchMapping
    public Animal update(@RequestBody Animal animal) {
        return animalService.update(animal);
    }

//    @GetMapping
//    public Page<Animal> findAll(@RequestBody Pageable pageable) {
//        return animalService.findAll(pageable);
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        animalService.delete(id);
    }

    @GetMapping
    Page<Animal> filter(@QuerydslPredicate(root = Animal.class) Predicate predicate, Pageable pageable) {
        return animalService.filter(predicate, pageable);
    }


}
