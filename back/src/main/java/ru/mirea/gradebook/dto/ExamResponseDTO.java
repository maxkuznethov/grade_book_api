package ru.mirea.gradebook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExamResponseDTO {
    private String student;
    private String subject;
    private Integer term;
    private Integer hours;
    private String mark;
    private String teacher;
    private String date;
}
