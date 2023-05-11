package ru.mirea.gradebook.controllers;

import org.springframework.web.bind.annotation.*;
import ru.mirea.gradebook.dto.ExamRequestDTO;
import ru.mirea.gradebook.dto.ExamResponseDTO;
import ru.mirea.gradebook.services.ExamService;

import java.util.List;
import java.util.Map;

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
/*
    @PutMapping("exam/changeMark/{id}")
    public ExamResponseDTO changeMark(@RequestBody Map<String, String> mark, @PathVariable Long id) {
        return examService.changeMark(mark, id);
    }
*/
    @GetMapping("/get/{id}")
    public List<ExamResponseDTO> getUserExams(@PathVariable Long id) {
        return examService.getExams(id);
    }
/*
    @GetMapping("exam/get")
    public List<ExamResponseDTO> getCurrentUserExams() {
        return examService.getCurrentUserExams();
    }*/
}
