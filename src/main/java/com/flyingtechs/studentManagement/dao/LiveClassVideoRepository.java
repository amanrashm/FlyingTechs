package com.flyingtechs.studentManagement.dao;

import com.flyingtechs.studentManagement.model.LiveClassVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LiveClassVideoRepository extends JpaRepository<LiveClassVideo, Long> {
}