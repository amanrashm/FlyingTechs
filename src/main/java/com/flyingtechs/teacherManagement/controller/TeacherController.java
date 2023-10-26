package com.flyingtechs.teacherManagement.controller;

import com.flyingtechs.teacherManagement.dto.TeacherDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TeacherController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public abstract TeacherDTO save(@RequestBody TeacherDTO teacherDTO);

    @GetMapping("/{id}")
    public abstract TeacherDTO findById(@PathVariable("id") Long id);

    @DeleteMapping("/{id}")
    public abstract void delete(@PathVariable("id") Long id);

    @GetMapping
    public abstract List<TeacherDTO> list();

    @GetMapping("/page-query")
    public abstract Page<TeacherDTO> pageQuery(Pageable pageable);

    @PutMapping("/{id}")
    public abstract TeacherDTO update(@RequestBody TeacherDTO teacherDTO, @PathVariable("id") Long id);
}
