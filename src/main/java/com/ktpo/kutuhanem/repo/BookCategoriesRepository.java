package com.ktpo.kutuhanem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ktpo.kutuhanem.model.BookCategories;

@Repository
public interface BookCategoriesRepository extends JpaRepository<BookCategories, Long>{

}
