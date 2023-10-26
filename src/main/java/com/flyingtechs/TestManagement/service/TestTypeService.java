package com.flyingtechs.TestManagement.service;

import com.flyingtechs.TestManagement.model.TestType;

public interface TestTypeService extends GenericService<TestType, Long> {
    TestType update(TestType entity, Long id);
}