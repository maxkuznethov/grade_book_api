package ru.mirea.gradebook.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.mirea.gradebook.dto.ExamRequestDTO;
import ru.mirea.gradebook.dto.ExamResponseDTO;
import ru.mirea.gradebook.models.Exam;
import ru.mirea.gradebook.repositories.ExamRepository;
import ru.mirea.gradebook.repositories.SubjectRepository;
import ru.mirea.gradebook.repositories.TeacherRepository;
import ru.mirea.gradebook.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ExamService {
    private final ExamRepository examRepository;
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;
    private final UserRepository userRepository;


    public ExamService(ExamRepository examRepository, SubjectRepository subjectRepository,
                       TeacherRepository teacherRepository, UserRepository userRepository) {
        this.examRepository = examRepository;
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
        this.userRepository = userRepository;
    }

    public ExamRequestDTO addExam(ExamRequestDTO examRequestDTO) {
        Exam exam = new Exam(userRepository.getReferenceById(examRequestDTO.getStudent()),
                subjectRepository.getReferenceById(examRequestDTO.getSubject()),
                teacherRepository.getReferenceById(examRequestDTO.getTeacher()),
                examRequestDTO.getMark(), examRequestDTO.getDate());
        examRepository.save(exam);
        return examRequestDTO;
    }

    public ExamResponseDTO changeMark(Map<String, String> newMark, Long id) {
        Exam exam = examRepository.getReferenceById(id);
        exam.setMark(newMark.get("mark"));
        examRepository.save(exam);
        return new ExamResponseDTO(exam.getUser().getUsername(),
                exam.getSubject().getName(),
                exam.getSubject().getTerm(),
                exam.getSubject().getHours(),
                exam.getMark(),
                exam.getTeacher().getName(),
                exam.getDate());
    }

    public List<ExamResponseDTO> getExams(Long studentId) {
        List<Exam> exams = userRepository.getReferenceById(studentId).getExams();
        List<ExamResponseDTO> examsResponse = new ArrayList<>();
        exams.forEach(exam -> {
            examsResponse.add(new ExamResponseDTO(
                    exam.getUser().getUsername(),
                    exam.getSubject().getName(),
                    exam.getSubject().getTerm(),
                    exam.getSubject().getHours(),
                    exam.getMark(),
                    exam.getTeacher().getName(),
                    exam.getDate()));
        });
        return examsResponse;
    }

    /*
    public List<ExamResponseDTO> getCurrentUserExams() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return getExams(userRepository.findByEmail(auth.getName()).getId());
    }*/
}
