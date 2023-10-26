package com.flyingtechs.studentManagement.controller.impl;

import com.flyingtechs.studentManagement.controller.CourseController;
import com.flyingtechs.studentManagement.dto.CourseDTO;
import com.flyingtechs.studentManagement.model.Course;
import com.flyingtechs.studentManagement.service.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/course")
@RestController
public class CourseControllerImpl implements CourseController {
    private final CourseService courseService;

    public CourseControllerImpl(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO save(@RequestBody CourseDTO courseDTO) {
        Course course = courseDTO.toEntity();
        return (CourseDTO) CourseDTO.fromEntity(courseService.save(course));
    }

    @Override
    @GetMapping("/{id}")
    public CourseDTO findById(@PathVariable("id") Long id) {
        Course course = courseService.findById(id).orElse(null);
        return (CourseDTO) CourseDTO.fromEntity(course);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        courseService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<Object> list() {
        List<Course> courses = courseService.findAll();
        return courses.stream().map(CourseDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/page-query")
    public Page<CourseDTO> pageQuery(Pageable pageable) {
        Page<Course> coursePage = courseService.findAll(pageable);
        List<CourseDTO> dtoList = coursePage
                .getContent()
                .stream()
                .map(course -> (CourseDTO) CourseDTO.fromEntity(course)) // Cast to CourseDTO
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, coursePage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public CourseDTO update(@RequestBody CourseDTO courseDTO, @PathVariable("id") Long id) {
        Course course = courseDTO.toEntity();
        return (CourseDTO) CourseDTO.fromEntity(courseService.update(course, id));
    }
}
