package ru.mirea.gradebook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.gradebook.models.Subject;


@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
