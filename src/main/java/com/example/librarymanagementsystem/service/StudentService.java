package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.RequestDtos.DeleteStudentRequestDto;
import com.example.librarymanagementsystem.DTO.RequestDtos.GetStudentByIdRequestDto;
import com.example.librarymanagementsystem.DTO.RequestDtos.StudentRequestDtos;
import com.example.librarymanagementsystem.DTO.RequestDtos.UpdateStudentMobRequestDtos;
import com.example.librarymanagementsystem.DTO.ResponseDtos.DeleteStudentResponseDto;
import com.example.librarymanagementsystem.DTO.ResponseDtos.GetStudentByIdResponseDto;
import com.example.librarymanagementsystem.DTO.ResponseDtos.StudentResponseDtos;
import com.example.librarymanagementsystem.DTO.ResponseDtos.UpdateStudentMobResponseDtos;
import com.example.librarymanagementsystem.exceptions.StudentNotFoundException;
import com.example.librarymanagementsystem.model.Student;

public interface StudentService {
    public StudentResponseDtos addStudent(StudentRequestDtos studentRequestDtos);

    public UpdateStudentMobResponseDtos updateMobile(UpdateStudentMobRequestDtos updateStudentMobRequestDtos) throws StudentNotFoundException;

    public GetStudentByIdResponseDto getStudentById(GetStudentByIdRequestDto getStudentByIdRequestDto) throws StudentNotFoundException;

    public DeleteStudentResponseDto deleteStudentById(DeleteStudentRequestDto deleteStudentRequestDto) throws StudentNotFoundException;
}
