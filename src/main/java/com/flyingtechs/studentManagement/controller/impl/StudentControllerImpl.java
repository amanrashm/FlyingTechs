package com.flyingtechs.studentManagement.controller.impl;

import com.flyingtechs.studentManagement.controller.StudentController;
import com.flyingtechs.studentManagement.dto.StudentDTO;
import com.flyingtechs.studentManagement.mapper.StudentMapper;
import com.flyingtechs.studentManagement.model.Student;
import com.flyingtechs.studentManagement.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/student")
@RestController
public class StudentControllerImpl implements StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    public StudentControllerImpl(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO save(@RequestBody StudentDTO studentDTO) {
        Student student = studentMapper.asEntity(studentDTO);
        return studentMapper.asDTO(studentService.save(student));
    }

    @Override
    @GetMapping("/{id}")
    public StudentDTO findById(@PathVariable("id") Long id) {
        Student student = studentService.findById(id).orElse(null);
        return studentMapper.asDTO(student);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        studentService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<StudentDTO> list() {
        return studentMapper.asDTOList(studentService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<StudentDTO> pageQuery(Pageable pageable) {
        Page<Student> studentPage = studentService.findAll(pageable);
        List<StudentDTO> dtoList = studentPage
                .stream()
                .map(studentMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, studentPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public StudentDTO update(@RequestBody StudentDTO studentDTO, @PathVariable("id") Long id) {
        Student student = studentMapper.asEntity(studentDTO);
        return studentMapper.asDTO(studentService.update(student, id));
    }
}