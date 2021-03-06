package com.createiq.pw.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.createiq.pw.model.Product;
import com.createiq.pw.model.dao.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	public void add(Product product) {
		productDAO.add(product);		
	}

	@Override
	public void update(Product product) {
		productDAO.update(product);		
	}

	@Override
	public void delete(Integer pid) {
		productDAO.delete(pid);
		
	}

	@Override
	public Product findById(Integer pid) {
		return productDAO.findById(pid);
	}

	@Override
	public List<Product> findAll() {
		return productDAO.findAll();
	}
	

}
