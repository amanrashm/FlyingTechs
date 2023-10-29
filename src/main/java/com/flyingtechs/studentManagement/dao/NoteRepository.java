package com.flyingtechs.studentManagement.dao;

import com.flyingtechs.studentManagement.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}