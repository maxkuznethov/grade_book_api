package ru.mirea.gradebook.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.mirea.gradebook.models.Teacher;
import ru.mirea.gradebook.services.TeacherService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @PostMapping("add")
    @PreAuthorize("hasRole('ADMIN')")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @PutMapping("edit")
    @PreAuthorize("hasRole('ADMIN')")
    public Teacher updateTeacher(@RequestBody Teacher teacher) {
        return teacherService.updateTeacher(teacher);
    }
/*
    @DeleteMapping("teacher/delete/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }*/
}
