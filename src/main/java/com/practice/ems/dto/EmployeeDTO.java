package com.practice.ems.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "EmployeeDTO Information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Integer id;

    @Schema(description = "Employee FirstName")
    @NotEmpty(message = "Employee First Name Should not be empty")
    private String firstName;

    @Schema(description = "Employee LastName")
    @NotEmpty(message = "Employee Last Name Should not be empty")
    private String lastName;

    @NotEmpty(message = "Employee Address Should not be empty")
    @Email(message = "Email Address Should be valid")
    @Schema(description = "Employee Email Address")
    private String email;
}
