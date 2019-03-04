package com.perrosygatos.service;

import com.perrosygatos.BaseTest;
import com.perrosygatos.domain.Kind;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class KindServiceTest extends BaseTest {

    @Autowired
    private KindService kindService;

    @Test
    public void findById_withIdExisting_returnAnimal() {
        Long id = 1L;

        Kind kind = kindService.findById(id);

        assertThat(kind.getId()).isEqualTo(1L);
        assertThat(kind.getName()).isEqualTo("Perro");
    }

    @Test(expected = NoSuchElementException.class)
    public void findById_withIdNonExisting_throwNoSuchElementException() {
        Long id = 99L;

        kindService.findById(id);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findById_withIdNull_throwIllegalArgumentException() {
        kindService.findById(null);
    }

    @Test
    public void findAll_withPageZeroSizeTwo_returnPageOfKinds() {
        Pageable pageable = PageRequest.of(0, 2);

        Page<Kind> kinds = kindService.findAll(pageable);

        assertThat(kinds.getTotalPages()).isEqualTo(1);
        assertThat(kinds.getContent().size()).isEqualTo(2);
        assertThat(kinds.getContent().get(0).getName()).isEqualTo("Perro");
    }

    @Test(expected = IllegalArgumentException.class)
    public void findAll_withNull_throwIllegalArgumentException() {
        kindService.findAll(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findAll_withPageZeroSizeZero_throwIllegalArgumentException() {
        Pageable pageable = PageRequest.of(0, 0);

        kindService.findAll(pageable);
    }

    @Test
    public void save_withFieldsValid_returnKindSaved() {
        Kind kindToSave = new Kind();
        kindToSave.setName("Canario");

        Kind kindSaved = kindService.save(kindToSave);

        assertThat(kindSaved.getId()).isEqualTo(3L);
        assertThat(kindSaved.getName()).isEqualTo("Canario");
    }

    @Test(expected = IllegalArgumentException.class)
    public void save_withKindNull_throwIllegalArgumentException() {
        kindService.save(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void save_withNameOfKindVoid_throwIllegalArgumentException() {
        Kind kindToSave = new Kind();
        kindToSave.setName("");

        kindService.save(kindToSave);
    }

    @Test(expected = IllegalArgumentException.class)
    public void save_withNameOfKindIsNull_throwIllegalArgumentException() {
        Kind kindToSave = new Kind();

        kindService.save(kindToSave);
    }

    @Test
    public void update_withKindExisting_returnKindSaved() {
        Kind kindToUpdate = new Kind();
        kindToUpdate.setId(1L);
        kindToUpdate.setName("nameToUpdate");

        Kind kindUpdated = kindService.update(kindToUpdate);

        assertThat(kindUpdated.getId()).isEqualTo(1L);
        assertThat(kindUpdated.getName()).isEqualTo("nameToUpdate");
    }

    @Test(expected = IllegalArgumentException.class)
    public void update_withKindNull_throwIllegalArgumentException() {
        kindService.update(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void update_withKindNonExisting_throwNoSuchElementException() {
        Kind kindToUpdate = new Kind();
        kindToUpdate.setId(99L);
        kindToUpdate.setName("nameToUpdate");

        kindService.update(kindToUpdate);
    }


}
