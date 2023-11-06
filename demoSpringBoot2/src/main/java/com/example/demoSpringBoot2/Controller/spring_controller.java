package com.example.demoSpringBoot2.Controller;


import com.example.demoSpringBoot2.Entity.User;
import com.example.demoSpringBoot2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/adam")
public class spring_controller {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello world sala";
    }

    @GetMapping("/getdata")
    public String getdata() {
        String uri ="http://localhost:8080/hello";
        RestTemplate restTemplate=new RestTemplate();
        String res= restTemplate.getForObject(uri,String.class);
        return res;
    }
    @GetMapping("/users")
    public List getlist() {
        List list=new ArrayList<>();
        list.add(new User(0,"adam1","1111"));
        list.add(new User(0,"adam2","2222"));
        list.add(new User(0,"adam3","3333"));

        return list;
    }

    @GetMapping("/countries")
    public String getcountries() {
        String uri ="https://restcountries.com/v3.1/region/europe";
        RestTemplate restTemplate=new RestTemplate();
        String res= restTemplate.getForObject(uri,String.class);
        return res;
    }

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public String savep(@RequestBody User user) {

        return "user has been added :"+userService.saveUser(user).toString();
    }

    @GetMapping("/getusers")
    public String getusers() {
        RestTemplate restTemplate = new RestTemplate();
        User[] users = restTemplate.getForObject("http://localhost:8080/adam/users", User[].class);

        List<User> userList = Arrays.asList(users);

        return "users : "+ userList;
//        return userService.saveUser(user);
    }

    @GetMapping("/saveallusers")
    public String saveallusers() {
        RestTemplate restTemplate = new RestTemplate();
        User[] users = restTemplate.getForObject("http://localhost:8080/adam/users", User[].class);

        List<User> userList = Arrays.asList(users);

        userService.saveAllUsers(userList);

        return "users that have been saved: "+ userList;
    }


}