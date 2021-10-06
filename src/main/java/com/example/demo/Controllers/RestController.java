package com.example.demo.Controllers;

import com.example.demo.model.User;
import com.example.demo.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final UserServ userService;

    @Autowired
    public RestController(UserServ userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public User add(@RequestBody User user) {
        return userService.save(user);
    }


    @PutMapping("/edit")
    public void update(@RequestBody User user) {
        userService.update(user);
    }


    @GetMapping("/edit/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userService.getById(id);
    }

    @DeleteMapping("/admin/{id}")
    public void delete(@PathVariable("id") int id) {
        userService.delete(id);

    }

    @GetMapping("/user")
    public User userPage(Principal principal) {
        return userService.getByName(principal.getName());
    }


}