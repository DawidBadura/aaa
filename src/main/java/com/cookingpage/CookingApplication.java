package com.cookingpage;

import com.cookingpage.domain.User;
import com.cookingpage.domain.security.Role;
import com.cookingpage.domain.security.UserRole;
import com.cookingpage.service.UserService;
import com.cookingpage.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class CookingApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(CookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setFirstName("Dawid");
		user1.setLastName("Badura");
		user1.setUsername("admin");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("dwd"));
		user1.setEmail("dawid.badurakrk@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1= new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));

		userService.createUser(user1, userRoles);
	}
}
