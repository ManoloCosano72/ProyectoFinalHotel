package com.github.ManoloCosano72.model.session;

import com.github.ManoloCosano72.model.entity.User;

public class Session {
    private static Session _instance;
    private static User userLogged;

    private Session() {

    }

    public void logIn(User user) {
        userLogged = user;
    }

    public static Session getInstance() {
        if (_instance == null) {
            _instance = new Session();
            _instance.logIn(userLogged);
        }
        return _instance;
    }

    public User getUserLogged() {
        return userLogged;
    }

    public static void LogOut() {
        userLogged = null;
    }
}
