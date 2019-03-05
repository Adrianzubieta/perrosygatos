package com.perrosygatos.service;

import com.perrosygatos.domain.State;

import java.util.List;

public interface StateService {

    List<State> findByCountryId(Long id);

}
