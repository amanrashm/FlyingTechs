package com.flyingtechs.TestManagement.service;

import com.flyingtechs.TestManagement.model.Test1;

public interface TestService extends GenericService<Test1, Long> {
    Test1 update(Test1 entity, Long id);
}