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
        return animalService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Animal save(@RequestBody Animal animal) {
        return animalService.save(animal);
    }

    @PatchMapping
    public Animal update(@RequestBody Animal animal) {
        return animalService.update(animal);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        animalService.delete(id);
    }

    @GetMapping
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    Page<Animal> findAll(@QuerydslPredicate(root = Animal.class) Predicate predicate, Pageable pageable) {
        return animalService.filter(predicate, pageable);
    }


}
