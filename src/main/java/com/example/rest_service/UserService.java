package com.example.rest_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    List<User> getUsers() {
        return userDAO.findAll();
    }


    public User getUserById(int id) {
        Optional<User> u = userDAO.findById(id);
        if (u.isPresent()) {
            return u.get();
        } else return null;
    }

    public User newUser(UserDTO userDTO) {
        User u = new User(userDTO);
        return userDAO.save(u);
    }

//    public void deleteUser(int id) {
//        userDAO.delete(id);
//    }

}
