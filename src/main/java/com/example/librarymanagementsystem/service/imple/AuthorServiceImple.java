package com.example.librarymanagementsystem.service.imple;

import com.example.librarymanagementsystem.model.Author;
import com.example.librarymanagementsystem.repository.AuthorRepository;
import com.example.librarymanagementsystem.service.AuthorService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImple implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;


    @Override
    public String addAuthor(Author author) {
        authorRepository.save(author);
        return "added successfully";
    }
}
