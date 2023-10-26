package com.flyingtechs.TestManagement.controller.impl;

import com.flyingtechs.TestManagement.controller.TestController;
import com.flyingtechs.TestManagement.dto.TestDTO;
import com.flyingtechs.TestManagement.mapper.TestMapper;
import com.flyingtechs.TestManagement.model.Test;
import com.flyingtechs.TestManagement.service.TestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/test")
@RestController
public class TestControllerImpl implements TestController {
    private final TestService testService;
    private final TestMapper testMapper;

    public TestControllerImpl(TestService testService, TestMapper testMapper) {
        this.testService = testService;
        this.testMapper = testMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TestDTO save(@RequestBody TestDTO testDTO) {
        Test test = testMapper.asEntity(testDTO);
        return testMapper.asDTO(testService.save(test));
    }

    @Override
    @GetMapping("/{id}")
    public TestDTO findById(@PathVariable("id") Long id) {
        Test test = testService.findById(id).orElse(null);
        return testMapper.asDTO(test);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        testService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<TestDTO> list() {
        return testMapper.asDTOList(testService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<TestDTO> pageQuery(Pageable pageable) {
        Page<Test> testPage = testService.findAll(pageable);
        List<TestDTO> dtoList = testPage
                .stream()
                .map(testMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, testPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public TestDTO update(@RequestBody TestDTO testDTO, @PathVariable("id") Long id) {
        Test test = testMapper.asEntity(testDTO);
        return testMapper.asDTO(testService.update(test, id));
    }
}