package com.jpa.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.controller.UserController;
import com.jpa.test.dao.UserRepository;

@SpringBootApplication
public class BootjpaegApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaegApplication.class,args);
		
		//UserRepository userRepository =  context.getBean(UserRepository.class);
		
	//	UserController uc = new UserController(context,userRepository);
		
		
		
//		User user = new User();
//		
//		user.setName("Gourav Mishra");
//		user.setCity("Ahubaneswar");
//		user.setStatus("Etudent");
		
//		User result = userRepository.save(user);
		
		//User user1 = new User();
		
//		user1 = userRepository.findById(3).get();
	
		
//		System.out.println(user1);
//		
//		user1.setName("Omm Bhatia");
//		
//		User result = userRepository.save(user1);
//		
//		System.out.println(result);
//		
//		userRepository.deleteById(3);
	
		//List<User> user = userRepository.findAllByOrderByIdDesc();
		
		//user.forEach(res->System.out.println(res));
		

		
		
		//System.out.println(user1);
	}

}
