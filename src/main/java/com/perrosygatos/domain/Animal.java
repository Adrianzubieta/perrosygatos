package com.perrosygatos.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer age;
    private String urlPhoto;
    private String history;
    @ManyToOne
    private Kind kind;
    @ManyToOne
    private City city;
    @ManyToOne
    private Gender gender;
    @ManyToOne
    private Size size;
}
