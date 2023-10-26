package com.flyingtechs.userManagement.dto;

import com.flyingtechs.userManagement.model.Address;

public class AddressDTO extends AbstractDTO<Long> {
    private Long id;

    public AddressDTO(Address address) {
    }

    public static AddressDTO fromEntity(Address update) {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public Address toEntity() {
        return null;
    }
}