package com.perrosygatos.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    @ManyToOne
    @JsonIgnore
    private Refuge refuge;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "animal_id")
    private List<Photo> photos;
}
