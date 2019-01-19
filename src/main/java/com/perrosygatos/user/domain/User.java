package com.perrosygatos.user.domain;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String userName;
  private String lastName;
  private String description;

}
