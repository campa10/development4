package com.javatodev.test.service;

import com.javatodev.api.exception.RecordNotFoundException;
import com.javatodev.api.exception.StudentAlreadyExistException;
import com.javatodev.api.model.Student;
import com.javatodev.api.repository.StudentRepository;
import com.javatodev.api.service.CourseService;
import com.javatodev.api.service.StudentService;
import com.javatodev.api.service.StudentServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    private static StudentService studentService;
    private static final CourseService courseService = mock(CourseService.class);
    private static final StudentRepository studentRepository = mock(StudentRepository.class);

    @BeforeAll
    static void setUp() {
        studentService = new StudentServiceImpl(studentRepository);
    }

    @Test
    void findStudentByIdShouldReturnStudent() throws RecordNotFoundException {
        Long studentId = 1L;
        when(studentRepository.findById(any())).thenReturn(mockedOptionalStudent());

        //when:
        Student student = studentService.findById(studentId);

        //then:
        assertEquals(student, expectedStudent());
    }

    @Test
    void findStudentsByIdShouldReturnRecordNotFoundException() {
        //given:
        Long studentId = 1L;
        when(studentRepository.findById(any())).thenReturn(Optional.empty());

        //when:
        Executable exec = () -> studentService.findById(studentId);

        //then:
        assertThrows(RecordNotFoundException.class, exec, "No record exist for given id");
    }

    @Test
    void findAllStudentsShouldReturnAListOfStudents() {
        //given:
        when(studentRepository.findAll()).thenReturn(expectedStudents());

        //when:
        List<Student> students = studentService.findStudents();

        //then:
        assertThat(students, equalTo(expectedStudents()));
    }

    @Test
    void findAllStudentsShouldReturnAnEmptyListOfStudents() {
        //given:
        when(studentRepository.findAll()).thenReturn(Collections.emptyList());

        //when:
        List<Student> students = studentService.findStudents();

        //then:
        assertTrue(students.isEmpty());
    }

    @Test
    void createStudentShouldReturnANewStudent() {
        //given:
        Student student = new Student(null, "Peter", Collections.emptyList());
        when(studentRepository.save(student)).thenReturn(expectedStudent());

        //when:
        Student studentSaved = studentService.createOrUpdateStudent(student);

        //then:
        assertThat(studentSaved, equalTo(expectedStudent()));
    }

    @Test
    void updateStudentShouldReturnAnUpdatedStudent() throws RecordNotFoundException {
        //given:
        Student student = new Student(1L, "Peter", Collections.emptyList());
        when(studentRepository.save(student)).thenReturn(expectedStudent());

        //when:
        Student studentUpdated = studentService.createOrUpdateStudent(student);

        //then:
        assertThat(studentUpdated, equalTo(expectedStudent()));
    }

    @Test
    void createOrUpdateStudentShouldReturnStudentAlreadyExistException() {
        //given:
        Student student = new Student(null, null, Collections.emptyList());
        when(studentRepository.save(student)).thenThrow(DataRetrievalFailureException.class);

        //when:
        Executable executable = () -> studentService.createOrUpdateStudent(student);

        //then:
        assertThrows(StudentAlreadyExistException.class, executable, "There is already a student with that name.");
    }

    @Test
    void deleteStudentShouldReturnRecordNotFoundException() {
        //given:
        Long studentId = null;
        doThrow(EmptyResultDataAccessException.class).when(studentRepository).deleteById(studentId);

        //when:
        Executable executable = () -> studentService.deleteById(studentId);

        //then:
        assertThrows(RecordNotFoundException.class, executable, "No record exist for given id");
    }

    @Test
    void deleteStudentByIdShouldNotThrowException() throws RecordNotFoundException {
        //given:
        Long studentId = 1L;
        doNothing().when(studentRepository).deleteById(studentId);

        //when:
        studentService.deleteById(studentId);

        //then:
        verify(studentRepository).deleteById(studentId);
    }

    @Test
    void findStudentByNameShouldReturnAListOfStudents() {
        //given:
        String name = "student1";
        when(studentRepository.findStudentByStudentName(name)).thenReturn(expectedStudents());

        //when:
        List<Student> students = studentService.findStudentByName(name);

        //then:
        assertThat(students, equalTo(expectedStudents()));
    }

    @Test
    void findStudentByIdNotInShouldReturnAListOfStudents() {
        //given:
        when(studentRepository.findStudentByIdNotIn(any())).thenReturn(expectedStudents());

        //when:
        List<Student> students = studentService.findStudentByIdNotIn(any());

        //then:
        assertThat(students, equalTo(expectedStudents()));
    }

    private List<Student> expectedStudents() {
        return Arrays.asList(
                new Student(1L, "Ringo", Collections.emptyList()),
                new Student(2L, "John", Collections.emptyList()),
                new Student(3L, "Paul", Collections.emptyList()),
                new Student(4L, "George", Collections.emptyList()));
    }

    private Student expectedStudent() {
        return new Student(1L, "Peter", Collections.emptyList());
    }

    private Optional<Student> mockedOptionalStudent() {
        return Optional.of(new Student(1L, "Peter", Collections.emptyList()));
    }

}
