package com.ktpo.kutuhanem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ktpo.kutuhanem.model.UserAccess;

@Repository
public interface UserAccessRepository extends JpaRepository<UserAccess, Long>{

}
