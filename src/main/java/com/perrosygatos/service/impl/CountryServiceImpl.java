package com.perrosygatos.service.impl;

import com.perrosygatos.domain.Country;
import com.perrosygatos.repository.CountryRepository;
import com.perrosygatos.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

}
