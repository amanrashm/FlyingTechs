package com.flyingtechs.teacherManagement.mapper;

import com.flyingtechs.studentManagement.mapper.GenericMapper;
import com.flyingtechs.studentManagement.mapper.ReferenceMapper;
import com.flyingtechs.teacherManagement.dto.TeacherDTO;
import com.flyingtechs.teacherManagement.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface TeacherMapper extends GenericMapper<Teacher, TeacherDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    Teacher asEntity(TeacherDTO dto);
}