package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.RequestDtos.BookRequestDtos;
import com.example.librarymanagementsystem.DTO.ResponseDtos.BookResponseDtos;
import com.example.librarymanagementsystem.exceptions.AuthorNotFoundException;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add-book")
    public BookResponseDtos addBook(@RequestBody BookRequestDtos bookRequestDtos) throws AuthorNotFoundException {
        return bookService.addBook(bookRequestDtos);
    }

    @GetMapping("/find-all-books")
    public List<BookResponseDtos> getAllBooks(){
        return bookService.findAllBooks();
    }

    @GetMapping("/find-book-of-author")
    public List<BookResponseDtos> findAllBooksOfAuthor(@RequestParam("authorId") int authorId) throws AuthorNotFoundException {
        return bookService.findAllBooksOfAuthor(authorId);
    }

    @GetMapping("/find-number-of-books-author")
    public int findNumberOfBooksOfAuthor(@RequestParam("authorId") int authorId) throws AuthorNotFoundException {
        return bookService.findNumberOfBooksOfAuthor(authorId);
    }

}
