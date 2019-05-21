package de.meziane.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import de.meziane.ms.model.Department;
import de.meziane.ms.repository.DepartmentRepository;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class DepartmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentApplication.class, args);
	}
	
	@Bean
	DepartmentRepository repository() {
		DepartmentRepository repository = new DepartmentRepository();
		repository.add(new Department(1L, 1L, "Development", null));
		repository.add(new Department(2L, 1L, "Operations", null));
		repository.add(new Department(3L, 2L, "Development", null));
		repository.add(new Department(4L, 2L, "Operations", null));		
		return repository;
	}
	

}
