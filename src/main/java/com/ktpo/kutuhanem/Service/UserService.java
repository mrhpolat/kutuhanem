package com.ktpo.kutuhanem.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktpo.kutuhanem.model.Users;
import com.ktpo.kutuhanem.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public List<Users> getAllUsers() {
		List<Users> userList = repository.findAll();
		if (userList.size() > 0)
			return userList;
		else
			return new ArrayList<Users>();

	}

	public Users getUsersId(Long id) throws Exception {
		Optional<Users> user = repository.findById(id);

		if (user.isPresent())
			return user.get();
		else
			throw new Exception("No employee record exist for given id");
	}

	public Users createOrUpdateEmployee(Users entity) throws Exception {
		return repository.save(entity);
	}

	public void deleteEmployeeById(Long id) throws Exception {
		Optional<Users> user = repository.findById(id);

		if (user.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new Exception("No employee record exist for given id");
		}
	}
}
