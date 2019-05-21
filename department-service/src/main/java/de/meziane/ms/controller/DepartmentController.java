package de.meziane.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.meziane.ms.model.Department;
import de.meziane.ms.repository.DepartmentRepository;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentRepository repository;
	
	@Autowired
	EmployeeClient employeeClient;
	
	@PostMapping("/")
	public Department add(@RequestBody Department department) {
		// LOGGER.info("Department add: {}", department);
		return repository.add(department);
	}
	
	@GetMapping("/{id}")
	public Department findById(@PathVariable("id") Long id) {
		// LOGGER.info("Department find: id={}", id);
		return repository.findById(id);
	}
	
	@GetMapping("/")
	public List<Department> findAll() {
		// LOGGER.info("Department find");
		List<Department> depts = repository.findAll(); 
		System.out.printf("Returning %d Departments.\n", depts.size());
		return depts;
	}
	
	@GetMapping("/organisation/{organisationId}")
	public List<Department> findByOrganisation(@PathVariable("organisationId") Long organisationId) {
		// LOGGER.info("Department find: organisationId={}", organisationId);
		return repository.findByOrganisation(organisationId);
	}
	
	@GetMapping("/organisation/{organisationId}/with-employees")
	public List<Department> findByOrganisationWithEmployees(@PathVariable("organisationId") Long organisationId) {
		// LOGGER.info("Department find: organisationId={}", organisationId);
		List<Department> departments = repository.findByOrganisation(organisationId);
		departments.forEach(d -> d.setEmployees(employeeClient.findByDepartment(d.getId())));
		return departments;
	}
}
