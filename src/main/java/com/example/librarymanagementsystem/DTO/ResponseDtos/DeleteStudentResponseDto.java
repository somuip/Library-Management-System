package com.example.librarymanagementsystem.DTO.ResponseDtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE) // makes all attribute private
public class DeleteStudentResponseDto {
    int id;
    String name;
}
