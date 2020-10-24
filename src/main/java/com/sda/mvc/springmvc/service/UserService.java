package com.sda.mvc.springmvc.service;

import com.sda.mvc.springmvc.model.dto.UserDTO;
import com.sda.mvc.springmvc.model.entity.User;
import com.sda.mvc.springmvc.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

        //zmapować na encje
        User user = modelMapper.map(userDTO, User.class);

        System.out.println("I have an user: " + user.getName());

        //zapisać do bazy
        repository.save(user);
    }

//first own version
//    public List<User> getUsers() {
//        List<User> userList = repository.findAll();
//        return userList;
//    }

    public List<UserDTO> getAllUsers(){
        return repository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }
}
