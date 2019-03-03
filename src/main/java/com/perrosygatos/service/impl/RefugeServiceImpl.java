package com.perrosygatos.service.impl;

import com.perrosygatos.domain.Refuge;
import com.perrosygatos.repository.RefugeRepository;
import com.perrosygatos.service.RefugeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class RefugeServiceImpl implements RefugeService {

    private final RefugeRepository refugeRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public Refuge save(Refuge refuge) {
        Assert.hasText(refuge.getName(), "The name is null");
        Assert.hasText(refuge.getPhone(), "The phone is null");
        return refugeRepository.save(refuge);
    }

    @Override
    public Refuge findById(Long id) {
        Assert.notNull(id, "The id is null");
        return refugeRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Refuge update(Refuge refuge) {
        Assert.notNull(refuge, "The refuge is null");
        Refuge refugeToUpdate = findById(refuge.getId());
        modelMapper.map(refuge, refugeToUpdate);
        return refugeToUpdate;
    }

    @Override
    public Page<Refuge> findAll(Pageable pageable) {
        Assert.notNull(pageable, "The pageable is null");
        return refugeRepository.findAll(pageable);
    }
}
