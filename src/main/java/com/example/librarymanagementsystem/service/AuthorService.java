package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.RequestDtos.AuthorRequestDtos;
import com.example.librarymanagementsystem.DTO.ResponseDtos.AuthorResponseDtos;
import com.example.librarymanagementsystem.exceptions.AuthorNotFoundException;
import com.example.librarymanagementsystem.model.Author;

public interface AuthorService {

    public AuthorResponseDtos addAuthor(AuthorRequestDtos authorRequestDtos);

    AuthorResponseDtos getAuthorByEmail(String email) throws AuthorNotFoundException;

}
