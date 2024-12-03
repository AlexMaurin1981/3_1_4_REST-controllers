package REST_controller.demo;

import REST_controller.demo.entetie.Role;
import REST_controller.demo.reposotorie.RoleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringRESTApplication {

//	private final RoleRepository roleRepository;
//
//	public SpringRESTApplication(RoleRepository roleRepository) {
//		this.roleRepository = roleRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringRESTApplication.class, args);
	}


}