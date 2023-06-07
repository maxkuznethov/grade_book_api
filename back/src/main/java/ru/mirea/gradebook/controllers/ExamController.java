package ru.mirea.gradebook.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.mirea.gradebook.dto.ExamRequestDTO;
import ru.mirea.gradebook.dto.ExamResponseDTO;
import ru.mirea.gradebook.models.Exam;
import ru.mirea.gradebook.models.Subject;
import ru.mirea.gradebook.services.ExamService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/exams")
public class ExamController {
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping("add")
    public ExamRequestDTO addExam(@RequestBody ExamRequestDTO examRequestDTO) {
        return examService.addExam(examRequestDTO);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<ExamResponseDTO> getAllExams() {
        return examService.getExams();
    }


    @PutMapping("edit")
    @PreAuthorize("hasRole('ADMIN')")
    public ExamResponseDTO updateMark(@RequestBody Exam exam) {
        return examService.changeMark(exam);
    }

    @GetMapping("/get/{id}")
    public List<ExamResponseDTO> getUserExams(@PathVariable Long id) {
        return examService.getUserExams(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
    }
/*
    @GetMapping("exam/get")
    public List<ExamResponseDTO> getCurrentUserExams() {
        return examService.getCurrentUserExams();
    }*/
}
