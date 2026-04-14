// language: java
package com.store.book;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.book.entity.Book;
import com.store.book.restcontroller.BookController;
import com.store.book.service.BookServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookServiceImpl service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllBooks_returnsList() throws Exception {
        Book b1 = new Book();
        b1.setId(1L);
        b1.setTitle("Title A");
        Book b2 = new Book();
        b2.setId(2L);
        b2.setTitle("Title B");

        when(service.getAllBooks()).thenReturn(List.of(b1, b2));

        mockMvc.perform(get("/api/books"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[0].title").value("Title A"))
            .andExpect(jsonPath("$[1].id").value(2))
            .andExpect(jsonPath("$[1].title").value("Title B"));

        verify(service).getAllBooks();
    }

    @Test
    void getBookById_returnsBook() throws Exception {
        Book book = new Book();
        book.setId(5L);
        book.setTitle("Some Book");

        when(service.getBookById(5L)).thenReturn(book);

        mockMvc.perform(get("/api/books/{id}", 5L))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(5))
            .andExpect(jsonPath("$.title").value("Some Book"));

        verify(service).getBookById(5L);
    }

    @Test
    void addBook_createsAndReturnsBook() throws Exception {
        Book input = new Book();
        input.setTitle("New Book");
        Book saved = new Book();
        saved.setId(10L);
        saved.setTitle("New Book");

        when(service.saveBook(any(Book.class))).thenReturn(saved);

        mockMvc.perform(post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(input)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(10))
            .andExpect(jsonPath("$.title").value("New Book"));

        verify(service).saveBook(any(Book.class));
    }

    @Test
    void updateBook_updatesAndReturnsBook() throws Exception {
        Book input = new Book();
        input.setTitle("Updated Title");
        Book updated = new Book();
        updated.setId(2L);
        updated.setTitle("Updated Title");

        when(service.updateBook(eq(2L), any(Book.class))).thenReturn(updated);

        mockMvc.perform(put("/api/books/{id}", 2L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(input)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(2))
            .andExpect(jsonPath("$.title").value("Updated Title"));

        verify(service).updateBook(eq(2L), any(Book.class));
    }

    @Test
    void deleteBook_deletes() throws Exception {
        doNothing().when(service).deleteBook(3L);

        mockMvc.perform(delete("/api/books/{id}", 3L))
            .andExpect(status().isOk());

        verify(service).deleteBook(3L);
    }
}
