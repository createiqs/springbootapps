package com.createiq.pw.service;

import java.util.List;

import com.createiq.pw.domin.User;

public interface UserService {

	User saveOrUpdate(User user);

	List<User> findAll();

	void delete(Integer id);

	User findById(Integer id);

}
