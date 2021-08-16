package com.createiq.pw.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createiq.pw.ECommerceAdminApplication;
import com.createiq.pw.domin.Book;
import com.createiq.pw.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book saveOrUpdate(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> findAll() {
		log.info("### Service FindAll Invoked ###");
		return bookRepository.findAll();
	}

	@Override
	public void delete(Integer bid) {
		bookRepository.deleteById(bid);
	}

	@Override
	public Book findById(Integer bid) {
		return bookRepository.findById(bid).get();
	}

}
