package com.example.organization_service.service.impl;

import com.example.organization_service.dto.OrganizationDto;
import com.example.organization_service.entity.Organization;
import com.example.organization_service.mapper.OrganizationMapper;
import com.example.organization_service.repository.OrganizationRepository;
import com.example.organization_service.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto orgDto) {
        // convert OrganizationDto into Organization jpa entity
        Organization org= OrganizationMapper.mapToOrganization(orgDto);

        Organization organization= organizationRepository.save(org);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization =organizationRepository.findByOrganizationCode(organizationCode);
        OrganizationDto orgDto= OrganizationMapper.mapToOrganizationDto(organization);
        return orgDto;
    }
}
