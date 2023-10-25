package com.flyingtechs.userManagement.controller;

import com.flyingtechs.userManagement.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UserDTO save(@RequestBody UserDTO userDTO);

    @GetMapping("/{id}")
    UserDTO findById(@PathVariable("id") Long id);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id);

    @GetMapping
    List<UserDTO> list();

    @GetMapping("/page-query")
    Page<UserDTO> pageQuery(Pageable pageable);

    @PutMapping("/{id}")
    UserDTO update(@RequestBody UserDTO userDTO, @PathVariable("id") Long id);
}
