package com.flyingtechs.TestManagement.mapper;

import com.flyingtechs.TestManagement.dto.TestDTO;
import com.flyingtechs.TestManagement.model.Test;
import com.flyingtechs.studentManagement.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface TestMapper extends GenericMapper<Test, TestDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    Test asEntity(TestDTO dto);
}