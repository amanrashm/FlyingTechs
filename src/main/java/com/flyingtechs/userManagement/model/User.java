package com.flyingtechs.userManagement.model;

import com.flyingtechs.HrManagement.model.HR;
import com.flyingtechs.studentManagement.model.Student;
import com.flyingtechs.teacherManagement.model.Teacher;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@Table(name = "USER_DETAILS")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_ID")
    private Long id;

    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @Column(name = "User_Name", nullable = false)
    private String name;

    @Size(min = 3, max = 50, message = "Father's name must be between 3 and 50 characters")
    @Column(name = "Father's_Name", nullable = false)
    private String fathersName;

    @Size(max = 255, message = "Address can't exceed 255 characters")
    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    @Column(name = "Phone_Number", nullable = false, unique = true)
    private String phoneNumber;

    @Pattern(regexp = "\\+[0-9]+", message = "Invalid country code format")
    @Column(name = "Country_Code", nullable = false)
    private String countryCode;

    @Size(min = 3, max = 50, message = "District must be between 3 and 50 characters")
    @Column(name = "District", nullable = false)
    private String district;

    @Pattern(regexp = "\\d{6}", message = "Invalid pincode format")
    @Column(name = "Pincode", nullable = false)
    private String pincode;

    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Invalid PAN card format")
    @Column(name = "Pan_Card_Number", nullable = false, unique = true)
    private String panCardNumber;

    @Pattern(regexp = "\\d{12}", message = "Invalid Aadhar card format")
    @Column(name = "Aadhar_Card_Number", nullable = false, unique = true)
    private String aadharCardNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address userAddress;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private List<IdentityDocument> identityDocuments;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hr_hr_id")
    private HR hr;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public User() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPanCardNumber() {
        return panCardNumber;
    }

    public void setPanCardNumber(String panCardNumber) {
        this.panCardNumber = panCardNumber;
    }

    public String getAadharCardNumber() {
        return aadharCardNumber;
    }

    public void setAadharCardNumber(String aadharCardNumber) {
        this.aadharCardNumber = aadharCardNumber;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }

    public List<IdentityDocument> getIdentityDocuments() {
        return identityDocuments;
    }

    public void setIdentityDocuments(List<IdentityDocument> identityDocuments) {
        this.identityDocuments = identityDocuments;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public HR getHr() {
        return hr;
    }

    public void setHr(HR hr) {
        this.hr = hr;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public User(Long id, String name, String fathersName, String address, String phoneNumber, String countryCode, String district, String pincode, String panCardNumber, String aadharCardNumber, Address userAddress, List<IdentityDocument> identityDocuments, Student student, HR hr, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.fathersName = fathersName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.countryCode = countryCode;
        this.district = district;
        this.pincode = pincode;
        this.panCardNumber = panCardNumber;
        this.aadharCardNumber = aadharCardNumber;
        this.userAddress = userAddress;
        this.identityDocuments = identityDocuments;
        this.student = student;
        this.hr = hr;
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", district='" + district + '\'' +
                ", pincode='" + pincode + '\'' +
                ", panCardNumber='" + panCardNumber + '\'' +
                ", aadharCardNumber='" + aadharCardNumber + '\'' +
                ", userAddress=" + userAddress +
                ", identityDocuments=" + identityDocuments +
                ", student=" + student +
                ", hr=" + hr +
                ", teacher=" + teacher +
                '}';
    }
}