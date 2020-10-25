package com.sda.mvc.springmvc.repository;

import com.sda.mvc.springmvc.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUsersBySurname(@Param("surname") String surname);
}

