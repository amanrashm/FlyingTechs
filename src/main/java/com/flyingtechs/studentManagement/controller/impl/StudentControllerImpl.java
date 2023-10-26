package com.flyingtechs.studentManagement.controller.impl;

import com.flyingtechs.studentManagement.controller.StudentController;
import com.flyingtechs.studentManagement.dto.StudentDTO;
import com.flyingtechs.studentManagement.model.Student;
import com.flyingtechs.studentManagement.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/student")
@RestController
public class StudentControllerImpl implements StudentController {
    private final StudentService studentService;

    public StudentControllerImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO save(@RequestBody StudentDTO studentDTO) {
        Student student = studentDTO.toEntity();
        return (StudentDTO) StudentDTO.fromEntity(studentService.save(student));
    }

    @Override
    @GetMapping("/{id}")
    public StudentDTO findById(@PathVariable("id") Long id) {
        Student student = studentService.findById(id).orElse(null);
        return (StudentDTO) StudentDTO.fromEntity(student);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        studentService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<Object> list() {
        List<Student> students = studentService.findAll();
        return students.stream().map(StudentDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/page-query")
    public Page<StudentDTO> pageQuery(Pageable pageable) {
        Page<Student> studentPage = studentService.findAll(pageable);
        List<StudentDTO> dtoList = studentPage
                .getContent()
                .stream()
                .map(student -> (StudentDTO) StudentDTO.fromEntity(student)) // Cast to StudentDTO
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, studentPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public StudentDTO update(@RequestBody StudentDTO studentDTO, @PathVariable("id") Long id) {
        Student student = studentDTO.toEntity();
        return (StudentDTO) StudentDTO.fromEntity(studentService.update(student, id));
    }
}