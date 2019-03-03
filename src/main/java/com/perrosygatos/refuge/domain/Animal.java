package com.perrosygatos.refuge.domain;

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
    @ManyToOne
    private Kind kind;
}
