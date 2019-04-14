package com.perrosygatos.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.perrosygatos.BaseTest;
import com.perrosygatos.domain.Animal;
import com.perrosygatos.domain.Photo;
import com.perrosygatos.vo.RequestPhotoVo;
import lombok.SneakyThrows;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.io.ByteArrayInputStream;
import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

public class PhotoServiceTest extends BaseTest {

    @MockBean
    private AmazonS3Client amazonS3ClientMock;

    @Captor
    private ArgumentCaptor<String> argumentCaptorString;

    @Autowired
    private PhotoService photoService;

    @Test
    @SneakyThrows
    public void save_validFile_uploadToS3andSaveInDbAndReturnPhotoUrl() {
        String imageOne = getContentFromFile("test-files/imagesInBase64/imageOne.txt");

        given(amazonS3ClientMock
                .putObject(eq("perrosygatos-test"), argumentCaptorString.capture(), any(ByteArrayInputStream.class), any()))
                .willReturn(new PutObjectResult());

        RequestPhotoVo requestPhotoVo = new RequestPhotoVo();
        requestPhotoVo.setName("firulais en la cama");
        requestPhotoVo.setContentBase64(imageOne);
        requestPhotoVo.setAnimalId(1L);

        Photo photoSaved = photoService.save(requestPhotoVo);

        assertThat(photoSaved.getAnimal().getId()).isEqualTo(1L);
        assertThat(photoSaved.getPath()).isEqualTo(argumentCaptorString.getValue());
        assertThat(photoSaved.getName()).isEqualTo("firulais en la cama");

        then(amazonS3ClientMock).should(times(1))
                .putObject(eq("perrosygatos-test"), eq(argumentCaptorString.getValue()), any(ByteArrayInputStream.class), any());

        assertThat(JdbcTestUtils.countRowsInTable(jdbcTemplate, "photo")).isEqualTo(2);
    }

    @Test(expected = IllegalArgumentException.class)
    @SneakyThrows
    public void save_withContentBase64Invalid_throwIllegalArgumentException() {
        String imageOne = Base64.getEncoder().encodeToString("photo".getBytes());

        given(amazonS3ClientMock
                .putObject(eq("perrosygatos-test"), eq("/2.jpeg"), any(ByteArrayInputStream.class), any()))
                .willReturn(new PutObjectResult());

        RequestPhotoVo requestPhotoVo = new RequestPhotoVo();
        requestPhotoVo.setName("firulais en la cama");
        requestPhotoVo.setContentBase64(imageOne);
        requestPhotoVo.setAnimalId(1L);

        photoService.save(requestPhotoVo);
    }

    @Test(expected = IllegalArgumentException.class)
    @SneakyThrows
    public void save_withNullContentBase64_throwIllegalArgumentException() {
        given(amazonS3ClientMock
                .putObject(eq("perrosygatos-test"), eq("/2.jpeg"), any(ByteArrayInputStream.class), any()))
                .willReturn(new PutObjectResult());

        RequestPhotoVo requestPhotoVo = new RequestPhotoVo();
        requestPhotoVo.setName("firulais en la cama");
        requestPhotoVo.setAnimalId(1L);


        photoService.save(requestPhotoVo);
    }

    @Test(expected = IllegalArgumentException.class)
    @SneakyThrows
    public void save_withAnimalNull_throwIllegalArgumentException() {
        String imageOne = getContentFromFile("test-files/imagesInBase64/imageOne.txt");

        given(amazonS3ClientMock
                .putObject(eq("perrosygatos-test"), eq("/2.jpeg"), any(ByteArrayInputStream.class), any()))
                .willReturn(new PutObjectResult());

        RequestPhotoVo requestPhotoVo = new RequestPhotoVo();
        requestPhotoVo.setName("firulais en la cama");
        requestPhotoVo.setContentBase64(imageOne);

        photoService.save(requestPhotoVo);
    }

    @Test(expected = IllegalArgumentException.class)
    @SneakyThrows
    public void save_withAnimalIdNull_throwIllegalArgumentException() {
        String imageOne = getContentFromFile("test-files/imagesInBase64/imageOne.txt");

        given(amazonS3ClientMock
                .putObject(eq("perrosygatos-test"), eq("/2.jpeg"), any(ByteArrayInputStream.class), any()))
                .willReturn(new PutObjectResult());

        RequestPhotoVo requestPhotoVo = new RequestPhotoVo();
        requestPhotoVo.setName("firulais en la cama");
        requestPhotoVo.setContentBase64(imageOne);

        photoService.save(requestPhotoVo);
    }

}
