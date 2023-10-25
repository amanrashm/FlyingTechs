package com.flyingtechs.userManagement.service;

import com.flyingtechs.userManagement.model.User;

public interface UserService extends GenericService<User, Long> {
    User update(User entity, Long id);
}