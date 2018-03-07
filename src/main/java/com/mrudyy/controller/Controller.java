package com.mrudyy.controller;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    Session session;

    @RequestMapping("/begin")
    public String startSession(){
        session.beginTransaction();
        return "Session start";
    }

    @RequestMapping("/close")
    public String closeSession(){
        session.close();
        return "Session closed";
    }

}
