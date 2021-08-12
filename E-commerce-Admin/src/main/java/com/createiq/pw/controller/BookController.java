package com.createiq.pw.controller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.createiq.pw.domin.Book;
import com.createiq.pw.domin.ResponseBean;
import com.createiq.pw.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Value("${upload_folder}")
	private String UPLOAD_FOLDER; 
	
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

	
	@PostMapping(value="/saveWithImg", consumes =MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseBean saveWithImg(@RequestPart("book") String bookString , @RequestPart("file") MultipartFile file) {
		
		Book book = new Book();
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			book = mapper.readValue(bookString, Book.class);
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		
		book  = bookService.saveOrUpdate(book);

		try {
			// read and write the file to the selected location-
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOAD_FOLDER +book.getId()+".png");
			Files.write(path, bytes);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		ResponseBean responseBean = new ResponseBean();
		responseBean.setStatus(201);
		responseBean.setResult(book);
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
