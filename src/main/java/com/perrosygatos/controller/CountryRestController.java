package com.perrosygatos.controller;

import com.perrosygatos.domain.Country;
import com.perrosygatos.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
public class CountryRestController {

    private final CountryService countryService;

    @GetMapping
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    public List<Country> findAll() {
        return countryService.findAll();
    }

}
