package com.ktpo.kutuhanem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ktpo.kutuhanem.model.LendBooks;

@Repository
public interface LendBooksRepository extends JpaRepository<LendBooks, Long>{

}
