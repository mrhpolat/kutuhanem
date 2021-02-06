package com.ktpo.kutuhanem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktpo.kutuhanem.Service.UserService;
import com.ktpo.kutuhanem.model.Users;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/list")
	public ResponseEntity<List<Users>> getAllEmployees() {
		List<Users> list = service.getAllUsers();
		
		return new ResponseEntity<List<Users>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Users> getEmployeeById(@PathVariable("id") Long id) throws Exception {
		Users entity = service.getUsersId(id);

		return new ResponseEntity<Users>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/ins")
	public ResponseEntity<Users> createOrUpdateEmployee(@RequestBody Users user) throws Exception {
		System.out.println(user.toString());
		Users updated = service.createOrUpdateEmployee(user);
		return new ResponseEntity<Users>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/del/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws Exception {
		service.deleteEmployeeById(id);
		return HttpStatus.FORBIDDEN;
	}
}
