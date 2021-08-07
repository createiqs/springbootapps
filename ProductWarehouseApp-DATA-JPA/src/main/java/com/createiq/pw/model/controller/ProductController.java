package com.createiq.pw.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.createiq.pw.model.Product;
import com.createiq.pw.model.service.ProductService;
import com.mysql.cj.result.IntegerValueFactory;

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
		return "redirect:/findAll?msg=save";
	}

	@GetMapping("/findAll")
	public String findAll(ModelMap map,@RequestParam(defaultValue="none") String msg) {
		map.addAttribute("products", productService.findAll());
		map.addAttribute("msg", getMsg(msg));
		return "findAll";
	}

	private String getMsg(String msg) {
		String flag = "";
		switch (msg) {
		case "save":
			flag = "Inserted Successfully";
			break;
		case "update":
			flag = "Updated Successfully";
			break;
		case "delete":
			flag = "Deleted Successfully";
		}
		return flag;
	}

	@GetMapping("/update")
	public String updateGet(@RequestParam("pid") Integer pid, Model model) {
		model.addAttribute("product", productService.findById(pid));
		return "updateProduct";
	}
	
	@GetMapping("/deleteById")
	public String delete(@RequestParam("pid") Integer pid) {
		productService.delete(pid);
		return "redirect:/findAll?msg=delete";
	}

	@PostMapping("/updateProduct")
	public String updateProduct(Product product) {
		productService.update(product);
		return "redirect:/findAll?msg=update";
	}

}
