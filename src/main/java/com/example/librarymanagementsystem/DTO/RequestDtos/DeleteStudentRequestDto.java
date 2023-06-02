package com.example.librarymanagementsystem.DTO.RequestDtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE) // makes all attribute private
public class DeleteStudentRequestDto {
    int id;
}
