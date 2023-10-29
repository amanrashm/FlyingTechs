package com.flyingtechs.HrManagement.dao;

import com.flyingtechs.HrManagement.model.HR;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HRRepository extends JpaRepository<HR, Long> {
}