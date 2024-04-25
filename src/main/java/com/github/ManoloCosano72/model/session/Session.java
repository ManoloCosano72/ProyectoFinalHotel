package com.github.ManoloCosano72.model.session;

import com.github.ManoloCosano72.model.entity.User;

public class Session {
    private static Session _instance;
    private User user;

    private Session(User user) {
        this.user = user;
    }

    private Session() {

    }
    public static void LogIn(User user){
        if(_instance ==null){
            _instance = new Session(user);
        }
    }

    public static Session get_instance() {
        return _instance;
    }

    public static void set_instance(Session _instance) {
        Session._instance = _instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public static void LogOut(){
        _instance=null;
    }
}
