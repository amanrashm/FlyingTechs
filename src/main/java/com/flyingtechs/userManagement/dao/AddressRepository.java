package com.flyingtechs.userManagement.dao;

import com.flyingtechs.userManagement.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}