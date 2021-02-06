package com.ktpo.kutuhanem.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktpo.kutuhanem.model.AllAccess;
import com.ktpo.kutuhanem.repo.AllAccessRepository;

@Service
public class AllAccessService {
	
	@Autowired
	AllAccessRepository repository;

	public List<AllAccess> getAllAllAccess() {
		List<AllAccess> userList = repository.findAll();
		if (userList.size() > 0)
			return userList;
		else
			return new ArrayList<AllAccess>();

	}

	public AllAccess getAllAccessId(Long id) throws Exception {
		Optional<AllAccess> access = repository.findById(id);

		if (access.isPresent())
			return access.get();
		else
			throw new Exception("No employee record exist for given id");
	}

	public AllAccess createOrUpdateAllAccess(AllAccess entity) throws Exception {
		return repository.save(entity);
	}

	public void deleteAllAccessById(Long id) throws Exception {
		Optional<AllAccess> access = repository.findById(id);

		if (access.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new Exception("No employee record exist for given id");
		}
	}

}
