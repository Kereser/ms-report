package com.emazon.ms_report.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandArticle {
    private Long id;
    private String name;
    private String description;
}
