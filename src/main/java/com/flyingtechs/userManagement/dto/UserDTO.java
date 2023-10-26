package com.flyingtechs.userManagement.dto;

import com.flyingtechs.userManagement.model.Address;
import com.flyingtechs.HrManagement.model.HR;
import com.flyingtechs.studentManagement.model.Student;
import com.flyingtechs.teacherManagement.model.Teacher;
import com.flyingtechs.userManagement.model.IdentityDocument;
import com.flyingtechs.userManagement.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class UserDTO {

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
    private @Size(max = 255, message = "Address can't exceed 255 characters") String userAddress;
    private List<IdentityDocument> identityDocuments;
    private Student student;
    private HR hr;
    private Teacher teacher;

    public UserDTO(User user) {

    }

    public static User fromEntity(User user) {
        User userDTO = new User();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setFathersName(user.getFathersName());
        userDTO.setAddress(user.getUserAddress().getStreet()); // Assuming User has an Address property
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setCountryCode(user.getCountryCode());
        userDTO.setDistrict(user.getDistrict());
        userDTO.setPincode(user.getPincode());
        userDTO.setPanCardNumber(user.getPanCardNumber());
        userDTO.setAadharCardNumber(user.getAadharCardNumber()); // Assuming User has an Address property
        userDTO.setIdentityDocuments(user.getIdentityDocuments());
        userDTO.setStudent(user.getStudent());
        userDTO.setHr(user.getHr());
        userDTO.setTeacher(user.getTeacher());

        return userDTO;
    }

    public User toEntity() {
        User user = new User();
        user.setId(this.id);
        user.setName(this.name);
        user.setFathersName(this.fathersName);

        // Create a new Address instance and set the street
        Address address = new Address();
        address.setStreet(this.userAddress);

        user.setUserAddress(address); // Assuming User has an Address property
        user.setPhoneNumber(this.phoneNumber);
        user.setCountryCode(this.countryCode);
        user.setDistrict(this.district);
        user.setPincode(this.pincode);
        user.setPanCardNumber(this.panCardNumber);
        user.setAadharCardNumber(this.aadharCardNumber);
        user.setIdentityDocuments(this.identityDocuments);
        user.setStudent(this.student);
        user.setHr(this.hr);
        user.setTeacher(this.teacher);

        return user;
    }
}