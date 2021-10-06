package com.example.demo.service;


import com.example.demo.model.User;


import java.util.List;

public interface UserServ {

    User getByName(String name);

    User save(User user);

    List<User> getAllUsers();

    User update(User user);

    void delete(int id);

    User getById(int id);


}
