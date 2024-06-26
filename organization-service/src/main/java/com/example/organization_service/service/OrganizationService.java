package com.example.organization_service.service;

import com.example.organization_service.dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto orgDto);

    OrganizationDto getOrganizationByCode(String organizationCode);
}
