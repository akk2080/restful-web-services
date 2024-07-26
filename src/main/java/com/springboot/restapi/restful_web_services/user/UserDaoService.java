package com.springboot.restapi.restful_web_services.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
@Service
public class UserDaoService {

    private User user;
    private static List<User> users = new ArrayList<>();

    private static int userId = 0;

    static {
        users.add(new User(++userId, "sam", LocalDate.now().minusYears(30)));
        users.add(new User(++userId, "william", LocalDate.now().minusYears(25)));
        users.add(new User(++userId, "steve", LocalDate.now().minusYears(20)));

    }

    public List<User> getUsers(){
        return users;
    }

    public User findById(int id) {
        return users.stream().filter(x -> x.getId() == id).findFirst().get();
    }
}
