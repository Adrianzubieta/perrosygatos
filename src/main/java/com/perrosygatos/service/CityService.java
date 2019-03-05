package com.perrosygatos.service;


import com.perrosygatos.domain.City;

import java.util.List;

public interface CityService {

    List<City> findByStateId(Long id);

}
