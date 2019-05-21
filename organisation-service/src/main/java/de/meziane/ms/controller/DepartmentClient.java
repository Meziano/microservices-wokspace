package de.meziane.ms.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import de.meziane.ms.model.Department;

@FeignClient(name = "department-service")
public interface DepartmentClient {
	
	@GetMapping("/organisation/{organisationId}")
	public List<Department> findByOrganisation(@PathVariable("organisationId") Long organisationId);
	
	@GetMapping("/organisation/{organisationId}/with-employees")
	public List<Department> findByOrganisationWithEmployees(@PathVariable("organisationId") Long organisationId);

}
