package com.jtf.junit5.api.service;

import org.springframework.stereotype.Service;

import com.jtf.junit5.api.model.Book;

@Service
public class BookService {

	public boolean saveBook(Book book) {
		return true;
	}
}
