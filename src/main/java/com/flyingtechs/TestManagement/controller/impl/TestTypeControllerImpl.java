package com.flyingtechs.TestManagement.controller.impl;

import com.flyingtechs.TestManagement.controller.TestTypeController;
import com.flyingtechs.TestManagement.dto.TestTypeDTO;
import com.flyingtechs.TestManagement.model.TestType;
import com.flyingtechs.TestManagement.service.TestTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/test-type")
@RestController
public class TestTypeControllerImpl implements TestTypeController {
    private final TestTypeService testTypeService;

    public TestTypeControllerImpl(TestTypeService testTypeService) {
        this.testTypeService = testTypeService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TestTypeDTO save(@RequestBody TestTypeDTO testTypeDTO) {
        TestType testType = testTypeDTO.toEntity();
        return TestTypeDTO.fromEntity(testTypeService.save(testType));
    }

    @Override
    @GetMapping("/{id}")
    public TestTypeDTO findById(@PathVariable("id") Long id) {
        TestType testType = testTypeService.findById(id).orElse(null);
        return TestTypeDTO.fromEntity(testType);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        testTypeService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<TestTypeDTO> list() {
        List<TestType> testTypes = testTypeService.findAll();
        return testTypes.stream().map(TestTypeDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/page-query")
    public Page<TestTypeDTO> pageQuery(Pageable pageable) {
        Page<TestType> testTypePage = testTypeService.findAll(pageable);
        List<TestTypeDTO> dtoList = testTypePage.getContent()
                .stream()
                .map(TestTypeDTO::fromEntity)
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, testTypePage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public TestTypeDTO update(@RequestBody TestTypeDTO testTypeDTO, @PathVariable("id") Long id) {
        TestType testType = testTypeDTO.toEntity();
        return TestTypeDTO.fromEntity(testTypeService.update(testType, id));
    }
}