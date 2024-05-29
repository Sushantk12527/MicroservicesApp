package com.example.employeeservice.Mapper;

import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee emp){
        EmployeeDto employeeDto=new EmployeeDto(
                emp.getId(),
                emp.getFirstName(),
                emp.getLastName(),
                emp.getEmail(),
                emp.getDepartmentCode(),
                emp.getOrganizationCode()
        );
        return employeeDto;
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee=new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode(),
                employeeDto.getOrganizationCode()
        );
        return employee;
    }
}
