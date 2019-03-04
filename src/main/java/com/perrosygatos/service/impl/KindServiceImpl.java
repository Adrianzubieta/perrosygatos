package com.perrosygatos.service.impl;

import com.perrosygatos.domain.Kind;
import com.perrosygatos.repository.KindRepository;
import com.perrosygatos.service.KindService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class KindServiceImpl implements KindService {

    private final KindRepository kindRepository;
    private final ModelMapper modelMapper;

    @Override
    public Kind findById(Long id) {
        Assert.notNull(id, "The id is null");
        return kindRepository.findById(id).get();
    }

    @Override
    public Page<Kind> findAll(Pageable pageable) {
        Assert.notNull(pageable, "The pageable is null");
        return kindRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Kind save(Kind kindToSave) {
        Assert.notNull(kindToSave, "The kind is null");
        Assert.hasText(kindToSave.getName(), "The name of kind is null");
        return kindRepository.save(kindToSave);
    }

    @Override
    public Kind update(Kind kind) {
        Assert.notNull(kind, "The kind is null");
        Kind kindToUpdate = findById(kind.getId());
        modelMapper.map(kind, kindToUpdate);
        return kindToUpdate;
    }


}
