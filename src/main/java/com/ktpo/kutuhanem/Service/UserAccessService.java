package com.ktpo.kutuhanem.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktpo.kutuhanem.model.UserAccess;
import com.ktpo.kutuhanem.repo.UserAccessRepository;

@Service
public class UserAccessService {

	@Autowired
	UserAccessRepository repository;

	public List<UserAccess> getAllUserAccess() {
		List<UserAccess> userAccessList = repository.findAll();
		if (userAccessList.size() > 0)
			return userAccessList;
		else
			return new ArrayList<UserAccess>();

	}

	public UserAccess getUserAccessId(Long id) throws Exception {
		Optional<UserAccess> userAccess = repository.findById(id);

		if (userAccess.isPresent())
			return userAccess.get();
		else
			throw new Exception("No employee record exist for given id");
	}

	public UserAccess createOrUpdateUserAccess(UserAccess entity) throws Exception {
		return repository.save(entity);
	}

	public void deleteUserAccessById(Long id) throws Exception {
		Optional<UserAccess> userAccess = repository.findById(id);

		if (userAccess.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new Exception("No employee record exist for given id");
		}
	}
}
