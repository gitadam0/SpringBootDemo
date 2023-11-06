package com.example.demoSpringBoot2;

import com.example.demoSpringBoot2.Entity.User;
import com.example.demoSpringBoot2.Repository.UserRepo;
import com.example.demoSpringBoot2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringBoot2Application  implements CommandLineRunner {

	public static void main(String[] args) {
		System.out.println("hello");
		SpringApplication.run(DemoSpringBoot2Application.class, args);
		System.out.println("hello");
	}

	@Autowired
	UserRepo ob;
	@Override
	public void run(String... args) throws Exception
	{
		// Inserting the data in the mysql table.
		User user1 = new User( "test22","test.com");

		// ob.save() method
		//ob.save(first);
		UserService userService= new UserService(ob);
		//userService.saveUser(user1);

		// prints out the 7th person name
		//System.out.println(ob.findAll().get(6).getUsername());


	}

}
