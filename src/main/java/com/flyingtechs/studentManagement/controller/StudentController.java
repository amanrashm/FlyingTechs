package com.flyingtechs.studentManagement.controller;

import com.flyingtechs.studentManagement.dto.StudentDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Student API")
public interface StudentController {
    @ApiOperation("Add new data")
    public StudentDTO save(@RequestBody StudentDTO student);

    @ApiOperation("Find by Id")
    public StudentDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<Object> list();

    @ApiOperation("Pagination request")
    public Page<StudentDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public StudentDTO update(@RequestBody StudentDTO dto, @PathVariable("id") Long id);
}