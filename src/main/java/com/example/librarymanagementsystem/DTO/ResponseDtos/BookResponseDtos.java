package com.example.librarymanagementsystem.DTO.ResponseDtos;

import com.example.librarymanagementsystem.model.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookResponseDtos {

    private int id;
    private String title;
    private Author author;
}
