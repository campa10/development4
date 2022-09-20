package com.javatodev.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="student")
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studentname")
    private String studentname;

    @OneToOne
    @JoinColumn(name = "courseid")
    private Course courseid;

    //private BigDecimal price;

    /*public Laptop(LaptopRequest request) {
        this.name = request.getName();
        this.price = request.getPrice();
    }*/

}
