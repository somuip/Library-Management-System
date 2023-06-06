package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.RequestDtos.BookRequestDtos;
import com.example.librarymanagementsystem.DTO.ResponseDtos.BookResponseDtos;
import com.example.librarymanagementsystem.exceptions.AuthorNotFoundException;
import com.example.librarymanagementsystem.model.Book;

import java.util.List;

public interface BookService {

    public BookResponseDtos addBook(BookRequestDtos bookRequestDtos) throws AuthorNotFoundException;

    List<BookResponseDtos> findAllBooks();

    List<BookResponseDtos> findAllBooksOfAuthor(int authorId) throws AuthorNotFoundException;

    int findNumberOfBooksOfAuthor(int authorId) throws AuthorNotFoundException;
}
