package com.example.librarymanagementsystem.controller;


import com.example.librarymanagementsystem.DTO.RequestDtos.DeleteStudentRequestDto;
import com.example.librarymanagementsystem.DTO.RequestDtos.GetStudentByIdRequestDto;
import com.example.librarymanagementsystem.DTO.RequestDtos.StudentRequestDtos;
import com.example.librarymanagementsystem.DTO.RequestDtos.UpdateStudentMobRequestDtos;
import com.example.librarymanagementsystem.DTO.ResponseDtos.DeleteStudentResponseDto;
import com.example.librarymanagementsystem.DTO.ResponseDtos.GetStudentByIdResponseDto;
import com.example.librarymanagementsystem.DTO.ResponseDtos.StudentResponseDtos;
import com.example.librarymanagementsystem.DTO.ResponseDtos.UpdateStudentMobResponseDtos;
import com.example.librarymanagementsystem.exceptions.StudentNotFoundException;
import com.example.librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add-student")
    public StudentResponseDtos addStudent(@RequestBody StudentRequestDtos studentRequestDtos){

        return studentService.addStudent(studentRequestDtos);
    }

    @PutMapping("/update-mobile")
    public UpdateStudentMobResponseDtos updateMobile(@RequestBody UpdateStudentMobRequestDtos updateStudentMobRequestDtos) throws StudentNotFoundException {
        return studentService.updateMobile(updateStudentMobRequestDtos);
    }

    @GetMapping("/get-student-by-id")
    public GetStudentByIdResponseDto getStudentById(@RequestBody GetStudentByIdRequestDto getStudentByIdRequestDto) throws StudentNotFoundException{
        return studentService.getStudentById(getStudentByIdRequestDto);
    }

    @DeleteMapping("/delete student")
    public DeleteStudentResponseDto deleteStudentById(@RequestBody DeleteStudentRequestDto deleteStudentRequestDto) throws StudentNotFoundException {
        return studentService.deleteStudentById(deleteStudentRequestDto);
    }


}
