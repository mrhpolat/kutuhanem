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

import com.ktpo.kutuhanem.Service.PublishersService;
import com.ktpo.kutuhanem.model.Publishers;


@RestController
@RequestMapping("/publisher")
public class PublisherController {

	@Autowired
	private PublishersService service;

	@GetMapping("/list")
	public ResponseEntity<List<Publishers>> getAllEmployees() {
		List<Publishers> list = service.getAllPublishers();
		
		return new ResponseEntity<List<Publishers>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Publishers> getEmployeeById(@PathVariable("id") Long id) throws Exception {
		Publishers entity = service.getPublishersId(id);

		return new ResponseEntity<Publishers>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/ins")
	public ResponseEntity<Publishers> createOrUpdateEmployee(@RequestBody Publishers user) throws Exception {
		System.out.println(user.toString());
		Publishers updated = service.createOrUpdatePublishers(user);
		return new ResponseEntity<Publishers>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/del/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws Exception {
		service.deletePublishersById(id);
		return HttpStatus.FORBIDDEN;
	}
}
