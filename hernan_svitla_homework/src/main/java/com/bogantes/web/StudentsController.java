package com.bogantes.web;

import com.bogantes.exception.RecordNotFoundException;
import com.bogantes.model.StudentsEntity;
import com.bogantes.service.CoursesService;
import com.bogantes.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    StudentsService studentsService;

    @PostMapping("/add")
    public ResponseEntity<StudentsEntity> Add(@RequestBody StudentsEntity StudentsEntity) throws RecordNotFoundException {
        studentsService.createOrUpdateStudentsEntity(StudentsEntity);
        return new ResponseEntity<StudentsEntity>(StudentsEntity, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:9090")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<StudentsEntity>> getAllRols(@RequestParam(defaultValue = "0") Integer pageNo,
                                                          @RequestParam(defaultValue = "10") Integer pageSize,
                                                          @RequestParam(defaultValue = "id") String sortBy) {
        List<StudentsEntity> list = studentsService.getAll(pageNo, pageSize, sortBy);
        return new ResponseEntity<List<StudentsEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ResponseEntity<StudentsEntity> createOrUpdateRol(@RequestBody StudentsEntity entity) throws RecordNotFoundException {
        StudentsEntity updated = studentsService.createOrUpdateStudentsEntity(entity);
        return new ResponseEntity<StudentsEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentsEntity> getRolById(@PathVariable("id") Long id) throws RecordNotFoundException {
        StudentsEntity entity = studentsService.getById(id);
        return new ResponseEntity<StudentsEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:9090")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public HttpStatus deleteRolById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        studentsService.deleteById(id);
        return HttpStatus.FORBIDDEN;
    }

}