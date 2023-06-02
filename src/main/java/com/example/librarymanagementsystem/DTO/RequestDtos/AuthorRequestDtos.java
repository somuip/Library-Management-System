package com.example.librarymanagementsystem.DTO.RequestDtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AuthorRequestDtos {

    private String name;

    private String email;

    private String qualification;
}
