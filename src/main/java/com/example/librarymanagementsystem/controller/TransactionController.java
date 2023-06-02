package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.RequestDtos.IssueBookRequestDto;
import com.example.librarymanagementsystem.DTO.ResponseDtos.IssueBookResponseDto;
import com.example.librarymanagementsystem.repository.TransactionRepository;
import com.example.librarymanagementsystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue-book")
    public IssueBookResponseDto issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception {
        return transactionService.issueBook(issueBookRequestDto);
    }
}
