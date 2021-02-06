package com.ktpo.kutuhanem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ktpo.kutuhanem.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

}
