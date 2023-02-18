package com.app;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.config.AppConstants;
import com.app.entity.Role;
import com.app.repository.RoleRepo;

@SpringBootApplication
public class OnlinePostApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncode;

	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(OnlinePostApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapped() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.passwordEncode.encode("abc"));

		try {
			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName("ADMIN_USER");

			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("ADMIN_USER");

			List<Role> roles = List.of(role, role);

			List<Role> result = this.roleRepo.saveAll(roles);

			result.forEach((r) -> {
				System.out.println(r.getName());
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
