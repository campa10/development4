package com.bogantes.model;

import javax.persistence.*;

@Entity
@Table(name="students")
public class StudentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="courseid")
    private Long courseid;

    @Column(name="studentname")
    private String nombrerol;

    public long getId() {
        return id;
    }

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }
}
