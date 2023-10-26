package com.flyingtechs.studentManagement.controller.impl;

import com.flyingtechs.studentManagement.controller.TestResultController;
import com.flyingtechs.studentManagement.dto.TestResultDTO;
import com.flyingtechs.studentManagement.model.TestResult;
import com.flyingtechs.studentManagement.service.TestResultService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/test-result")
@RestController
public class TestResultControllerImpl implements TestResultController {
    private final TestResultService testResultService;

    public TestResultControllerImpl(TestResultService testResultService) {
        this.testResultService = testResultService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TestResultDTO save(@RequestBody TestResultDTO testResultDTO) {
        TestResult testResult = testResultDTO.toEntity();
        return TestResultDTO.fromEntity(testResultService.save(testResult));
    }

    @Override
    @GetMapping("/{id}")
    public TestResultDTO findById(@PathVariable("id") Long id) {
        TestResult testResult = testResultService.findById(id).orElse(null);
        return TestResultDTO.fromEntity(testResult);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        testResultService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<TestResultDTO> list() {
        List<TestResult> testResults = testResultService.findAll();
        return testResults.stream().map(TestResultDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/page-query")
    public Page<TestResultDTO> pageQuery(Pageable pageable) {
        Page<TestResult> testResultPage = testResultService.findAll(pageable);
        List<TestResultDTO> dtoList = testResultPage
                .getContent()
                .stream()
                .map(TestResultDTO::fromEntity)
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, testResultPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public TestResultDTO update(@RequestBody TestResultDTO testResultDTO, @PathVariable("id") Long id) {
        TestResult testResult = testResultDTO.toEntity();
        return TestResultDTO.fromEntity(testResultService.update(testResult, id));
    }
}