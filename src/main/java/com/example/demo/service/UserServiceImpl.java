package com.example.demo.service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserServ {

    private final UserRepository userDao;
    @Autowired
    public UserServiceImpl(UserRepository userDao) {
        this.userDao = userDao;
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }
    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User update(User user) {
        return userDao.save(user);
    }

    @Override
    public void delete(int id ) {
        userDao.deleteById(id);
    }
    @Override
    public User getByName(String name) {
        List<User> users = getAllUsers();
        return users.stream().filter(x -> x.getName().equals(name)).findAny().orElse(null);
    }
    @Override
    public User getById(int id) {
        return userDao.findById(id).get();
    }
}
