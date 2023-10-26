package com.flyingtechs.TestManagement.controller;

import com.flyingtechs.TestManagement.dto.TestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Test API")
public interface TestController {
    @ApiOperation("Add new data")
    public TestDTO save(@RequestBody TestDTO test);

    @ApiOperation("Find by Id")
    public TestDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<TestDTO> list();

    @ApiOperation("Pagination request")
    public Page<TestDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public TestDTO update(@RequestBody TestDTO dto, @PathVariable("id") Long id);
}