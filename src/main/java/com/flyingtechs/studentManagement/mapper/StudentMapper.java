package com.flyingtechs.studentManagement.mapper;

import com.flyingtechs.studentManagement.dto.StudentDTO;
import com.flyingtechs.studentManagement.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface StudentMapper extends GenericMapper<Student, StudentDTO> {
    @Override
    @Mapping(target = "id", ignore = false) // Use true to ignore the mapping of the "id" field
    Student asEntity(StudentDTO dto);
}