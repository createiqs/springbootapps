package com.createiq.pw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.createiq.pw.domin.Book;
import com.createiq.pw.domin.ResponseBean;
import com.createiq.pw.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping("/findAll")
	public ResponseBean findAll() {
		ResponseBean responseBean = new ResponseBean();
		responseBean.setStatus(200);
		responseBean.setResult(bookService.findAll());
		return responseBean;
	}

	@PostMapping
	public ResponseBean save(@RequestBody Book book) {
		ResponseBean responseBean = new ResponseBean();
		responseBean.setStatus(201);
		responseBean.setResult(bookService.saveOrUpdate(book));
		return responseBean;
	}

	@PutMapping
	public ResponseBean update(@RequestBody Book book) {
		ResponseBean responseBean = new ResponseBean();
		responseBean.setStatus(202);
		responseBean.setResult(bookService.saveOrUpdate(book));
		return responseBean;
	}

	@DeleteMapping
	public ResponseBean delete(@RequestParam("bid") Integer bid) {
		ResponseBean responseBean = new ResponseBean();
		responseBean.setStatus(203);
		bookService.delete(bid);
		responseBean.setResult("Deleted Successfully with id : " + bid);
		return responseBean;
	}
	
	@GetMapping
	public ResponseBean findById(@RequestParam("bid") Integer bid) {
		ResponseBean responseBean = new ResponseBean();
		responseBean.setStatus(200);
		responseBean.setResult(bookService.findById(bid));
		return responseBean;
	}

}
