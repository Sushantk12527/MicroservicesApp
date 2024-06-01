package com.example.organization_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema(description =   "Organization Model Information")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {
    private Long id;
    @Schema (description = "Organization Name")
    private String organizationName;
    @Schema (description = "Organization Description")
    private String organizationDescription;
    @Schema (description = "Organization Code")
    private String organizationCode;
    private LocalDateTime createdDate;
}
