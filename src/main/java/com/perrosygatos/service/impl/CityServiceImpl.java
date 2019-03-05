package com.perrosygatos.service.impl;


import com.perrosygatos.domain.City;
import com.perrosygatos.repository.CityRepository;
import com.perrosygatos.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<City> findByStateId(Long id) {
        Assert.notNull(id, "The id of city is null");
        return cityRepository.findByStateId(id);
    }

}
