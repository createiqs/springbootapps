package com.createiq.pw.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.createiq.pw.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(Product product) {
		jdbcTemplate.update("INSERT INTO PRODUCT(PID,PNAME,PCOST) VALUES(?,?,?)", new Object[] {product.getPid(),product.getPname(),product.getPcost()});
		
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer pid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product findById(Integer pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
