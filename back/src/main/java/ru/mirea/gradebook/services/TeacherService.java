package ru.mirea.gradebook.services;

import org.springframework.stereotype.Service;
import ru.mirea.gradebook.models.Teacher;
import ru.mirea.gradebook.repositories.TeacherRepository;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Teacher teacher) {
        Teacher teacherToUpdate = teacherRepository.getReferenceById(teacher.getId());
        if (teacher.getName() != null && !teacher.getName().equals("")) {
            teacherToUpdate.setName(teacher.getName());
        }
        if (teacher.getPosition() != null && !teacher.getPosition().equals("")) {
            teacherToUpdate.setPosition(teacher.getPosition());
        }

        return teacherRepository.save(teacherToUpdate);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
