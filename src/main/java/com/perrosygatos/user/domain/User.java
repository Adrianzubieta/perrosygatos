package com.perrosygatos.user.domain;


import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String email;
  private String password;
  private String userName;

}
