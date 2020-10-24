package com.sda.mvc.springmvc.service;

import com.sda.mvc.springmvc.model.dto.UserDTO;
import com.sda.mvc.springmvc.model.entity.User;
import com.sda.mvc.springmvc.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final ModelMapper modelMapper;

    private UserRepository repository;

    public UserService(ModelMapper modelMapper, UserRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    public void addUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);

        System.out.println("I have an user: " + user.getName());
        repository.save(user);
        //zmapować na encje

        //zapisać do bazy

    }
}
