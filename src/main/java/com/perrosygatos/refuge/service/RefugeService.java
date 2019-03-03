package com.perrosygatos.refuge.service;

import com.perrosygatos.refuge.domain.Refuge;

public interface RefugeService {

    Refuge save(Refuge refuge);

    Refuge findById(Long id);

    Refuge update(Refuge refugeToUpdate);
}
