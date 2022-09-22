package com.javatodev.api.repository;

import com.javatodev.api.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{

    @Query("FROM Student")
    List<Enrollment> getAll(   );

}