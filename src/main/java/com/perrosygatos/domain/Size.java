package com.perrosygatos.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
