package org.example.servicec.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class ControllerC {

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

    @GetMapping("/data/{id}")
    public User findById(@PathVariable int id) {
        User user1 = new User(1,"Max");
        User user2 = new User(2,"Nikita");
        User user3 = new User(3,"Alena");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        return users.get(id);
    }

    @PostMapping("/new")
    public void save(@RequestBody User user) {
        log.info(user.toString());
    }
}
