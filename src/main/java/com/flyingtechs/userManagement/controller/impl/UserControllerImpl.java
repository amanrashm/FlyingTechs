package com.flyingtechs.userManagement.controller.impl;

import com.flyingtechs.userManagement.controller.UserController;
import com.flyingtechs.userManagement.model.User;
import com.flyingtechs.userManagement.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user")
@RestController
public class UserControllerImpl implements UserController {
    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @Override
    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id).orElse(null);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<User> list() {
        return userService.findAll();
    }

    @Override
    @GetMapping("/page-query")
    public Page<User> pageQuery(Pageable pageable) {
        Page<User> userPage = userService.findAll(pageable);
        return new PageImpl<>(userPage.getContent(), pageable, userPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public User update(@RequestBody User user, @PathVariable("id") Long id) {
        return userService.update(user, id);
    }
}