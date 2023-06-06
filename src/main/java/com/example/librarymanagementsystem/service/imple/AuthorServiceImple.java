package com.example.librarymanagementsystem.service.imple;

import com.example.librarymanagementsystem.DTO.RequestDtos.AuthorRequestDtos;
import com.example.librarymanagementsystem.DTO.ResponseDtos.AuthorResponseDtos;
import com.example.librarymanagementsystem.exceptions.AuthorNotFoundException;
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
    public AuthorResponseDtos addAuthor(AuthorRequestDtos authorRequestDtos) {

        Author author = new Author();;
        author.setEmail(authorRequestDtos.getEmail());
        author.setName(authorRequestDtos.getName());
        author.setQualification(authorRequestDtos.getQualification());
        authorRepository.save(author);

        // prepare for response dto
        AuthorResponseDtos authorResponseDtos = new AuthorResponseDtos();
        authorResponseDtos.setName(author.getName());
        authorResponseDtos.setBooks(author.getBooks());
        authorResponseDtos.setId(author.getId());
        authorResponseDtos.setEmail(author.getEmail());
        authorResponseDtos.setQualification(author.getQualification());

        return authorResponseDtos;
    }

    @Override
    public AuthorResponseDtos getAuthorByEmail(String email) throws AuthorNotFoundException {
        Author author = new Author();
        try {
            author = authorRepository.findByEmail(email);
        }catch (Exception e){
            throw new AuthorNotFoundException("Please use different email!!!");
        }

        // prepare for response dto
        AuthorResponseDtos authorResponseDtos = new AuthorResponseDtos();
        authorResponseDtos.setName(author.getName());
        authorResponseDtos.setBooks(author.getBooks());
        authorResponseDtos.setId(author.getId());
        authorResponseDtos.setEmail(author.getEmail());
        authorResponseDtos.setQualification(author.getQualification());
        return authorResponseDtos;
    }
}
