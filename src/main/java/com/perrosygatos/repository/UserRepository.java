package com.perrosygatos.repository;

import com.perrosygatos.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {


}
