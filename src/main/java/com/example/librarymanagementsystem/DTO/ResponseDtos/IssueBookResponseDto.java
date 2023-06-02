package com.example.librarymanagementsystem.DTO.ResponseDtos;

import com.example.librarymanagementsystem.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class IssueBookResponseDto {

    private String transactionNumber;
    private TransactionStatus transactionStatus;
    private String bookName;
}
