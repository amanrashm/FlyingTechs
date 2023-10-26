package com.flyingtechs.HrManagement.mapper;

import com.flyingtechs.HrManagement.dto.HRDTO;
import com.flyingtechs.HrManagement.model.HR;
import com.flyingtechs.studentManagement.mapper.GenericMapper;
import com.flyingtechs.studentManagement.mapper.ReferenceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface HRMapper extends GenericMapper<HR, HRDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    HR asEntity(HRDTO dto);
}