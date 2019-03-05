package com.perrosygatos.repository;

import com.perrosygatos.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByStateId(Long id);

}
