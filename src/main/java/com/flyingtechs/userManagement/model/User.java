package com.flyingtechs.userManagement.model;

import com.flyingtechs.HrManagement.model.HR;
import com.flyingtechs.studentManagement.model.Student;
import com.flyingtechs.teacherManagement.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}