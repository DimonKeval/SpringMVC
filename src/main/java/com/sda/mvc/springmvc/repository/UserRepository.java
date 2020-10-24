package com.sda.mvc.springmvc.repository;

import com.sda.mvc.springmvc.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}

