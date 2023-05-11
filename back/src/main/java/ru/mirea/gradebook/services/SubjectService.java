package ru.mirea.gradebook.services;

import org.springframework.stereotype.Service;
import ru.mirea.gradebook.models.Subject;
import ru.mirea.gradebook.repositories.SubjectRepository;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject updateSubject(Subject subject) {
        Subject subjectToUpdate = subjectRepository.getReferenceById(subject.getId());
        if (subject.getName() != null && !subject.getName().equals("")) {
            subjectToUpdate.setName(subject.getName());
        }
        if (subject.getTerm() != null) {
            subjectToUpdate.setTerm(subject.getTerm());
        }
        if (subject.getHours() != null) {
            subjectToUpdate.setHours(subject.getHours());
        }
        return subjectRepository.save(subjectToUpdate);
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }

}
