package com.perrosygatos.refugeService;

import com.perrosygatos.BaseTest;
import com.perrosygatos.refuge.domain.Refuge;
import com.perrosygatos.refuge.service.RefugeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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

}
