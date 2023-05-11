package ru.mirea.gradebook.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.mirea.gradebook.models.Subject;
import ru.mirea.gradebook.services.SubjectService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @PostMapping("add")
    @PreAuthorize("hasRole('ADMIN')")
    public Subject addSubject(@RequestBody Subject subject) {
        return subjectService.addSubject(subject);
    }

    @PutMapping("edit")
    @PreAuthorize("hasRole('ADMIN')")
    public Subject updateSubject(@RequestBody Subject subject) {
        return subjectService.updateSubject(subject);
    }

    @DeleteMapping("subject/delete/{id}")
    public void deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
    }

}
