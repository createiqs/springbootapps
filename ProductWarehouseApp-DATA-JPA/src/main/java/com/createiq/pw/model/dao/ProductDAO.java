package com.createiq.pw.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.createiq.pw.model.Product;

public interface ProductDAO extends JpaRepository<Product, Integer>{

	//SELECT * FROM PRODUCT WHERE PNAME = ? and PCOST = ?
	List<Product> findByPnameAndPcost(String pname,Double pcost);
}
