package com.perrosygatos.repository;

import com.perrosygatos.domain.Kind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KindRepository extends JpaRepository<Kind, Long> {
}
