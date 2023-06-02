package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.RequestDtos.BookRequestDtos;
import com.example.librarymanagementsystem.DTO.ResponseDtos.BookResponseDtos;
import com.example.librarymanagementsystem.exceptions.AuthorNotFoundException;
import com.example.librarymanagementsystem.model.Book;

public interface BookService {

    public BookResponseDtos addBook(BookRequestDtos bookRequestDtos) throws AuthorNotFoundException;
}
