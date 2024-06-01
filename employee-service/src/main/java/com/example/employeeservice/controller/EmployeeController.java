package com.example.employeeservice.controller;

import com.example.employeeservice.dto.ApiResponseDto;
import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name="Employee Service - EmployeeController",
        description = "Employee Controller Exposes REST APIs for Employee-Service"

)
@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Build Save Employee REST API
    @Operation(
            summary = "Save Employee REST API",
            description = "Save Employee REST API is used to save employee object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto empDto){
        EmployeeDto savedEmpDto=employeeService.saveEmployee(empDto);
        return new ResponseEntity<>(savedEmpDto, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Get Employee REST API",
            description = "Get Employee REST API is used to get employee object in a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable Long id){
        ApiResponseDto apiResponseDto=employeeService.getEmployeeById(id);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }
}
