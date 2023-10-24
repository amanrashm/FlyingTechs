package com.flyingtechs.HrManagement.model;
import com.flyingtechs.userManagement.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HUMAN_RESOURCE_TEAM")
public class HR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String department;
    private String jobTitle;
    private String employeeId;

    @OneToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;
}