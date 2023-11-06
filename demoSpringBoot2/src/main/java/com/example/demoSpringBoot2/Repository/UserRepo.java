package com.example.demoSpringBoot2.Repository;

import com.example.demoSpringBoot2.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {



}
