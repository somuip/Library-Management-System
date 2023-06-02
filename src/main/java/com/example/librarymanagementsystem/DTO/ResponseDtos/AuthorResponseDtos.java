package com.example.librarymanagementsystem.DTO.ResponseDtos;

import com.example.librarymanagementsystem.model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AuthorResponseDtos {
    private int id;
    private String name;
    private String email;
    private String  qualification;
    private List<Book> books;
}
