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

import com.ktpo.kutuhanem.Service.BookTypeService;
import com.ktpo.kutuhanem.model.BookType;

@RestController
@RequestMapping("/booktype")
public class BookTypeController {

	@Autowired
	private BookTypeService service;

	@GetMapping("/list")
	public ResponseEntity<List<BookType>> getAllEmployees() {
		List<BookType> list = service.getAllBookTypes();
		
		return new ResponseEntity<List<BookType>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookType> getEmployeeById(@PathVariable("id") Long id) throws Exception {
		BookType entity = service.getBookTypeId(id);
				
		return new ResponseEntity<BookType>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/ins")
	public ResponseEntity<BookType> createOrUpdateEmployee(@RequestBody BookType user) throws Exception {
		System.out.println(user.toString());
		BookType updated = service.createOrUpdateBookType(user);
		return new ResponseEntity<BookType>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/del/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws Exception {
		service.deleteBookTypeById(id);
		return HttpStatus.FORBIDDEN;
	}
}
