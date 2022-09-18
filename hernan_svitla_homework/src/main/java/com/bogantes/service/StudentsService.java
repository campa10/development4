package com.bogantes.service;

import com.bogantes.exception.RecordNotFoundException;
import com.bogantes.model.StudentsEntity;
import com.bogantes.repository.CoursesRepository;
import com.bogantes.repository.StudentsRepository;
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
public class StudentsService {

    @Autowired
    StudentsRepository studentsRepository;

    public List<StudentsEntity> getAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<StudentsEntity> pagedResult = studentsRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<StudentsEntity>();
        }
    }

    public StudentsEntity getById(Long id) throws RecordNotFoundException {
        Optional<StudentsEntity> employee = studentsRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No students record exist for given id");
        }
    }

    public StudentsEntity createOrUpdateStudentsEntity(StudentsEntity entity) throws RecordNotFoundException {
        Optional<StudentsEntity> employee = studentsRepository.findById(entity.getId());
        if (employee.isPresent()) {
            StudentsEntity newEntity = employee.get();
            newEntity.setCourseid(entity.getCourseid());
            newEntity.setNombrerol(entity.getNombrerol());
            newEntity = studentsRepository.save(newEntity);
            return newEntity;
        } else {
            entity = studentsRepository.save(entity);

            return entity;
        }
    }

    public void deleteById(Long id) throws RecordNotFoundException {
        Optional<StudentsEntity> employee = studentsRepository.findById(id);

        if (employee.isPresent()) {
            studentsRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No students record exist for given id");
        }
    }
}