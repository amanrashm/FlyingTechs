package com.flyingtechs.studentManagement.controller;

import com.flyingtechs.studentManagement.dto.StudentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface StudentController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public abstract StudentDTO save(@RequestBody StudentDTO studentDTO);

    @GetMapping("/{id}")
    public abstract StudentDTO findById(@PathVariable("id") Long id);

    @DeleteMapping("/{id}")
    public abstract void delete(@PathVariable("id") Long id);

    @GetMapping
    public abstract List<StudentDTO> list();

    @GetMapping("/page-query")
    public abstract Page<StudentDTO> pageQuery(Pageable pageable);

    @PutMapping("/{id}")
    public abstract StudentDTO update(@RequestBody StudentDTO studentDTO, @PathVariable("id") Long id);
}
