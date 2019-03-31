package com.perrosygatos.repository;

import com.perrosygatos.domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AnimalRepository extends JpaRepository<Animal, Long>, QuerydslPredicateExecutor<Animal> {

//    List<Animal> findAllByCity_Id(Long cityId);

}
