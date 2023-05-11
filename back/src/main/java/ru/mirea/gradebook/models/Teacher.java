package ru.mirea.gradebook.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table
@Entity
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String position;

    public Teacher(String name, String position) {
        this.name = name;
        this.position = position;
    }
}
