package com.perrosygatos.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.perrosygatos.BaseTest;
import com.perrosygatos.domain.Animal;
import com.perrosygatos.domain.Photo;
import lombok.SneakyThrows;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

public class PhotoServiceTest extends BaseTest {

    @MockBean
    private AmazonS3Client amazonS3ClientMock;

    @Autowired
    private PhotoService photoService;

    @Test
    @SneakyThrows
    public void save_validFile_uploadToS3andSaveInDbAndReturnPhotoUrl() {
        String imageOne = getContentFromFile("test-files/imagesInBase64/imageOne.txt");

        given(amazonS3ClientMock
                .putObject(eq("perrosygatos-test"), "1.jpeg", any(ByteArrayInputStream.class), any()))
                .willReturn(new PutObjectResult());

        Animal animal = new Animal();
        animal.setId(1L);

        Photo photo = new Photo();
        photo.setName("firulais en la cama");
        photo.setAnimal(animal);

        Photo photoSaved = photoService.save(photo);

        assertThat(photoSaved.getAnimal().getId()).isEqualTo(1L);
        assertThat(photoSaved.getPath()).isEqualTo("");
        assertThat(photoSaved.getId()).isEqualTo(2L);
        assertThat(photoSaved.getName()).isEqualTo("firulas en cama");

        then(amazonS3ClientMock).should(times(1))
                .putObject(eq("perrosygatos-test"), "1.jpeg", any(ByteArrayInputStream.class), any());


        assertThat(JdbcTestUtils.countRowsInTable(jdbcTemplate, "photoSaved")).isEqualTo(1);
    }
}
