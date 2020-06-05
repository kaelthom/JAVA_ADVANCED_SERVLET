package com.mywebapp.dao;

import com.mywebapp.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    static private UserDao instance;
    private Map<String, User> users = new HashMap<String, User>() {
        {
            put("John", new User("John", "Doe", 200));
            put("Jack", new User("Jack", "Doe", 300));
            put("Jenny", new User("Jenny", "Doe", 400));

        }
    };

    private UserDao() {
    }

    static public UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }
    public Map<String, User> getUsers() {
        return users;
    }

    public User findUser(String name) {
        return users.get(name);
    }

    public User addUser(User user) {
        return users.put(user.getLastname(), user);
    }
}
