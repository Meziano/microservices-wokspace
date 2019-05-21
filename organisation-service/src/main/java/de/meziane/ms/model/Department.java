package de.meziane.ms.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;



@AllArgsConstructor
@Data
public class Department {
	
	private Long id;
	private Long organizationId;
	private String name;
	private List<Employee> employees = new ArrayList<>();
	

}
