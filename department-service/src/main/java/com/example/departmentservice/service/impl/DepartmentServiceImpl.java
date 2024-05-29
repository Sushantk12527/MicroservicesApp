package com.example.departmentservice.service.impl;

import com.example.departmentservice.Mapper.DepartmentMapper;
import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import com.example.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {


    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        //convert departentDto to jpa entity
        Department department= DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment=departmentRepository.save(department);

        DepartmentDto savedDepartmentDto=DepartmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String deptCode) {
        Department dept=departmentRepository.findByDepartmentCode(deptCode);

        DepartmentDto deptDto=DepartmentMapper.mapToDepartmentDto(dept);

        return deptDto;
    }
}
