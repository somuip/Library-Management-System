package com.example.librarymanagementsystem.service.imple;

import com.example.librarymanagementsystem.DTO.RequestDtos.AuthorRequestDtos;
import com.example.librarymanagementsystem.DTO.RequestDtos.BookRequestDtos;
import com.example.librarymanagementsystem.DTO.ResponseDtos.AuthorResponseDtos;
import com.example.librarymanagementsystem.DTO.ResponseDtos.BookResponseDtos;
import com.example.librarymanagementsystem.exceptions.AuthorNotFoundException;
import com.example.librarymanagementsystem.model.Author;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.repository.AuthorRepository;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImple implements BookService {

    @Autowired
    AuthorRepository authorRepository;


    @Override
    public BookResponseDtos addBook(BookRequestDtos bookRequestDtos) throws AuthorNotFoundException {

        Author author;
        try{
            author = authorRepository.findById(bookRequestDtos.getAuthorId()).get();
        }
        catch (Exception e){
            throw  new AuthorNotFoundException("Author not exist");
        }

        Book book = new Book();
        book.setAuthor(author);
        book.setGenre(bookRequestDtos.getGenre());
        book.setTitle(bookRequestDtos.getTitle());
        book.setPrice(bookRequestDtos.getPrices());
        book.setNoOfPages(bookRequestDtos.getNoOfPages());
        author.getBooks().add(book);
        book.setAuthor(author);
        authorRepository.save(author);

        // prepare response dto;
        BookResponseDtos bookResponseDtos = new BookResponseDtos();
        bookResponseDtos.setId(book.getId());
        bookResponseDtos.setTitle(book.getTitle());
        bookResponseDtos.setAuthor(book.getAuthor());

        return bookResponseDtos;
    }
}
