package com.createiq.pw.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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

import com.createiq.pw.domin.Book;
import com.createiq.pw.domin.ResponseBean;
import com.createiq.pw.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(BookController.class);

	@Value("${upload_folder}")
	private String UPLOAD_FOLDER;

	@Autowired
	private BookService bookService;

	@GetMapping("/findAll")
	@ApiOperation(value = "View a list of available Book", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<?> findAll() {
		// LOGGER.info("### Find All Controller method invoked ###");
		// LOGGER.info("### Find All Controller method END ###");
		log.info("### Find All Controller method invoked ###");
		log.info("### Find All Controller method END ###");
		return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Book book) {
		// LOGGER.debug("Book", book);
		log.debug("Book", book);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "foo");
		ResponseEntity<?> responseEntity = new ResponseEntity<>(bookService.saveOrUpdate(book), headers,
				HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping(value = "/saveWithImg", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseBean saveWithImg(@RequestPart("book") String bookString, @RequestPart("file") MultipartFile file) {
		// LOGGER.debug(bookString);
		log.debug(bookString);
		Book book = new Book();
		ObjectMapper mapper = new ObjectMapper();
		try {
			book = mapper.readValue(bookString, Book.class);
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
			// LOGGER.error(e1.getMessage());
			log.error(e1.getMessage());
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}

		book = bookService.saveOrUpdate(book);

		try {
			// read and write the file to the selected location-
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOAD_FOLDER + book.getId() + ".png");
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

	@ApiOperation(value = "Delete Book", response = Object.class)
	@DeleteMapping
	public ResponseBean delete(@RequestParam("bid") Integer bid) {
		ResponseBean responseBean = new ResponseBean();
		responseBean.setStatus(203);
		bookService.delete(bid);
		responseBean.setResult("Deleted Successfully with id : " + bid);
		return responseBean;
	}

	@GetMapping
	public ResponseEntity<?> findById(@RequestParam("bid") Integer bid) {
		return new ResponseEntity<>(bookService.findById(bid), HttpStatus.OK);
	}

}
