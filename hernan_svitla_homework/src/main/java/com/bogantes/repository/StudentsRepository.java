package com.bogantes.repository;

import com.bogantes.model.CoursesEntity;
import com.bogantes.model.StudentsEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository
        extends PagingAndSortingRepository<StudentsEntity, Long> {
 
}