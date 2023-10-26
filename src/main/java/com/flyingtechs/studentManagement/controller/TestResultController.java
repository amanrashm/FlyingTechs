package com.flyingtechs.studentManagement.controller;

import com.flyingtechs.studentManagement.dto.TestResultDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "TestResult API")
public interface TestResultController {
    @ApiOperation("Add new data")
    public TestResultDTO save(@RequestBody TestResultDTO testResult);

    @ApiOperation("Find by Id")
    public TestResultDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<TestResultDTO> list();

    @ApiOperation("Pagination request")
    public Page<TestResultDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public TestResultDTO update(@RequestBody TestResultDTO dto, @PathVariable("id") Long id);
}