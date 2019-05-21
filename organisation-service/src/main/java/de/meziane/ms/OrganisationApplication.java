package de.meziane.ms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.netflix.appinfo.DataCenterInfo.Name;

import de.meziane.ms.model.Department;
import de.meziane.ms.model.Employee;
import de.meziane.ms.model.Organisation;
import de.meziane.ms.repository.OrganisationRepository;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class OrganisationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganisationApplication.class, args);
	}
	
	@Bean
	OrganisationRepository repository() {
		OrganisationRepository repository = new OrganisationRepository();
		
		
		repository.add(new Organisation(1L, "Microsoft", "Redmond, Washington, USA", null, null));
		repository.add(new Organisation(2L, "Oracle", "Redwood City, California, USA", null, null));	
		return repository;
	}


}
