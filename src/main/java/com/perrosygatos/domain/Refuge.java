package com.perrosygatos.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Refuge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String webSite;
    private String description;
    private String phone;
    private String address;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "refuge_id")
    List<Animal> animals;
    @ManyToOne
    private City city;

}
