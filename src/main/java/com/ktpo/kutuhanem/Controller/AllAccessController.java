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

import com.ktpo.kutuhanem.Service.AllAccessService;
import com.ktpo.kutuhanem.model.AllAccess;

@RestController
@RequestMapping("/AllAccess")
public class AllAccessController {

	@Autowired
	private AllAccessService service;

	@GetMapping("/list")
	public ResponseEntity<List<AllAccess>> getAllEmployees() {
		List<AllAccess> list = service.getAllAllAccess();
		
		return new ResponseEntity<List<AllAccess>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AllAccess> getEmployeeById(@PathVariable("id") Long id) throws Exception {
		AllAccess entity = service.getAllAccessId(id);

		return new ResponseEntity<AllAccess>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/ins")
	public ResponseEntity<AllAccess> createOrUpdateEmployee(@RequestBody AllAccess user) throws Exception {
		System.out.println(user.toString());
		AllAccess updated = service.createOrUpdateAllAccess(user);
		
		return new ResponseEntity<AllAccess>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/del/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws Exception {
		service.deleteAllAccessById(id);
		return HttpStatus.FORBIDDEN;
	}
}
