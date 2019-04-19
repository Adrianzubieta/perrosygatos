package com.perrosygatos.repository;

import com.perrosygatos.domain.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {
}
