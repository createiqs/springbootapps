package com.createiq.pw.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.createiq.pw.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(Product product) {
		jdbcTemplate.update("INSERT INTO PRODUCT(PID,PNAME,PCOST) VALUES(?,?,?)",
				new Object[] { product.getPid(), product.getPname(), product.getPcost() });

	}

	@Override
	public void update(Product product) {
		jdbcTemplate.update("UPDATE PRODUCT SET PNAME = ?, PCOST = ? WHERE PID = ?",
				new Object[] { product.getPname(), product.getPcost(), product.getPid() });

	}

	@Override
	public void delete(Integer pid) {
		jdbcTemplate.update("DELETE FROM PRODUCT WHERE PID = ?", pid);

	}

	@Override
	public Product findById(Integer pid) {
		return jdbcTemplate.queryForObject("SELECT * FROM PRODUCT WHERE PID = ? ", new Object[] { pid },new BeanPropertyRowMapper<Product>(Product.class));
	}

	@Override
	public List<Product> findAll() {
		return jdbcTemplate.query("SELECT * FROM PRODUCT", new BeanPropertyRowMapper(Product.class));
	}

}
