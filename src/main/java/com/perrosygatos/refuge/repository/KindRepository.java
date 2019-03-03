package com.perrosygatos.refuge.repository;

import com.perrosygatos.refuge.domain.Kind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KindRepository extends JpaRepository<Kind, Long> {
}
