package com.example.employeeservice.service.impl;


import com.example.employeeservice.Mapper.EmployeeMapper;
import com.example.employeeservice.dto.ApiResponseDto;
import com.example.employeeservice.dto.DepartmentDto;
import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.dto.OrganizationDto;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import com.example.employeeservice.service.APIClient;
import com.example.employeeservice.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;
//    private RestTemplate restTemplate;
    private WebClient webClient;
        private APIClient apiFeignClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto empDto) {

        Employee emp= EmployeeMapper.mapToEmployee(empDto);

        Employee savedEmp=employeeRepository.save(emp);

        EmployeeDto savedEmpDto=EmployeeMapper.mapToEmployeeDto(savedEmp);

        return savedEmpDto;
    }

    @Override
//    @CircuitBreaker(name="${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Retry(name="${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    public ApiResponseDto getEmployeeById(Long id) {

        LOGGER.info("inside  getEmployeeById() method");
        Employee emp=employeeRepository.findById(id).get();

        //Using REst Template
//        ResponseEntity<DepartmentDto> responseEntity= restTemplate.getForEntity("http://localhost:8080/api/departments/"+ emp.getDepartmentCode(), DepartmentDto.class);

//        DepartmentDto departmentDto=responseEntity.getBody();

//        Using WebClient
        DepartmentDto departmentDto=webClient.get()
                .uri("http://localhost:8080/api/departments/"+ emp.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        //Using OpenFeign library
//        DepartmentDto departmentDto=apiFeignClient.getDepartment(emp.getDepartmentCode());

        OrganizationDto organizationDto=webClient.get()
                .uri("http://localhost:8083/api/organization/"+emp.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

        EmployeeDto empDto=EmployeeMapper.mapToEmployeeDto(emp);

        ApiResponseDto apiResponseDto=new ApiResponseDto();
        apiResponseDto.setEmployee(empDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganization(organizationDto);
        return apiResponseDto;
    }

    public ApiResponseDto getDefaultDepartment(Long id,Exception exception){

        LOGGER.info("inside  getDefaultDepartment() method");

        Employee emp=employeeRepository.findById(id).get();

        DepartmentDto departmentDto=new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research and Development Department");

        EmployeeDto empDto=EmployeeMapper.mapToEmployeeDto(emp);

        ApiResponseDto apiResponseDto=new ApiResponseDto();
        apiResponseDto.setEmployee(empDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }
}
