package com.example.librarymanagementsystem.service.imple;

import com.example.librarymanagementsystem.enums.Status;
import com.example.librarymanagementsystem.model.Card;
import com.example.librarymanagementsystem.model.Student;
import com.example.librarymanagementsystem.repository.StudentRepository;
import com.example.librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImple implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addStudent(Student student) {

        Card card = new Card();
        card.setStatus(Status.ACTIVE);
        card.setValidTill("2025-01-01");
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);

        return "Student added";
    }
}
