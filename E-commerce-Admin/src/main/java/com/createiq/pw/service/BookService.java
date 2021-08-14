package com.createiq.pw.service;

import java.util.List;

import com.createiq.pw.domin.Book;

public interface BookService {
	
	Book saveOrUpdate(Book book);
	
	List<Book> findAll();
	
	void delete(Integer bid);

	Book findById(Integer bid);
	


}
