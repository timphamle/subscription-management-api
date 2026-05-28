package com.timle.subscriptionapi.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.timle.subscriptionapi.model.User;

@Service
public class UserService{

    private List<User> users = new ArrayList<>();

    // methods
    public List<User> getAllUsers(){
        return users;
    }

    public void addUser(User user){
        users.add(user);
    }

    public User getUserById(int id){
        for (User user : users){
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public void deleteUserById(int id){
        for (User user : users){
            if (user.getId() == id) {
                users.remove(user);
                break;
            }
        }
    }
}