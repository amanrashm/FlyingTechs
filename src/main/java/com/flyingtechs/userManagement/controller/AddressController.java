package com.flyingtechs.userManagement.controller;

import com.flyingtechs.userManagement.dto.AddressDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Address API")
public interface AddressController {
    @ApiOperation("Add new data")
    public AddressDTO save(@RequestBody AddressDTO address);

    @ApiOperation("Find by Id")
    public AddressDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<AddressDTO> list();

    @ApiOperation("Pagination request")
    public Page<AddressDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public AddressDTO update(@RequestBody AddressDTO dto, @PathVariable("id") Long id);
}