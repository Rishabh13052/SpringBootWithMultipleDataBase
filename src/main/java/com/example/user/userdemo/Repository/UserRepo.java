package com.example.user.userdemo.Repository;

import com.example.user.userdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepo  extends JpaRepository<User,Integer> {
}
