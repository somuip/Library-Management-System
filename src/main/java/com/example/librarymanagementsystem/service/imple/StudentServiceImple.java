package com.example.librarymanagementsystem.service.imple;

import com.example.librarymanagementsystem.DTO.RequestDtos.DeleteStudentRequestDto;
import com.example.librarymanagementsystem.DTO.RequestDtos.GetStudentByIdRequestDto;
import com.example.librarymanagementsystem.DTO.RequestDtos.StudentRequestDtos;
import com.example.librarymanagementsystem.DTO.RequestDtos.UpdateStudentMobRequestDtos;
import com.example.librarymanagementsystem.DTO.ResponseDtos.*;
import com.example.librarymanagementsystem.enums.CardStatus;
import com.example.librarymanagementsystem.exceptions.StudentNotFoundException;
import com.example.librarymanagementsystem.model.Card;
import com.example.librarymanagementsystem.model.Student;
import com.example.librarymanagementsystem.repository.CardRepository;
import com.example.librarymanagementsystem.repository.StudentRepository;
import com.example.librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImple implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CardRepository cardRepository;

    @Override
    public StudentResponseDtos addStudent(StudentRequestDtos studentRequestDtos) {

        Student student = new Student();
        student.setMobNo(studentRequestDtos.getMobNo());
        student.setAge(studentRequestDtos.getAge());
        student.setName(studentRequestDtos.getName());
        student.setDepartment(studentRequestDtos.getDepartment());
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidTill("2025-01-01");
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);

        // prepare  response dto
        CardResponseDto cardResponseDto = new CardResponseDto();
        cardResponseDto.setId(card.getId());
        cardResponseDto.setIssueDate(card.getIssueDate());
        cardResponseDto.setValidTill(card.getValidTill());

        StudentResponseDtos studentResponseDtos = new StudentResponseDtos();
        studentResponseDtos.setName(student.getName());
        studentResponseDtos.setId(student.getId());
        studentResponseDtos.setAge(studentRequestDtos.getAge());
        studentResponseDtos.setMobNo(studentRequestDtos.getMobNo());
        studentResponseDtos.setDepartment(studentRequestDtos.getDepartment());
        studentResponseDtos.setCardResponseDto(cardResponseDto);
        return studentResponseDtos;
    }

    @Override
    public UpdateStudentMobResponseDtos updateMobile(UpdateStudentMobRequestDtos updateStudentMobRequestDtos) throws StudentNotFoundException {

        try{
            Student student = studentRepository.findById(updateStudentMobRequestDtos.getId()).get();
             student.setMobNo(updateStudentMobRequestDtos.getMobNo());
             studentRepository.save(student);

             // prepare for response dto
             UpdateStudentMobResponseDtos updateStudentMobResponseDtos = new UpdateStudentMobResponseDtos();
             updateStudentMobResponseDtos.setName(student.getName());
             updateStudentMobResponseDtos.setMobNo(student.getMobNo());
             return updateStudentMobResponseDtos;
        }
        catch (Exception e){
            throw new StudentNotFoundException("Student not found");
        }
    }

    @Override
    public GetStudentByIdResponseDto getStudentById(GetStudentByIdRequestDto getStudentByIdRequestDto) throws StudentNotFoundException {
        try{
            Student student = studentRepository.findById(getStudentByIdRequestDto.getId()).get();

            //prepare for response
            GetStudentByIdResponseDto getStudentByIdResponseDto = new GetStudentByIdResponseDto();
            getStudentByIdResponseDto.setName(student.getName());
            getStudentByIdResponseDto.setId(student.getId());
            getStudentByIdResponseDto.setAge(student.getAge());
            getStudentByIdResponseDto.setMobNo(student.getMobNo());
            getStudentByIdResponseDto.setDepartment(student.getDepartment());
            getStudentByIdResponseDto.setCard(student.getCard());
            return getStudentByIdResponseDto;
        }
        catch (Exception e){
            throw new StudentNotFoundException("Student not found");
        }
    }

    @Override
    public DeleteStudentResponseDto deleteStudentById(DeleteStudentRequestDto deleteStudentRequestDto) throws StudentNotFoundException {
        Student student;
        try{
            student = studentRepository.findById(deleteStudentRequestDto.getId()).get();
        }
        catch (Exception e){
            throw new StudentNotFoundException("Student Id is not valid");
        }

        studentRepository.delete(student);
        // delete card also
        Card card = new Card();
        card = student.getCard();
        cardRepository.delete(card);

        //make response dto
        DeleteStudentResponseDto deleteStudentResponseDto = new DeleteStudentResponseDto();
        deleteStudentResponseDto.setId(student.getId());
        deleteStudentResponseDto.setName(student.getName());
        return deleteStudentResponseDto;
    }
}
