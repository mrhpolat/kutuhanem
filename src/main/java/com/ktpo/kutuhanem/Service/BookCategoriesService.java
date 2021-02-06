package com.ktpo.kutuhanem.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktpo.kutuhanem.model.BookCategories;
import com.ktpo.kutuhanem.repo.BookCategoriesRepository;

@Service
public class BookCategoriesService {

	@Autowired
	BookCategoriesRepository repository;

	public List<BookCategories> getAllBookCategoriesService() {
		List<BookCategories> bookCat = repository.findAll();
		if (bookCat.size() > 0)
			return bookCat;
		else
			return new ArrayList<BookCategories>();

	}

	public BookCategories getBookCategoriesId(Long id) throws Exception {
		Optional<BookCategories> bookCat = repository.findById(id);

		if (bookCat.isPresent())
			return bookCat.get();
		else
			throw new Exception("No employee record exist for given id");
	}

	public BookCategories createOrUpdateBookCategories(BookCategories entity) throws Exception {
		return repository.save(entity);
	}

	public void deleteBookCategoriesById(Long id) throws Exception {
		Optional<BookCategories> bookCat = repository.findById(id);

		if (bookCat.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new Exception("No employee record exist for given id");
		}
	}
}
