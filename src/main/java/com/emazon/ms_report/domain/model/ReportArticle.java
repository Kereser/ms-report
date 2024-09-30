package com.emazon.ms_report.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportArticle {
    private Long id;
    private String name;
    private BigDecimal price;
    private Long quantity;
    private Set<CategoryArticle> categories;
    private BrandArticle brand;
    private LocalDateTime updatedAt;
}
