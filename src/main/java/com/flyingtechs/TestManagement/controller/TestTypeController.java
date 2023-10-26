package com.flyingtechs.TestManagement.controller;

import com.flyingtechs.TestManagement.dto.TestTypeDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "TestType API")
public interface TestTypeController {
    @ApiOperation("Add new data")
    public TestTypeDTO save(@RequestBody TestTypeDTO testType);

    @ApiOperation("Find by Id")
    public TestTypeDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<TestTypeDTO> list();

    @ApiOperation("Pagination request")
    public Page<TestTypeDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public TestTypeDTO update(@RequestBody TestTypeDTO dto, @PathVariable("id") Long id);
}