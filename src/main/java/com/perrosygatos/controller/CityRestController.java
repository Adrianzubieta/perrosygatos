package com.perrosygatos.controller;

import com.perrosygatos.domain.City;
import com.perrosygatos.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/states")
public class CityRestController {

    private final CityService cityService;

    @GetMapping("/{stateId}/cities")
    public List<City> findByStateId(@PathVariable Long stateId) {
        return cityService.findByStateId(stateId);
    }

}
