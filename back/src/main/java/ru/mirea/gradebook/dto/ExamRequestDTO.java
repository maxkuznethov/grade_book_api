package ru.mirea.gradebook.dto;

import lombok.Data;

@Data
public class ExamRequestDTO {
    private Long student;
    private Long subject;
    private Long teacher;
    private String mark;
    private String date;
}
