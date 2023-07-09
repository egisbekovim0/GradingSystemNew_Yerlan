package com.example.GradingSystemNew.module;

import com.example.GradingSystemNew.module.security.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "f_name", nullable = false, unique = true)
    private String f_name;
    @Column(name = "l_name", nullable = false, unique = true)
    private String l_name;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
