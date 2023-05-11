package ru.mirea.gradebook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.gradebook.models.Exam;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

}
