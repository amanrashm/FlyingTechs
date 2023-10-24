package com.flyingtechs.userManagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_DETAILS")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(min = 3, max = 50, message = "Father's name must be between 3 and 50 characters")
    private String fathersName;

    @Size(max = 255, message = "Address can't exceed 255 characters")
    private String address;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @Pattern(regexp = "\\+[0-9]+", message = "Invalid country code format")
    private String countryCode;

    @Size(min = 3, max = 50, message = "District must be between 3 and 50 characters")
    private String district;

    @Pattern(regexp = "\\d{6}", message = "Invalid pincode format")
    private String pincode;

    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Invalid PAN card format")
    private String panCardNumber;

    @Pattern(regexp = "\\d{12}", message = "Invalid Aadhar card format")
    private String aadharCardNumber;
/*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address userAddress;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<IdentityDocument> identityDocuments;*/
}