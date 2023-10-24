package com.flyingtechs.HrManagement.model;
import com.flyingtechs.userManagement.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HUMAN_RESOURCE_TEAM")
public class HR {

    @Id
    @Size(min = 1, max = 3, message = "id must be between 1 and 3 characters")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HR_ID")
    private Long id;

    @Size(min = 3, max = 50, message = "department must be between 3 and 50 characters")
    @Column(name = "Departmant" , nullable = false)
    private String department;

    @Size(min = 3, max = 50, message = "jobTitle must be between 3 and 50 characters")
    @Column(name = "Job_Title" , nullable = false)
    private String jobTitle;

    @Size(min = 5, max = 8, message = "employeeId must be between 5 and 8 characters")
    @Column(name = "Employee_Id" , nullable = false, unique = true)
    private String employeeId;

    @OneToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;
}