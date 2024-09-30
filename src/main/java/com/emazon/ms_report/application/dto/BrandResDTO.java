package com.emazon.ms_report.application.dto;

import com.emazon.ms_report.ConsUtils;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BrandResDTO {
    @NotNull
    @Positive
    private Long id;

    @NotEmpty
    @Size(min = ConsUtils.INTEGER_3, max = ConsUtils.INTEGER_30)
    private String name;

    @NotEmpty
    @Size(min = ConsUtils.INTEGER_3, max = ConsUtils.INTEGER_120)
    private String description;
}
