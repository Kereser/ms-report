package com.emazon.ms_report.application.dto;

import com.emazon.ms_report.ConsUtils;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
public class ArticleResDTO {
    @NotNull
    @Positive
    private Long id;

    @NotEmpty
    @Size(min = ConsUtils.INTEGER_3, max = ConsUtils.INTEGER_30)
    private String name;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    @Positive
    private Long quantity;

    @NotNull
    private Set<@Valid CategoryArticleResDTO> categories;

    @NotNull
    @Valid
    private BrandResDTO brand;

    @NotNull
    @PastOrPresent
    private LocalDateTime updatedAt;
}
