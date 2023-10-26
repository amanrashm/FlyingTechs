package com.flyingtechs.studentManagement.service;

import com.flyingtechs.studentManagement.model.TestResult;

public interface TestResultService extends GenericService<TestResult, Long> {
    Object update(TestResult testResult, Long id);
}