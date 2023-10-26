package com.flyingtechs.teacherManagement.controller.impl;

import com.flyingtechs.teacherManagement.controller.TeacherController;
import com.flyingtechs.teacherManagement.dto.TeacherDTO;
import com.flyingtechs.teacherManagement.model.Teacher;
import com.flyingtechs.teacherManagement.service.TeacherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/teacher")
@RestController
public class TeacherControllerImpl implements TeacherController {
    private final TeacherService teacherService;

    public TeacherControllerImpl(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherDTO save(@RequestBody TeacherDTO teacherDTO) {
        Teacher teacher = teacherDTO.toEntity();
        return TeacherDTO.fromEntity(teacherService.save(teacher));
    }

    @Override
    @GetMapping("/{id}")
    public TeacherDTO findById(@PathVariable("id") Long id) {
        Teacher teacher = teacherService.findById(id).orElse(null);
        return TeacherDTO.fromEntity(teacher);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        teacherService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<TeacherDTO> list() {
        List<Teacher> teachers = teacherService.findAll();
        return teachers.stream().map(TeacherDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/page-query")
    public Page<TeacherDTO> pageQuery(Pageable pageable) {
        Page<Teacher> teacherPage = teacherService.findAll(pageable);
        List<TeacherDTO> dtoList = teacherPage
                .getContent()
                .stream()
                .map(TeacherDTO::fromEntity)
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, teacherPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public TeacherDTO update(@RequestBody TeacherDTO teacherDTO, @PathVariable("id") Long id) {
        Teacher teacher = teacherDTO.toEntity();
        return TeacherDTO.fromEntity(teacherService.update(teacher, id));
    }
}