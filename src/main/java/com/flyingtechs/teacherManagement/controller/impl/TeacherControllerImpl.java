package com.flyingtechs.teacherManagement.controller.impl;

import com.flyingtechs.teacherManagement.controller.TeacherController;
import com.flyingtechs.teacherManagement.dto.TeacherDTO;
import com.flyingtechs.teacherManagement.mapper.TeacherMapper;
import com.flyingtechs.teacherManagement.model.Teacher;
import com.flyingtechs.teacherManagement.service.TeacherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/teacher")
@RestController
public class TeacherControllerImpl implements TeacherController {
    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;

    public TeacherControllerImpl(TeacherService teacherService, TeacherMapper teacherMapper) {
        this.teacherService = teacherService;
        this.teacherMapper = teacherMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherDTO save(@RequestBody TeacherDTO teacherDTO) {
        Teacher teacher = teacherMapper.asEntity(teacherDTO);
        return teacherMapper.asDTO(teacherService.save(teacher));
    }

    @Override
    @GetMapping("/{id}")
    public TeacherDTO findById(@PathVariable("id") Long id) {
        Teacher teacher = (Teacher) teacherService.findById(id).orElse(null);
        return teacherMapper.asDTO(teacher);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        teacherService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<TeacherDTO> list() {
        return teacherMapper.asDTOList(teacherService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<TeacherDTO> pageQuery(Pageable pageable) {
        Page<Teacher> teacherPage = teacherService.findAll(pageable);
        List<TeacherDTO> dtoList = teacherPage
                .stream()
                .map(teacherMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, teacherPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public TeacherDTO update(@RequestBody TeacherDTO teacherDTO, @PathVariable("id") Long id) {
        Teacher teacher = teacherMapper.asEntity(teacherDTO);
        return teacherMapper.asDTO(teacherService.update(teacher, id));
    }
}