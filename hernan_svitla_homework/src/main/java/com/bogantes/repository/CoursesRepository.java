package com.bogantes.repository;

import com.bogantes.model.CoursesEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository
        extends PagingAndSortingRepository<CoursesEntity, Long> {
 
}