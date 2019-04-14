package com.perrosygatos.service;

import com.perrosygatos.BaseTest;
import com.perrosygatos.domain.Country;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CountryServiceTest extends BaseTest {

    @Autowired
    private CountryService countryService;

    @Test
    public void findAll_withCountriesSaved_returnTwoCountries() {
        List<Country> countries = countryService.findAll();

        assertThat(countries.size()).isEqualTo(2);
        assertThat(countries.get(0).getName()).isEqualTo("Argentina");
    }

}
