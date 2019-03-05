package com.perrosygatos.service;

import com.perrosygatos.BaseTest;
import com.perrosygatos.domain.State;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Transactional
public class StateServiceTest extends BaseTest {

    @Autowired
    private StateService stateServiceService;

    @Test
    public void findByCountryId_withIdOfCountryWithTwoStates_returnTwoStates() {
        List<State> states = stateServiceService.findByCountryId(1L);

        assertThat(states.size()).isEqualTo(2);
        assertThat(states.get(0).getName()).isEqualTo("Cordoba");
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByCountryId_withIdNull_throwIllegalArgumentException() {
        stateServiceService.findByCountryId(null);
    }

}
