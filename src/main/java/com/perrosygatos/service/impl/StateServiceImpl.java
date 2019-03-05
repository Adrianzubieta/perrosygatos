package com.perrosygatos.service.impl;

import com.perrosygatos.domain.State;
import com.perrosygatos.repository.StateRepository;
import com.perrosygatos.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateServiceImpl implements StateService {

    private final StateRepository stateRepository;

    @Override
    public List<State> findByCountryId(Long id) {
        Assert.notNull(id, "The id of state is null");
        return stateRepository.findByCountryId(id);
    }

}
