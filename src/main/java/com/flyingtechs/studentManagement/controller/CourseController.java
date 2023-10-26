package com.flyingtechs.studentManagement.controller;

import com.flyingtechs.studentManagement.dto.CourseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Course API")
public interface CourseController {
    @ApiOperation("Add new data")
    public CourseDTO save(@RequestBody CourseDTO course);

    @ApiOperation("Find by Id")
    public CourseDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<Object> list();

    @ApiOperation("Pagination request")
    public Page<CourseDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public CourseDTO update(@RequestBody CourseDTO dto, @PathVariable("id") Long id);
}