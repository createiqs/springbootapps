package com.createiq.pw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.createiq.pw.domin.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
