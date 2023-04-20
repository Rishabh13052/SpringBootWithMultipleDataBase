package com.example.user.userdemo.repo;

import com.example.user.userdemo.entity1.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface CourseRepo extends JpaRepository<Course,Integer> {
}
