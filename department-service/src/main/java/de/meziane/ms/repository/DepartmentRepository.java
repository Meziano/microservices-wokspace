package de.meziane.ms.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import de.meziane.ms.model.Department;

public class DepartmentRepository {
	
private List<Department> departments = new ArrayList<>();
	
	public Department add(Department department) {
		department.setId((long) (departments.size()+1));
		departments.add(department);
		return department;
	}
	
	public Department findById(Long id) {
		Optional<Department> department = departments.stream().filter(a -> a.getId().equals(id)).findFirst();
		if (department.isPresent())
			return department.get();
		else
			return null;
	}
	
	public List<Department> findAll() {
		return departments;
	}
	
	public List<Department> findByOrganisation(Long organisationId) {
		return departments.stream().filter(a -> a.getOrganisationId().equals(organisationId)).collect(Collectors.toList());
	}


}
