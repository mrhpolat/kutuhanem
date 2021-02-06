package com.ktpo.kutuhanem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ktpo.kutuhanem.model.Publishers;

@Repository
public interface PublishersRepository extends JpaRepository<Publishers, Long>{

}
