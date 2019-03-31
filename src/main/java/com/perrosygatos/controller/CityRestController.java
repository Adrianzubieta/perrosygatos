package com.perrosygatos.controller;

import com.perrosygatos.domain.City;
import com.perrosygatos.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/states")
public class CityRestController {

    private final CityService cityService;

    @GetMapping("/{stateId}/cities")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    public List<City> findByStateId(@PathVariable Long stateId) {
        return cityService.findByStateId(stateId);
    }

}
