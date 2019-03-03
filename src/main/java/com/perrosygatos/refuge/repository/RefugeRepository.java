package com.perrosygatos.refuge.repository;

import com.perrosygatos.refuge.domain.Refuge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefugeRepository extends JpaRepository<Refuge, Long> {
}
