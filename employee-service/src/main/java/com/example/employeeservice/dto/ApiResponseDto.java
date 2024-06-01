package com.example.employeeservice.dto;

import com.example.employeeservice.entity.Employee;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "API Model Information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDto {
    @Schema(description = "employee")
    private EmployeeDto employee;
    @Schema(
            description = "department"
    )
    private DepartmentDto department;
    @Schema(description = "organization")
    private OrganizationDto organization;
}
