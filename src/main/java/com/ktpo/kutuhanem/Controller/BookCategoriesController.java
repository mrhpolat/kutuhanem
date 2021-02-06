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

import com.ktpo.kutuhanem.Service.BookCategoriesService;
import com.ktpo.kutuhanem.model.BookCategories;

@RestController
@RequestMapping("/bookcat")
public class BookCategoriesController {

	@Autowired
	private BookCategoriesService service;

	@GetMapping("/list")
	public ResponseEntity<List<BookCategories>> getAllEmployees() {
		List<BookCategories> list = service.getAllBookCategoriesService();
		
		return new ResponseEntity<List<BookCategories>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookCategories> getEmployeeById(@PathVariable("id") Long id) throws Exception {
		BookCategories entity = service.getBookCategoriesId(id);

		return new ResponseEntity<BookCategories>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/ins")
	public ResponseEntity<BookCategories> createOrUpdateEmployee(@RequestBody BookCategories user) throws Exception {
		System.out.println(user.toString());
		BookCategories updated = service.createOrUpdateBookCategories(user);
		return new ResponseEntity<BookCategories>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/del/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws Exception {
		service.deleteBookCategoriesById(id);
		return HttpStatus.FORBIDDEN;
	}
}
