package com.company.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

/*for h2 db*/

//	@Bean
//	CommandLineRunner createInitialUsers(UserService userService){
//		return (args) -> {
//			UserCreateDTO user = new UserCreateDTO();
//			user.setFirstName("Evvel");
//			user.setLastName("Memmedov");
//			user.setUsername("user1");
//		};
//	}
}
