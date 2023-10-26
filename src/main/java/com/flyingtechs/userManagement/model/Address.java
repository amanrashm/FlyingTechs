package com.flyingtechs.userManagement.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String street;

    public void setStreet(String userAddress) {
    }

    public String getStreet() {
        return null;
    }
}