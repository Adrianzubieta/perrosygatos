package com.perrosygatos;

import lombok.SneakyThrows;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.FileReader;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public abstract class BaseTest {

  @Autowired
  protected JdbcTemplate jdbcTemplate;

  @Autowired
  protected EntityManager entityManager;

  @SneakyThrows
  protected String getContentFromFile(String filePath) {
    File file = new ClassPathResource(filePath).getFile();
    return FileCopyUtils.copyToString(new FileReader(file));
  }

}
