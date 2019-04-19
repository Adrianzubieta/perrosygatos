package com.perrosygatos.restController;

import com.perrosygatos.BaseTest;
import com.perrosygatos.controller.AnimalRestController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class AnimalRestControllerTest extends BaseTest {

    @Autowired
    AnimalRestController animalRestController;

    @Test
    public void findAll_withCity_returnAllAnimal() {

    }

}
