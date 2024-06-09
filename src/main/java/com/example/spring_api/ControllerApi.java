package com.example.spring_api;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ControllerApi {

    public UserRepo userrepo;

    @GetMapping("/")
    public List<User> getAll() {
        return userrepo.findAll();
    }
    // @GetMapping("/")
    // public String getAll() {
    // return "God is good";
    // }

    @PostMapping("/post")
    public String postUser(@RequestBody User user) {
        userrepo.save(user);
        return "user added";
    }

    @PutMapping("update/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        User updatedUser = userrepo.findById(id).get();
        updatedUser.setName(user.getName());
        userrepo.save(updatedUser);
        return "user updated";
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userrepo.deleteById(id);
        return "user deleted";
    }

}
