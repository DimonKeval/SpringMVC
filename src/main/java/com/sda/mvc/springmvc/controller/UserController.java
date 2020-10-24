package com.sda.mvc.springmvc.controller;

import com.sda.mvc.springmvc.service.UserService;
import com.sda.mvc.springmvc.model.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/adduser")
    public ModelAndView getAddUserView() {
        return new ModelAndView("adduser", "newUser", new UserDTO());
    }

    @PostMapping("/adduser")
    public String addNewUser(@ModelAttribute UserDTO userDTO) {
        System.out.println(userDTO.getName() + " " + userDTO.getSurname());
        userService.addUser(userDTO);
        return "index";
    }

    @GetMapping("/users")
    public ModelAndView getAllUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        userService.getUsers().forEach(user -> userDTOList.add(userService.getModelMapper().map(user, UserDTO.class)));
        return new ModelAndView("users", "userList", userDTOList);
    }
}
