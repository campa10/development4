package com.bogantes.web;

import com.bogantes.exception.RecordNotFoundException;
import com.bogantes.model.CoursesEntity;
import com.bogantes.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/courses")
public class CoursesController {
    @Autowired
    CoursesService coursesService;

    @PostMapping("/add")
    public ResponseEntity<CoursesEntity> Add(@RequestBody CoursesEntity CoursesEntity) throws RecordNotFoundException {
        coursesService.createOrUpdateCoursesEntity(CoursesEntity);
        return new ResponseEntity<CoursesEntity>(CoursesEntity, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:9090")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<CoursesEntity>> getAllRols(@RequestParam(defaultValue = "0") Integer pageNo,
                                                          @RequestParam(defaultValue = "10") Integer pageSize,
                                                          @RequestParam(defaultValue = "id") String sortBy) {
        List<CoursesEntity> list = coursesService.getAll(pageNo, pageSize, sortBy);
        return new ResponseEntity<List<CoursesEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ResponseEntity<CoursesEntity> createOrUpdateRol(@RequestBody CoursesEntity entity) throws RecordNotFoundException {
        CoursesEntity updated = coursesService.createOrUpdateCoursesEntity(entity);
        return new ResponseEntity<CoursesEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoursesEntity> getRolById(@PathVariable("id") Long id) throws RecordNotFoundException {
        CoursesEntity entity = coursesService.getById(id);
        return new ResponseEntity<CoursesEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:9090")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public HttpStatus deleteRolById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        coursesService.deleteById(id);
        return HttpStatus.FORBIDDEN;
    }

}