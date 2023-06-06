package com.example.librarymanagementsystem.service.imple;

import com.example.librarymanagementsystem.DTO.RequestDtos.AuthorRequestDtos;
import com.example.librarymanagementsystem.DTO.RequestDtos.BookRequestDtos;
import com.example.librarymanagementsystem.DTO.ResponseDtos.AuthorResponseDtos;
import com.example.librarymanagementsystem.DTO.ResponseDtos.BookResponseDtos;
import com.example.librarymanagementsystem.exceptions.AuthorNotFoundException;
import com.example.librarymanagementsystem.model.Author;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.repository.AuthorRepository;
import com.example.librarymanagementsystem.repository.BookRepository;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImple implements BookService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;


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

    @Override
    public List<BookResponseDtos> findAllBooks() {
        List<Book> bookList = bookRepository.findAll();

        List<BookResponseDtos> bookResponseDtosList = new ArrayList<>();

        for(Book book:bookList){
            // prepare response dto;
            BookResponseDtos bookResponseDtos = new BookResponseDtos();
            bookResponseDtos.setId(book.getId());
            bookResponseDtos.setTitle(book.getTitle());
            bookResponseDtos.setAuthor(book.getAuthor());
            bookResponseDtosList.add(bookResponseDtos);
        }
        return bookResponseDtosList;
    }

    @Override
    public List<BookResponseDtos> findAllBooksOfAuthor(int authorId) throws AuthorNotFoundException {
        Author author = new Author();
        try{
            author = authorRepository.findById(authorId).get();
        }catch (Exception e){
            throw new AuthorNotFoundException("Author does not exist!!");
        }
        List<Book> bookList = new ArrayList<>();
        for(Book book:bookRepository.findAll()){
            if(book.getAuthor().equals(author)){
                bookList.add(book);
            }
        }

        List<BookResponseDtos> bookResponseDtosList = new ArrayList<>();
        for(Book book:bookList){
            // prepare response dto;
            BookResponseDtos bookResponseDtos = new BookResponseDtos();
            bookResponseDtos.setId(book.getId());
            bookResponseDtos.setTitle(book.getTitle());
            bookResponseDtos.setAuthor(book.getAuthor());
            bookResponseDtosList.add(bookResponseDtos);
        }
        return bookResponseDtosList;
    }

    @Override
    public int findNumberOfBooksOfAuthor(int authorId) throws AuthorNotFoundException {
        Author author = new Author();
        try{
            author = authorRepository.findById(authorId).get();
        }catch (Exception e){
            throw new AuthorNotFoundException("Author does not exist!!");
        }

        int numberOfBooks = 0;
        for(Book book:bookRepository.findAll()){
            if(book.getAuthor().equals(author)){
                numberOfBooks++;
            }
        }
        return numberOfBooks;
    }
}
