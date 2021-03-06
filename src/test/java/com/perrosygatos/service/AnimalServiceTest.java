package com.perrosygatos.service;

import com.perrosygatos.BaseTest;
import com.perrosygatos.domain.Animal;
import com.perrosygatos.domain.Kind;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class AnimalServiceTest extends BaseTest {

    @Autowired
    private AnimalService animalService;

    @Test
    public void findById_withIdExisting_returnAnimal() {
        Long id = 1L;

        Animal animal = animalService.findById(id);

        assertThat(animal.getId()).isEqualTo(1L);
        assertThat(animal.getPhotos().size()).isEqualTo(1);
        assertThat(animal.getPhotos().get(0).getPath()).isEqualTo("/1.jpeg");
        assertThat(animal.getName()).isEqualTo("firulais");
        assertThat(animal.getKind().getName()).isEqualTo("Perro");
    }

    @Test(expected = NoSuchElementException.class)
    public void findById_withIdNonExisting_throwNoSuchElementException() {
        Long id = 99L;

        animalService.findById(id);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findById_withIdNull_throwIllegalArgumentException() {
        animalService.findById(null);
    }

    @Test
    public void save_withAnimalValid_returnAnimalSaved() {
        Kind kind = new Kind();
        kind.setId(1L);
        kind.setName("Perro");

        Animal animal = new Animal();
        animal.setKind(kind);
        animal.setName("Jack");
        animal.setAge(1);
        animal.setDescription("description_animal");

        Animal animalSaved = animalService.save(animal);

        assertThat(animalSaved.getId()).isEqualTo(5L);
        assertThat(animalSaved.getName()).isEqualTo("Jack");
        assertThat(animalSaved.getKind().getName()).isEqualTo("Perro");
    }

    @Test(expected = IllegalArgumentException.class)
    public void save_withKindNull_throwIllegalArgumentException() {
        Animal animal = new Animal();
        animal.setName("Jack");
        animal.setAge(1);
        animal.setDescription("description_animal");

        animalService.save(animal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void save_withAnimalNull_throwIllegalArgumentException() {
        animalService.save(null);
    }

    @Test
    public void update_withAnimalValid_returnAnimalUpdated() {
        Kind kind = new Kind();
        kind.setId(2L);
        kind.setName("Gato");
        Animal animal = new Animal();
        animal.setId(1L);
        animal.setName("name_updated");
        animal.setKind(kind);

        Animal animalUpdated = animalService.update(animal);

        assertThat(animalUpdated.getId()).isEqualTo(1L);
        assertThat(animalUpdated.getName()).isEqualTo("name_updated");
        assertThat(animalUpdated.getKind().getName()).isEqualTo("Gato");
    }

    @Test(expected = NoSuchElementException.class)
    public void update_withIdNonExisting_throwNoSuchElementException() {
        Animal animal = new Animal();
        animal.setId(99L);
        animal.setName("name_updated");

        animalService.update(animal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void update_withAnimalNull_throwIllegalArgumentException() {
        animalService.update(null);
    }

    @Test
    public void delete_withExistingId_deleteAnimal() {
        Long id = 1L;

        animalService.delete(id);
        entityManager.flush();

        assertThat(JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, "animal", "id = 1")).isEqualTo(0);
    }

    @Test(expected = NoSuchElementException.class)
    public void delete_withNonExistingId_throwNoSuchElementException() {
        Long id = 99L;

        animalService.delete(id);
    }

    @Test(expected = IllegalArgumentException.class)
    public void delete_withNull_throwNoSuchElementException() {
        animalService.delete(null);
    }

}
