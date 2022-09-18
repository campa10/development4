package com.bogantes.service;

import com.bogantes.exception.RecordNotFoundException;
import com.bogantes.model.CoursesEntity;
import com.bogantes.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {
     @Autowired
     CoursesRepository coursesRepository;
    public List<CoursesEntity> getAll(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<CoursesEntity> pagedResult = coursesRepository.findAll(paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<CoursesEntity>();
        }
    }
    public CoursesEntity getById(Long id) throws RecordNotFoundException
    {
        Optional<CoursesEntity> employee = coursesRepository.findById(id);
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No rol record exist for given id");
        }
    }
    public CoursesEntity createOrUpdateCoursesEntity(CoursesEntity entity) throws RecordNotFoundException
    {
        Optional<CoursesEntity> employee = coursesRepository.findById(entity.getId());
        if(employee.isPresent()){
            CoursesEntity newEntity = employee.get();
            newEntity.setCoursename(entity.getCoursename());
            newEntity = coursesRepository.save(newEntity);
            return newEntity;
        } else {
            entity = coursesRepository.save(entity);
             
            return entity;
        }
    }
    public void deleteById(Long id) throws RecordNotFoundException
    {
        Optional<CoursesEntity> employee = coursesRepository.findById(id);
         
        if(employee.isPresent())
        {
            coursesRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No courses record exist for given id");
        }
    }
}