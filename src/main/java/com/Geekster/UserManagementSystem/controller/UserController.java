package com.Geekster.UserManagementSystem.controller;

import com.Geekster.UserManagementSystem.service.UserService;
import com.Geekster.UserManagementSystem.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public String postUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable String userId){
        return userService.userGetById(userId);
    }

    @GetMapping("/user")
    public List<User> getUser(){
        return userService.getAllUser();
    }

    @PutMapping(value = "/user/{userId}/{name}")
    public String updateUser(@PathVariable String userId,@PathVariable String name){
        return userService.updateUserById(userId,name)? "Updated successfully":"Not found user with this id..!!";
    }
    @DeleteMapping(value = "/user/{userId}")
    public String deleteUserByUserId(@PathVariable String userId){
        return userService.removeUserByUserId(userId);
    }

}
