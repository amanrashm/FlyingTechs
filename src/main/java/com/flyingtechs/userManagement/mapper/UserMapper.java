package com.flyingtechs.userManagement.mapper;

import com.flyingtechs.studentManagement.mapper.GenericMapper;
import com.flyingtechs.studentManagement.mapper.ReferenceMapper;
import com.flyingtechs.userManagement.dto.UserDTO;
import com.flyingtechs.userManagement.model.User;
import org.mapstruct.Mapper; // Import the correct Mapper annotation

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface UserMapper extends GenericMapper<User, UserDTO> {
    @Override
    @org.mapstruct.Mapping(target = "id", ignore = false) // Use the correct Mapping annotation
    User asEntity(UserDTO dto);
}