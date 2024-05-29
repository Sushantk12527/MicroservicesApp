package com.example.organization_service.mapper;

import com.example.organization_service.OrganizationServiceApplication;
import com.example.organization_service.dto.OrganizationDto;
import com.example.organization_service.entity.Organization;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public class OrganizationMapper {

    public static OrganizationDto mapToOrganizationDto(Organization org){
        OrganizationDto orgDto=new OrganizationDto(
                org.getId(),
                org.getOrganizationName(),
                org.getOrganizationDescription(),
                org.getOrganizationCode(),
                org.getCreatedDate()
        );
        return orgDto;
    }

    public static Organization mapToOrganization(OrganizationDto orgDto){
        Organization org= new Organization(
                orgDto.getId(),
                orgDto.getOrganizationName(),
                orgDto.getOrganizationDescription(),
                orgDto.getOrganizationCode(),
                orgDto.getCreatedDate()
        );
        return org;
    }
}
