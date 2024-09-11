package com.kasim.bookstore.service;


import com.kasim.bookstore.model.Book;
import com.kasim.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book getBookById(Long id){
        return bookRepository.getById(id);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book saveBook(Book book){
        if (book.getId() != null) {
            book.setId(null);
        }
        return bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.delete(bookRepository.getReferenceById(id));
    }
}
