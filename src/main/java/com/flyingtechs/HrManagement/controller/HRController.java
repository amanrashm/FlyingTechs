package com.flyingtechs.HrManagement.controller;

import com.flyingtechs.HrManagement.dto.HRDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "HR API")
public interface HRController {
    @ApiOperation("Add new data")
    public HRDTO save(@RequestBody HRDTO hR);

    @ApiOperation("Find by Id")
    public HRDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<HRDTO> list();

    @ApiOperation("Pagination request")
    public Page<HRDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public HRDTO update(@RequestBody HRDTO dto, @PathVariable("id") Long id);
}