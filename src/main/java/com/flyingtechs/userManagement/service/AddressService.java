package com.flyingtechs.userManagement.service;

import com.flyingtechs.userManagement.model.Address;

public interface AddressService extends GenericService<Address, Long> {
    Address update(Address entity, Long id);
}