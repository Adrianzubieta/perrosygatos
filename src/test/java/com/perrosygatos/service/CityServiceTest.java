package com.perrosygatos.service;


import com.perrosygatos.BaseTest;
import com.perrosygatos.domain.City;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Transactional
public class CityServiceTest extends BaseTest {

    @Autowired
    private CityService cityService;

    @Test
    public void findByStateId_withIdOfStateWithTwoCities_returnTwoCities() {
        List<City> cities = cityService.findByStateId(1L);

        assertThat(cities.size()).isEqualTo(2);
        assertThat(cities.get(0).getName()).isEqualTo("CABA");
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByStateId_withIdNull_throwIllegalArgumentException() {
        cityService.findByStateId(null);
    }

}
