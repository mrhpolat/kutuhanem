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

import com.ktpo.kutuhanem.Service.LendBookService;
import com.ktpo.kutuhanem.model.LendBooks;

@RestController
@RequestMapping("lendbook")
public class LendBookController {

	@Autowired
	private LendBookService service;

	@GetMapping("/list")
	public ResponseEntity<List<LendBooks>> getAllEmployees() {
		List<LendBooks> list = service.getAllLendBooks();
		
		return new ResponseEntity<List<LendBooks>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LendBooks> getEmployeeById(@PathVariable("id") Long id) throws Exception {
		LendBooks entity = service.getLendBook(id);

		return new ResponseEntity<LendBooks>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/ins")
	public ResponseEntity<LendBooks> createOrUpdateEmployee(@RequestBody LendBooks user) throws Exception {
		System.out.println(user.toString());
		LendBooks updated = service.createOrUpdateLendBook(user);
		return new ResponseEntity<LendBooks>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/del/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws Exception {
		service.deleteLendBookById(id);
		return HttpStatus.FORBIDDEN;
	}
}
