package com.example.librarymanagementsystem.DTO.ResponseDtos;

import com.example.librarymanagementsystem.enums.Department;
import com.example.librarymanagementsystem.model.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GetStudentByIdResponseDto {

    private int id;
    private String name;
    private int age;
    private String mobNo;
    private Department department;
    private Card card;

}
