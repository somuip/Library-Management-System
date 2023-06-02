package com.example.librarymanagementsystem.DTO.ResponseDtos;

import com.example.librarymanagementsystem.enums.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CardResponseDto {

    private int id;

    private Date issueDate;

//    private CardStatus cardStatus;

    private String validTill;

}
