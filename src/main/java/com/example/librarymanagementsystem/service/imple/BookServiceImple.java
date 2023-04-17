package com.example.librarymanagementsystem.service.imple;

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
    public String addBook(Book book) {

        Author author;
        try{
            author = authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e){
            return "author not exist";
        }

        author.getBooks().add(book);
        book.setAuthor(author);
        authorRepository.save(author);
        return "Book added";
    }
}
