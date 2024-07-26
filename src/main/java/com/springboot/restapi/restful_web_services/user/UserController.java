package com.springboot.restapi.restful_web_services.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public User getUserById(@PathVariable int id) {
        User user = userDaoService.findById(id);
        if(user == null)
            throw new UserNotFoundException("user not found for the given id!!!");

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createNewUser(@RequestBody User user){
        User savedUser = userDaoService.saveNewUser(user);


        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }

}
