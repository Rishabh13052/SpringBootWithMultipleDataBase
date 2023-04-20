


package com.example.user.userdemo.service;


import com.example.user.userdemo.Repository.UserRepo;
import com.example.user.userdemo.entity.User;
import com.example.user.userdemo.entity1.Course;

import com.example.user.userdemo.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl {

    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private UserRepo userRepo;

    public User saveUser(User user){
        return this.userRepo.save(user);
    }

    public Course saveCourse(Course course){
        return this.courseRepo.save(course);
    }

    public User getUser(String id){
        return this.userRepo.findById(Integer.parseInt(id)).get();
    }


    public Course getCourse(String id){
        return this.courseRepo.findById(Integer.parseInt(id)).get();
    }
}