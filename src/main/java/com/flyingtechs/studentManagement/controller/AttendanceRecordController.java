package com.flyingtechs.studentManagement.controller;

import com.flyingtechs.studentManagement.dto.AttendanceRecordDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "AttendanceRecord API")
public interface AttendanceRecordController {
    @ApiOperation("Add new data")
    public AttendanceRecordDTO save(@RequestBody AttendanceRecordDTO attendanceRecord);

    @ApiOperation("Find by Id")
    public AttendanceRecordDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<AttendanceRecordDTO> list();

    @ApiOperation("Pagination request")
    public Page<AttendanceRecordDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public AttendanceRecordDTO update(@RequestBody AttendanceRecordDTO dto, @PathVariable("id") Long id);
}