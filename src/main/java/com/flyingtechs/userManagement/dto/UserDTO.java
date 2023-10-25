package com.flyingtechs.userManagement.dto;

import com.flyingtechs.userManagement.model.Address;
import com.flyingtechs.userManagement.model.IdentityDocument;

import java.util.List;

public class UserDTO extends AbstractDTO<Long> {
    private Long id;
    private String name;
    private String fathersName;
    private String address;
    private String phoneNumber;
    private String countryCode;
    private String district;
    private String pincode;
    private String panCardNumber;
    private String aadharCardNumber;
    private Address userAddress;
    private List<IdentityDocument> identityDocuments;

    public UserDTO() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getFathersName() {
        return this.fathersName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPincode() {
        return this.pincode;
    }

    public void setPanCardNumber(String panCardNumber) {
        this.panCardNumber = panCardNumber;
    }

    public String getPanCardNumber() {
        return this.panCardNumber;
    }

    public void setAadharCardNumber(String aadharCardNumber) {
        this.aadharCardNumber = aadharCardNumber;
    }

    public String getAadharCardNumber() {
        return this.aadharCardNumber;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }

    public Address getUserAddress() {
        return this.userAddress;
    }

    public void setIdentityDocuments(List<IdentityDocument> identityDocuments) {
        this.identityDocuments = identityDocuments;
    }

    public List<IdentityDocument> getIdentityDocuments() {
        return this.identityDocuments;
    }
}