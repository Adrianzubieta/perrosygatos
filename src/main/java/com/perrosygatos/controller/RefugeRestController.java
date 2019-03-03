package com.perrosygatos.controller;

import com.perrosygatos.domain.Refuge;
import com.perrosygatos.service.RefugeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/refuge")
@RequiredArgsConstructor
@Slf4j
public class RefugeRestController {

    private final RefugeService refugeService;

    @GetMapping("/{id}")
    public Refuge findById(@PathVariable Long id) {
        return refugeService.findById(id);
    }

    @GetMapping
    public Page<Refuge> findAll(Pageable pageable) {
        return refugeService.findAll(pageable);
    }

}
