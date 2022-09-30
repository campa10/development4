package com.javatodev.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="enrollment")
@Getter
@Setter
@NoArgsConstructor
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studentname")
    private String studentName;

    @OneToOne
    @JoinColumn(name = "courseid")
    private Course courseId;

}
