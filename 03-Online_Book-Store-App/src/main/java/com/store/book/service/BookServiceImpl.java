package com.store.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.book.entity.Book;
import com.store.book.repo.BookRepository;
@Service
public class BookServiceImpl implements BookService {

	 @Autowired
	    private BookRepository bookRepository;

	    @Override
	    public List<Book> getAllBooks() {
	        return bookRepository.findAll();
	    }

	    @Override
	    public Book getBookById(Long id) {
	        return bookRepository.findById(id).orElse(null);
	    }

	    @Override
	    public Book saveBook(Book book) {
	        return bookRepository.save(book);
	    }

	    @Override
	    public Book updateBook(Long id, Book updatedBook) {
	        Optional<Book> optional = bookRepository.findById(id);
	        if (optional.isPresent()) {
	            Book book = optional.get();
	            book.setTitle(updatedBook.getTitle());
	            book.setAuthor(updatedBook.getAuthor());
	            book.setPrice(updatedBook.getPrice());
	            return bookRepository.save(book);
	        }
	        return null;
	    }

	    @Override
	    public void deleteBook(Long id) {
	        bookRepository.deleteById(id);
	    }
}
