package com.flyingtechs.userManagement.controller;

import com.flyingtechs.userManagement.dto.UserDTO;
import com.flyingtechs.userManagement.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "User API")
public interface UserController {
    @ApiOperation("Add new user")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    User save(@RequestBody User user);

    @ApiOperation("Find user by ID")
    @GetMapping("/{id}")
    User findById(@PathVariable("id") Long id);

    @ApiOperation("Delete user by ID")
    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id);

    @ApiOperation("Get a list of all users")
    @GetMapping
    List<User> list();

    @ApiOperation("Get a page of users")
    @GetMapping("/page-query")
    Page<User> pageQuery(Pageable pageable);

    @ApiOperation("Update user by ID")
    @PutMapping("/{id}")
    User update(@RequestBody User user, @PathVariable("id") Long id);
}