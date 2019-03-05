package com.perrosygatos.controller;

import com.perrosygatos.domain.State;
import com.perrosygatos.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/countries")
public class StateRestController {

    private final StateService stateService;

    @GetMapping("/{countryId}/states")
    public List<State> findByCountryId(@PathVariable Long countryId) {
        return stateService.findByCountryId(countryId);
    }

}
