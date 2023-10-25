package com.flyingtechs.TestManagement.dao;

import com.flyingtechs.TestManagement.model.Test;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends PagingAndSortingRepository<Test, Long> {
}