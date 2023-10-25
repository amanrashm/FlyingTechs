package com.flyingtechs.HrManagement.dao;

import com.flyingtechs.HrManagement.model.HR;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HRRepository extends PagingAndSortingRepository<HR, Long> {
}