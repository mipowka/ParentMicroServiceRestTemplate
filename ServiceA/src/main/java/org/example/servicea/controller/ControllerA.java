package org.example.servicea.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.servicea.dto.UserDto;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class ControllerA {

    private final RestTemplate restTemplate;

    public ControllerA(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/data/{id}")
    public UserDto getData(@PathVariable int id) {
        log.info("enter service A");
        String url = "http://localhost:8081/data/" + id;
        UserDto forObject = restTemplate.getForObject(url, UserDto.class);
        return forObject;
    }

    @GetMapping("/hi")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/new")
    public ResponseEntity<Void> newUser(@RequestBody UserDto user) {
        restTemplate.postForObject("http://localhost:8081/new", user, UserDto.class);
        return ResponseEntity.ok().build();

    }

}
