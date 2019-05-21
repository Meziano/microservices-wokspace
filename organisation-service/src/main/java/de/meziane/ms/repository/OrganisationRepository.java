package de.meziane.ms.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import de.meziane.ms.model.Organisation;

public class OrganisationRepository {
	
private List<Organisation> organizations = new ArrayList<>();
	
	public Organisation add(Organisation organization) {
		organization.setId((long) (organizations.size()+1));
		organizations.add(organization);
		return organization;
	}
	
	public Organisation findById(Long id) {
		Optional<Organisation> organization = organizations.stream().filter(a -> a.getId().equals(id)).findFirst();
		if (organization.isPresent())
			return organization.get();
		else
			return null;
	}
	
	public List<Organisation> findAll() {
		return organizations;
	}


}
