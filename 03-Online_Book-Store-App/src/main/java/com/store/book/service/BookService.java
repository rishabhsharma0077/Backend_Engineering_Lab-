package com.store.book.service;

import java.util.List;

import com.store.book.entity.Book;

public interface BookService {
	 List<Book> getAllBooks();
	    Book getBookById(Long id);
	    Book saveBook(Book book);
	    Book updateBook(Long id, Book updatedBook);
	    void deleteBook(Long id);

}
