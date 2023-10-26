package com.flyingtechs.studentManagement.service;

import com.flyingtechs.studentManagement.model.HomeworkSubmission;

public interface HomeworkSubmissionService extends GenericService<HomeworkSubmission, Long> {
    HomeworkSubmission update(HomeworkSubmission homeworkSubmission, Long id);
}