package de.meziane.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.meziane.ms.model.Organisation;
import de.meziane.ms.repository.OrganisationRepository;

@RestController
public class OrganisationController {
	
	@Autowired
	OrganisationRepository repository;
	
	@Autowired
	DepartmentClient departmentClient;
	
	@Autowired
	EmployeeClient employeeClient;
	
	@PostMapping
	public Organisation add(@RequestBody Organisation organisation) {
		// LOGGER.info("Organization add: {}", organization);
		return repository.add(organisation);
	}
	
	@GetMapping
	public List<Organisation> findAll() {
		// LOGGER.info("Organization find");
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Organisation findById(@PathVariable("id") Long id) {
		// LOGGER.info("Organization find: id={}", id);
		return repository.findById(id);
	}

	@GetMapping("/{id}/with-departments")
	public Organisation findByIdWithDepartments(@PathVariable("id") Long id) {
		// LOGGER.info("Organization find: id={}", id);
		Organisation organisation = repository.findById(id);
		organisation.setDepartments(departmentClient.findByOrganisation(organisation.getId()));
		return organisation;
	}
	
	@GetMapping("/{id}/with-departments-and-employees")
	public Organisation findByIdWithDepartmentsAndEmployees(@PathVariable("id") Long id) {
		// LOGGER.info("Organization find: id={}", id);
		Organisation organization = repository.findById(id);
		organization.setDepartments(departmentClient.findByOrganisationWithEmployees(organization.getId()));
		return organization;
	}
	
	@GetMapping("/{id}/with-employees")
	public Organisation findByIdWithEmployees(@PathVariable("id") Long id) {
		// LOGGER.info("Organization find: id={}", id);
		Organisation organization = repository.findById(id);
		organization.setEmployees(employeeClient.findByOrganization(organization.getId()));
		return organization;
	}

}
