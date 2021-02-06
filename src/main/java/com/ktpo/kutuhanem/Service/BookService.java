package com.ktpo.kutuhanem.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktpo.kutuhanem.model.Books;
import com.ktpo.kutuhanem.repo.BooksRepository;

@Service
public class BookService {

	@Autowired
	BooksRepository repository;

	public List<Books> getAllBooks() {
		List<Books> bookList = repository.findAll();
		if (bookList.size() > 0)
			return bookList;
		else
			return new ArrayList<Books>();

	}

	public Books getBookId(Long id) throws Exception {
		Optional<Books> book = repository.findById(id);

		if (book.isPresent())
			return book.get();
		else
			throw new Exception("No employee record exist for given id");
	}

	public Books createOrUpdateBook(Books entity) throws Exception {
		return repository.save(entity);
	}

	public void deleteBookById(Long id) throws Exception {
		Optional<Books> book = repository.findById(id);

		if (book.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new Exception("No employee record exist for given id");
		}
	}

}
