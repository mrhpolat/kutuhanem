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

import com.ktpo.kutuhanem.Service.WriterService;
import com.ktpo.kutuhanem.model.Writers;

@RestController
@RequestMapping("/writer")
public class WriterController {

	@Autowired
	private WriterService service;

	@GetMapping("/list")
	public ResponseEntity<List<Writers>> getAllEmployees() {
		List<Writers> list = service.getAllWriters();
		
		return new ResponseEntity<List<Writers>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Writers> getEmployeeById(@PathVariable("id") Long id) throws Exception {
		Writers entity = service.getWritersId(id);
		
		return new ResponseEntity<Writers>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/ins")
	public ResponseEntity<Writers> createOrUpdateEmployee(@RequestBody Writers user) throws Exception {
		System.out.println(user.toString());
		Writers updated = service.createOrUpdateWriter(user);
		return new ResponseEntity<Writers>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/del/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws Exception {
		service.deleteWriterById(id);
		return HttpStatus.FORBIDDEN;
	}
}
