package com.flyingtechs.studentManagement.controller.impl;

import com.flyingtechs.studentManagement.controller.HomeworkSubmissionController;
import com.flyingtechs.studentManagement.dto.HomeworkSubmissionDTO;
import com.flyingtechs.studentManagement.model.HomeworkSubmission;
import com.flyingtechs.studentManagement.service.HomeworkSubmissionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/homework-submission")
@RestController
public class HomeworkSubmissionControllerImpl implements HomeworkSubmissionController {
    private final HomeworkSubmissionService homeworkSubmissionService;

    public HomeworkSubmissionControllerImpl(HomeworkSubmissionService homeworkSubmissionService) {
        this.homeworkSubmissionService = homeworkSubmissionService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HomeworkSubmissionDTO save(@RequestBody HomeworkSubmissionDTO homeworkSubmissionDTO) {
        HomeworkSubmission homeworkSubmission = homeworkSubmissionDTO.toEntity();
        return (HomeworkSubmissionDTO) HomeworkSubmissionDTO.fromEntity(homeworkSubmissionService.save(homeworkSubmission));
    }

    @Override
    @GetMapping("/{id}")
    public HomeworkSubmissionDTO findById(@PathVariable("id") Long id) {
        HomeworkSubmission homeworkSubmission = homeworkSubmissionService.findById(id).orElse(null);
        return (HomeworkSubmissionDTO) HomeworkSubmissionDTO.fromEntity(homeworkSubmission);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        homeworkSubmissionService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<Object> list() {
        List<HomeworkSubmission> submissions = homeworkSubmissionService.findAll();
        return submissions.stream().map(HomeworkSubmissionDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/page-query")
    public Page<HomeworkSubmissionDTO> pageQuery(Pageable pageable) {
        Page<HomeworkSubmission> submissionPage = homeworkSubmissionService.findAll(pageable);
        List<HomeworkSubmissionDTO> dtoList = submissionPage
                .getContent()
                .stream()
                .map(submission -> (HomeworkSubmissionDTO) HomeworkSubmissionDTO.fromEntity(submission)) // Cast to HomeworkSubmissionDTO
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, submissionPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public HomeworkSubmissionDTO update(@RequestBody HomeworkSubmissionDTO homeworkSubmissionDTO, @PathVariable("id") Long id) {
        HomeworkSubmission homeworkSubmission = homeworkSubmissionDTO.toEntity();
        return (HomeworkSubmissionDTO) HomeworkSubmissionDTO.fromEntity(homeworkSubmissionService.update(homeworkSubmission, id));
    }
}