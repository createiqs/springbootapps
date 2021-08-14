package com.createiq.pw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.createiq.pw.domin.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
