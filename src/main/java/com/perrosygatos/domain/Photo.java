package com.perrosygatos.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String path;
    @ManyToOne
    @JsonIgnore
    private Animal animal;
    @Transient
    private String url;

}
