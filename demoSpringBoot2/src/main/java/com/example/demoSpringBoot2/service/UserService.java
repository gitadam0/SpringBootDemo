package com.example.demoSpringBoot2.service;

import com.example.demoSpringBoot2.Entity.User;
import com.example.demoSpringBoot2.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    public  UserService(UserRepo repository) {
        this.userRepo = repository;
    }

    public User saveUser(User user){

        return userRepo.save(user);
    }

    public User saveAllUsers(List<User> userlist){

        for (User i : userlist){
            userRepo.save(i);
        }

        return userRepo.save(userlist.get(0));
    }
}
