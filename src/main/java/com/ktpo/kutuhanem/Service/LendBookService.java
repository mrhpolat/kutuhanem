package com.ktpo.kutuhanem.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktpo.kutuhanem.model.LendBooks;
import com.ktpo.kutuhanem.repo.LendBooksRepository;

@Service
public class LendBookService {

	@Autowired
	LendBooksRepository repository;

	public List<LendBooks> getAllLendBooks() {
		List<LendBooks> lendBookList = repository.findAll();
		if (lendBookList.size() > 0)
			return lendBookList;
		else
			return new ArrayList<LendBooks>();

	}

	public LendBooks getLendBook(Long id) throws Exception {
		Optional<LendBooks> lendBook = repository.findById(id);

		if (lendBook.isPresent())
			return lendBook.get();
		else
			throw new Exception("No employee record exist for given id");
	}

	public LendBooks createOrUpdateLendBook(LendBooks entity) throws Exception {
		return repository.save(entity);
	}

	public void deleteLendBookById(Long id) throws Exception {
		Optional<LendBooks> lendBook = repository.findById(id);

		if (lendBook.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new Exception("No employee record exist for given id");
		}
	}
}
