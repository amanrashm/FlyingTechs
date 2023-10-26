package com.flyingtechs.TestManagement.controller.impl;

import com.flyingtechs.TestManagement.controller.TestController;
import com.flyingtechs.TestManagement.dto.TestDTO;
import com.flyingtechs.TestManagement.model.Test1;
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

    public TestControllerImpl(TestService testService) {
        this.testService = testService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TestDTO save(@RequestBody TestDTO testDTO) {
        Test1 test1 = testDTO.toEntity();
        return TestDTO.fromEntity(testService.save(test1));
    }

    @Override
    @GetMapping("/{id}")
    public TestDTO findById(@PathVariable("id") Long id) {
        Test1 test1 = testService.findById(id).orElse(null);
        return TestDTO.fromEntity(test1);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        testService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<TestDTO> list() {
        List<Test1> test1s = testService.findAll();
        return test1s.stream().map(TestDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/page-query")
    public Page<TestDTO> pageQuery(Pageable pageable) {
        Page<Test1> testPage = testService.findAll(pageable);
        List<TestDTO> dtoList = testPage
                .getContent()
                .stream()
                .map(TestDTO::fromEntity)
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, testPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public TestDTO update(@RequestBody TestDTO testDTO, @PathVariable("id") Long id) {
        Test1 test1 = testDTO.toEntity();
        return TestDTO.fromEntity(testService.update(test1, id));
    }
}
