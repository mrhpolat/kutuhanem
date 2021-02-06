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

import com.ktpo.kutuhanem.Service.BookService;
import com.ktpo.kutuhanem.model.Books;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService service;

	@GetMapping("/list")
	public ResponseEntity<List<Books>> getAllEmployees() {
		List<Books> list = service.getAllBooks();
		
		return new ResponseEntity<List<Books>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Books> getEmployeeById(@PathVariable("id") Long id) throws Exception {
		Books entity = service.getBookId(id);

		return new ResponseEntity<Books>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/ins")
	public ResponseEntity<Books> createOrUpdateEmployee(@RequestBody Books user) throws Exception {
		Books updated = service.createOrUpdateBook(user);
		return new ResponseEntity<Books>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/del/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws Exception {
		service.deleteBookById(id);
		return HttpStatus.FORBIDDEN;
	}
}
