package com.createiq.pw.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.createiq.pw.model.Product;
import com.createiq.pw.model.ResponBean;
import com.createiq.pw.model.service.ProductService;

@RestController
@RequestMapping("/products/api")
@CrossOrigin(origins = "*")
public class ProductRestController {
	@Autowired
	private ProductService productService;

	@PostMapping("/add")
	public ResponBean add(@RequestBody Product product) {
		productService.add(product);
		return new ResponBean(201, "Inserted Successfully");
	}

	@PostMapping("/update")
	public ResponBean update(@RequestBody Product product) {
		productService.update(product);
		return new ResponBean(202, "Updated Successfully");
	}

	@DeleteMapping("/delete")
	public ResponBean delete(@RequestParam("pid") Integer pid) {
		if (productService.findById(pid) == null) {
			return new ResponBean(404, "Record not found");
		}
		productService.delete(pid);
		return new ResponBean(203, "Deleted Successfully");
	}

	@GetMapping("/findById")
	public Product findById(@RequestParam("pid") Integer pid) {
		return productService.findById(pid);
	}

	@GetMapping("/findAll")
	public List<Product> findAll() {
		return productService.findAll();
	}

}
