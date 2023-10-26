package com.flyingtechs.TestManagement.dao;

import com.flyingtechs.TestManagement.model.TestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestTypeRepository extends JpaRepository<TestType, Long> {
}