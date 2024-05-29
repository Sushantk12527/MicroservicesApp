package com.example.organization_service.controller;

import com.example.organization_service.dto.OrganizationDto;
import com.example.organization_service.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organization")
@AllArgsConstructor
public class OrganizationController {
    private OrganizationService organizationService;

    //Build save Organization rest API
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganisation(@RequestBody OrganizationDto orgDto){
        OrganizationDto organizationDto=organizationService.saveOrganization(orgDto);
        return new ResponseEntity<>(organizationDto, HttpStatus.CREATED);
    }

    //Build Get Organization by Code REST API
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String orgCode){
        OrganizationDto orgDto= organizationService.getOrganizationByCode(orgCode);
        return ResponseEntity.ok(orgDto);
    }
}
