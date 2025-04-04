package com.example.rest_service;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    List<UserDTO> userDTOS = new ArrayList<>();

    public UserRepository() {
//        userDTOS.add(new UserDTO(1, "joan@un.com", "Joean Un", "1111"));
//        userDTOS.add(new UserDTO(2, "joan@dos.com", "Joean Dos", "2222"));
//        userDTOS.add(new UserDTO(3, "joan@tres.com", "Joean Tres", "3333"));
    }

    public List<UserDTO> getUsers() {
        return userDTOS;
    }

    public UserDTO getUserById(int id) {

        Optional<UserDTO> u = userDTOS.stream().filter(user -> user.getId() == id).findFirst();
        if (u.isPresent()) {
            return u.get();
        } else return null;
    }

    public void save(UserDTO userDTO) {
        userDTOS.add(userDTO);
    }

    public void delete(int id) {
        userDTOS.removeIf(user -> user.getId() == id);
    }
}
