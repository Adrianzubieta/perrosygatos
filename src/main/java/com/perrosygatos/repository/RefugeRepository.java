package com.perrosygatos.repository;

import com.perrosygatos.domain.Refuge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefugeRepository extends JpaRepository<Refuge, Long> {
}
