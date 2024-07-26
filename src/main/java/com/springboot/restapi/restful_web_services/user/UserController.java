package com.springboot.restapi.restful_web_services.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService){
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userDaoService.getUsers();

    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id){
        User user = userDaoService.findById(id);

        return user;
    }

    @PostMapping("/users")
    public void createNewUser(@RequestBody User user){
        userDaoService.saveNewUser(user);

    }

}
