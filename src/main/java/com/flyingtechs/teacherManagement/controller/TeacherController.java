package com.flyingtechs.teacherManagement.controller;

import com.flyingtechs.teacherManagement.dto.TeacherDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Teacher API")
public interface TeacherController {
    @ApiOperation("Add new data")
    public TeacherDTO save(@RequestBody TeacherDTO teacher);

    @ApiOperation("Find by Id")
    public TeacherDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<TeacherDTO> list();

    @ApiOperation("Pagination request")
    public Page<TeacherDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public TeacherDTO update(@RequestBody TeacherDTO dto, @PathVariable("id") Long id);
}