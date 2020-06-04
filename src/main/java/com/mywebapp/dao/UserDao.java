package com.mywebapp.dao;

import com.mywebapp.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private Map<String, User> users = new HashMap<String, User>() {
        {
            put("John", new User("John", "Doe", 200));
            put("Jack", new User("Jack", "Doe", 300));
            put("Jenny", new User("Jenny", "Doe", 400));

        }
    };

    public Map<String, User> getUsers() {
        return users;
    }

    public User findUser(String name) {
        return users.get(name);
    }
}
