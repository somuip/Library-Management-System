package com.example.librarymanagementsystem.DTO.RequestDtos;

import com.example.librarymanagementsystem.enums.Genre;
import com.example.librarymanagementsystem.model.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookRequestDtos {

    private String title;
    private int authorId;
    private Genre genre;
    private int noOfPages;
    private int prices;
}
