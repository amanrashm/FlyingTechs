package com.flyingtechs.TestManagement.controller;

import com.flyingtechs.TestManagement.dto.TestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TestController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    TestDTO save(@RequestBody TestDTO testDTO);

    @GetMapping("/{id}")
    TestDTO findById(@PathVariable("id") Long id);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id);

    @GetMapping
    List<TestDTO> list();

    @GetMapping("/page-query")
    Page<TestDTO> pageQuery(Pageable pageable);

    @PutMapping("/{id}")
    TestDTO update(@RequestBody TestDTO testDTO, @PathVariable("id") Long id);
}
