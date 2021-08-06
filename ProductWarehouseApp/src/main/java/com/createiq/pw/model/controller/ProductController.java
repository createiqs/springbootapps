package com.createiq.pw.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.createiq.pw.model.Product;
import com.createiq.pw.model.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@GetMapping("/newProduct")
	public String newProduct() {
		return "newProduct";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(Product product) {
		productService.add(product);
		return "success";
	}
}
