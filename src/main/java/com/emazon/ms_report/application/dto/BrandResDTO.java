package com.emazon.ms_report.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BrandResDTO {
    private Long id;
    private String name;
    private String description;
}
