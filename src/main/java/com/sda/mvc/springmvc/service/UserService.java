package com.sda.mvc.springmvc.service;

import com.sda.mvc.springmvc.model.dto.UserDTO;
import com.sda.mvc.springmvc.model.entity.User;
import com.sda.mvc.springmvc.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final ModelMapper modelMapper;

    private UserRepository repository;

    public UserService(ModelMapper modelMapper, UserRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    public void addUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);

        System.out.println("I have an user: " + user.getName());
        repository.save(user);
        //zmapować na encje

        //zapisać do bazy

    }

    public List<User> getUsers() {
        List<User> userList = repository.findAll();
        return userList;
    }
}
