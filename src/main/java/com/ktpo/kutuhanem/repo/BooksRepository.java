package com.ktpo.kutuhanem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ktpo.kutuhanem.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long>{

}
