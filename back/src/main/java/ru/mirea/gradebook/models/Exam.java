package ru.mirea.gradebook.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@NoArgsConstructor
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    private String mark;

    public Exam(User user, Subject subject, Teacher teacher, String mark, String date) {
        this.user = user;
        this.subject = subject;
        this.teacher = teacher;
        this.mark = mark;
        this.date = date;
    }

    private String date;


}
