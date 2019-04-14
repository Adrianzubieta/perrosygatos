package com.perrosygatos.vo;

import com.perrosygatos.domain.Animal;
import lombok.Data;

import java.util.List;

@Data
public class RequestPhotoVo {

    private Long animalId;
    private String contentBase64;
    private String name;

}
