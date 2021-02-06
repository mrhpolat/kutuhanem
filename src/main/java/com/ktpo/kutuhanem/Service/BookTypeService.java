package com.ktpo.kutuhanem.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktpo.kutuhanem.model.BookType;
import com.ktpo.kutuhanem.repo.BookTypeRepository;

@Service
public class BookTypeService {
	
	@Autowired
	BookTypeRepository repository;

	public List<BookType> getAllBookTypes() {
		List<BookType> bookTypeList = repository.findAll();
		if (bookTypeList.size() > 0)
			return bookTypeList;
		else
			return new ArrayList<BookType>();

	}

	public BookType getBookTypeId(Long id) throws Exception {
		Optional<BookType> bookType = repository.findById(id);

		if (bookType.isPresent())
			return bookType.get();
		else
			throw new Exception("No employee record exist for given id");
	}

	public BookType createOrUpdateBookType(BookType entity) throws Exception {
		return repository.save(entity);
	}

	public void deleteBookTypeById(Long id) throws Exception {
		Optional<BookType> bookType = repository.findById(id);

		if (bookType.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new Exception("No employee record exist for given id");
		}
	}
}
