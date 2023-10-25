package com.flyingtechs.userManagement.controller.impl;

import com.flyingtechs.userManagement.dto.UserDTO;
import com.flyingtechs.userManagement.model.User;

import java.util.List;

public class UserBuilder {
    private String name;
    private String fathersName;
    private String address;
    private String phoneNumber;
    private String countryCode;
    private String district;
    private String pincode;
    private String panCardNumber;
    private String aadharCardNumber;

    public static List<UserDTO> getListDTO() {
        return null;
    }

    public static List<User> getListEntities() {
        return null;
    }

    public static UserDTO getDTO() {
        return null;
    }

    public static User getEntity() {
        return null;
    }

    // Define setter methods for each attribute
    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withFathersName(String fathersName) {
        this.fathersName = fathersName;
        return this;
    }

    public UserBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public UserBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserBuilder withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public UserBuilder withDistrict(String district) {
        this.district = district;
        return this;
    }

    public UserBuilder withPincode(String pincode) {
        this.pincode = pincode;
        return this;
    }

    public UserBuilder withPanCardNumber(String panCardNumber) {
        this.panCardNumber = panCardNumber;
        return this;
    }

    public UserBuilder withAadharCardNumber(String aadharCardNumber) {
        this.aadharCardNumber = aadharCardNumber;
        return this;
    }

    // Build method to create a User instance
    public User build() {
        User user = new User();
        user.setName(name);
        user.setFathersName(fathersName);
        user.setAddress(address);
        user.setPhoneNumber(phoneNumber);
        user.setCountryCode(countryCode);
        user.setDistrict(district);
        user.setPincode(pincode);
        user.setPanCardNumber(panCardNumber);
        user.setAadharCardNumber(aadharCardNumber);
        return user;
    }

    // Other methods for additional attributes

    // Example usage in a test
    public static UserBuilder anUser() {
        return new UserBuilder()
                .withName("John Doe")
                .withFathersName("John's Father")
                .withAddress("123 Main St")
                .withPhoneNumber("1234567890")
                .withCountryCode("+1")
                .withDistrict("Sample District")
                .withPincode("123456")
                .withPanCardNumber("ABCDE1234F")
                .withAadharCardNumber("123456789012");
    }
}