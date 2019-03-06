package com.perrosygatos.repository;

import com.perrosygatos.domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findAllByCity_Id(Long cityId);

}
