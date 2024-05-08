package com.banbi.tdduserservice.controller;

import com.banbi.tdduserservice.dto.User;
import com.banbi.tdduserservice.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/findUserAll")
    public Object findUserAll(){
        return userService.findUserAll();
    }

    @GetMapping("/{userId}")
    public Object findUserById(@PathVariable("userId") String userId){
        return userService.findUserById(userId);
    }

    @PostMapping("/createUser")
    public Object createUser(@RequestBody User user){
        userService.createUser(user);
        return null;
    }

    @PutMapping("/update/{userId}")
    public Object updateUser(@RequestBody User user){
        userService.updateUser(user);
        return null;
    }

    @DeleteMapping("/{userId}")
    public Object deleteUser(@PathVariable("userId") String userId){
        userService.delete(userId);
        return null;
    }
}
