package de.meziane.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import de.meziane.ms.repository.EmployeeRepository;
import de.meziane.ms.model.*;

@EnableEurekaClient
@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
	
	@Bean
	EmployeeRepository repository() {
		EmployeeRepository repository = new EmployeeRepository();
		repository.add(new Employee(1L, 1L, 1L, "John Smith", 34, "Analyst"));		
		repository.add(new Employee(2L, 1L, 1L, "Darren Hamilton", 37, "Manager"));
		repository.add(new Employee(3L, 1L, 1L, "Tom Scott", 26, "Developer"));
		repository.add(new Employee(4L, 1L, 2L, "Anna London", 39, "Analyst"));		
		repository.add(new Employee(5L, 1L, 2L, "Patrick Dempsey", 27, "Developer"));
		repository.add(new Employee(6L, 2L, 3L, "Kevin Price", 38, "Developer"));		
		repository.add(new Employee(7L, 2L, 3L, "Ian Scott", 34, "Developer"));
		repository.add(new Employee(8L, 2L, 3L, "Andrew Campton", 30, "Manager"));
		repository.add(new Employee(9L, 2L, 4L, "Steve Franklin", 25, "Developer"));
		repository.add(new Employee(10L, 2L, 4L, "Elisabeth Smith", 30, "Developer"));
		return repository;
	}

}
