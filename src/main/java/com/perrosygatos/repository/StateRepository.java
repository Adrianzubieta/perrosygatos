package com.perrosygatos.repository;

import com.perrosygatos.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {

    List<State> findByCountryId(Long id);

}
