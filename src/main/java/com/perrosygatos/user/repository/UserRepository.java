package com.perrosygatos.user.repository;

import com.perrosygatos.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
