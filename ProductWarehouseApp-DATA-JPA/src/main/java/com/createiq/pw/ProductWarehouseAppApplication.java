package com.createiq.pw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.createiq.pw.model.Product;
import com.createiq.pw.model.dao.ProductDAO;

@SpringBootApplication
public class ProductWarehouseAppApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProductWarehouseAppApplication.class, args);
	}

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public void run(String... args) throws Exception {
//		Product product = new Product();
//		product.setPid(1021);
//		product.setPname("Test");
//		product.setPcost(23000.00);
//      		productDAO.add(product);
//      		System.out.println("Success");
	}

}
