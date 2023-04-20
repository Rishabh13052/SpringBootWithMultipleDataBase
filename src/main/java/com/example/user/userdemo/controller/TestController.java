


package com.example.user.userdemo.controller;

import com.example.user.userdemo.entity.User;
import com.example.user.userdemo.entity1.Course;
import com.example.user.userdemo.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class TestController {
    @Autowired
    private ServiceImpl serviceImpl;

    @PostMapping("/adduser")
    public User saveUser(@RequestBody User user){
        return serviceImpl.saveUser(user);
    }


    @PostMapping("/addcourse")
    public Course saveCourse(@RequestBody Course course){
        return serviceImpl.saveCourse(course);
    }


    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable String id){
        return serviceImpl.getCourse(id);
    }


    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id){
        return serviceImpl.getUser(id);
    }
}
