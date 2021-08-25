package com.createiq.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.createiq.admin.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
