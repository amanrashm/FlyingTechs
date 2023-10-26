package com.flyingtechs.TestManagement.dao;

import com.flyingtechs.TestManagement.model.Test1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test1, Long> {
}