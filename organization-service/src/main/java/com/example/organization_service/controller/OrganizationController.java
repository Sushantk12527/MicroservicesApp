package com.example.organization_service.controller;

import com.example.organization_service.dto.OrganizationDto;
import com.example.organization_service.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name="Organization Service - OrganizationController",
        description = "Organization Controller Exposes REST APIs for Organization-Service"

)
@RestController
@RequestMapping("api/organization")
@AllArgsConstructor
public class OrganizationController {
    private OrganizationService organizationService;


    @Operation(
            summary = "Save Organization REST API",
            description = "Save Organization REST API is used to save organization object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    //Build save Organization rest API
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganisation(@RequestBody OrganizationDto orgDto){
        OrganizationDto organizationDto=organizationService.saveOrganization(orgDto);
        return new ResponseEntity<>(organizationDto, HttpStatus.CREATED);
    }

    //Build Get Organization by Code REST API
    @Operation(
            summary = "Get Organization REST API",
            description = "Get Organization REST API is used to get organization object in a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String orgCode){
        OrganizationDto orgDto= organizationService.getOrganizationByCode(orgCode);
        return ResponseEntity.ok(orgDto);
    }
}
