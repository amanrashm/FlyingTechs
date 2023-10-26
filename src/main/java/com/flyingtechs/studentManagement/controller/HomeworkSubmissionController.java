package com.flyingtechs.studentManagement.controller;

import com.flyingtechs.studentManagement.dto.HomeworkSubmissionDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "HomeworkSubmission API")
public interface HomeworkSubmissionController {
    @ApiOperation("Add new data")
    public HomeworkSubmissionDTO save(@RequestBody HomeworkSubmissionDTO homeworkSubmission);

    @ApiOperation("Find by Id")
    public HomeworkSubmissionDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<Object> list();

    @ApiOperation("Pagination request")
    public Page<HomeworkSubmissionDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public HomeworkSubmissionDTO update(@RequestBody HomeworkSubmissionDTO dto, @PathVariable("id") Long id);
}