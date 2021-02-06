package com.ktpo.kutuhanem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ktpo.kutuhanem.model.BookType;

@Repository
public interface BookTypeRepository extends JpaRepository<BookType, Long>{

}
