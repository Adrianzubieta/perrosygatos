package com.perrosygatos.refuge.repository;

import com.perrosygatos.refuge.domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
