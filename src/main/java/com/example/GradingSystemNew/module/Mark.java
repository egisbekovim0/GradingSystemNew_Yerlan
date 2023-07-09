package com.example.GradingSystemNew.module;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "mark")
@Getter
@Setter
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_subject_id", nullable = false)
    private GroupSubject groupSubject;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    @ManyToOne
    @JoinColumn(name = "mark_type_id", nullable = false)
    private MarkType markType;

    @Column(name = "mark")
    private float mark;

}