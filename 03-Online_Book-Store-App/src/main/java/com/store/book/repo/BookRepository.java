package com.store.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.book.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
