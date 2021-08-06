package com.createiq.pw.model.service;

import java.util.List;

import com.createiq.pw.model.Product;

public interface ProductService {

	void add(Product product);

	void update(Product product);

	void delete(Integer pid);

	Product findById(Integer pid);

	List<Product> findAll();

}
