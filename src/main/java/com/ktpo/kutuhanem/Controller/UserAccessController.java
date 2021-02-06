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

import com.ktpo.kutuhanem.Service.UserAccessService;
import com.ktpo.kutuhanem.model.UserAccess;


@RestController
@RequestMapping("/useraccess")
public class UserAccessController {

	@Autowired
	private UserAccessService service;

	@GetMapping("/list")
	public ResponseEntity<List<UserAccess>> getAllEmployees() {
		List<UserAccess> list = service.getAllUserAccess();
		
		return new ResponseEntity<List<UserAccess>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserAccess> getEmployeeById(@PathVariable("id") Long id) throws Exception {
		UserAccess entity = service.getUserAccessId(id);

		return new ResponseEntity<UserAccess>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/ins")
	public ResponseEntity<UserAccess> createOrUpdateEmployee(@RequestBody UserAccess user) throws Exception {
		System.out.println(user.toString());
		UserAccess updated = service.createOrUpdateUserAccess(user);
		return new ResponseEntity<UserAccess>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/del/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws Exception {
		service.deleteUserAccessById(id);
		return HttpStatus.FORBIDDEN;
	}
}
