package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.RequestDtos.AuthorRequestDtos;
import com.example.librarymanagementsystem.DTO.ResponseDtos.AuthorResponseDtos;
import com.example.librarymanagementsystem.exceptions.AuthorNotFoundException;
import com.example.librarymanagementsystem.model.Author;
import com.example.librarymanagementsystem.service.AuthorService;
import com.example.librarymanagementsystem.service.imple.AuthorServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add-author")
    public AuthorResponseDtos addAuthor(@RequestBody AuthorRequestDtos authorRequestDtos){
        return authorService.addAuthor(authorRequestDtos);
    }

    @GetMapping("/get-by-email")
    public AuthorResponseDtos getAuthorByEmail(@RequestParam("email") String email) throws AuthorNotFoundException {
        return authorService.getAuthorByEmail(email);
    }
}
