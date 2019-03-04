package com.perrosygatos.service;

import com.perrosygatos.BaseTest;
import com.perrosygatos.domain.Refuge;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class RefugeServiceTest extends BaseTest {

    @Autowired
    private RefugeService refugeService;

    @Test
    public void findById_withIdValid_returnRefuge() {
        Long id = 1L;

        Refuge refuge = refugeService.findById(id);

        assertThat(refuge.getId()).isEqualTo(1L);
        assertThat(refuge.getName()).isEqualTo("refugio_1");
        assertThat(refuge.getAnimals().size()).isEqualTo(2);
        assertThat(refuge.getAnimals().get(0).getName()).isEqualTo("firulais");
    }

    @Test(expected = NoSuchElementException.class)
    public void findById_withIdNonValid_throwNoSuchElementException() {
        Long id = 99L;

        refugeService.findById(id);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findById_withIdNull_throwIllegalArgumentException() {
        refugeService.findById(null);
    }

    @Test
    public void save_withFieldsCorrect_returnRefugeSaved() {
        Refuge refugeToSave = new Refuge();
        refugeToSave.setName("refugio_3");
        refugeToSave.setAddress("address_3");
        refugeToSave.setPhone("1516161616");
        refugeToSave.setWebSite("webSite_3");
        refugeToSave.setDescription("description_3");

        Refuge refugeSaved = refugeService.save(refugeToSave);

        assertThat(refugeSaved.getId()).isEqualTo(3);
        assertThat(refugeSaved.getName()).isEqualTo("refugio_3");
        assertThat(refugeSaved.getAddress()).isEqualTo("address_3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void save_withNameNull_throwIllegalArgumentException() {
        Refuge refugeToSave = new Refuge();
        refugeToSave.setAddress("address_3");
        refugeToSave.setPhone("1516161616");
        refugeToSave.setWebSite("webSite_3");
        refugeToSave.setDescription("description_3");

        refugeService.save(refugeToSave);
    }

    @Test(expected = IllegalArgumentException.class)
    public void save_withPhoneNull_throwIllegalArgumentException() {
        Refuge refugeToSave = new Refuge();
        refugeToSave.setName("refugio_3");
        refugeToSave.setAddress("address_3");
        refugeToSave.setWebSite("webSite_3");
        refugeToSave.setDescription("description_3");

        refugeService.save(refugeToSave);
    }

    @Test
    public void update_withRefugeExisting_returnRefugeUpdated() {
        Refuge refugeToUpdate = new Refuge();
        refugeToUpdate.setId(2L);
        refugeToUpdate.setName("nameUpdated");

        Refuge refugeUpdated = refugeService.update(refugeToUpdate);

        assertThat(refugeUpdated.getName()).isEqualTo("nameUpdated");
        assertThat(refugeUpdated.getId()).isEqualTo(2L);
    }

    @Test(expected = NoSuchElementException.class)
    public void update_withRefugeNonExisting_throwNoSuchElementException() {
        Refuge refugeToUpdate = new Refuge();
        refugeToUpdate.setId(99L);
        refugeToUpdate.setName("nameUpdated");

        refugeService.update(refugeToUpdate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void update_withRefugeNull_throwIllegalArgumentException() {
        refugeService.update(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void update_withIdRefugeNull_throwIllegalArgumentException() {
        Refuge refugeToUpdate = new Refuge();
        refugeToUpdate.setName("nameUpdated");

        refugeService.update(refugeToUpdate);
    }

    @Test
    public void findAll_withPageZeroSizeTwo_returnPageOfAnimals() {
        Pageable pageable = PageRequest.of(0, 2);

        Page<Refuge> animals = refugeService.findAll(pageable);

        assertThat(animals.getTotalPages()).isEqualTo(1);
        assertThat(animals.getContent().size()).isEqualTo(2);
        assertThat(animals.getContent().get(0).getName()).isEqualTo("refugio_1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void findAll_withNull_throwIllegalArgumentException() {
        refugeService.findAll(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findAll_withPageZeroSizeZero_throwIllegalArgumentException() {
        Pageable pageable = PageRequest.of(0, 0);

        refugeService.findAll(pageable);
    }

    @Test
    public void delete_withExistingId_deleteRefuge() {
        Long id = 1L;

        refugeService.delete(id);
        entityManager.flush();

        assertThat(JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, "refuge", "id = 1")).isEqualTo(0);
    }

    @Test(expected = NoSuchElementException.class)
    public void delete_withNonExistingId_throwNoSuchElementException() {
        Long id = 99L;

        refugeService.delete(id);
    }

    @Test(expected = IllegalArgumentException.class)
    public void delete_withNull_throwNoSuchElementException() {
        refugeService.delete(null);
    }

}
