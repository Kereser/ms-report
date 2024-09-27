package com.emazon.ms_report.application.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportReqDTO {
    private Long cartId;
    private Long userId;
    private LocalDateTime cartLastUpdatedAt;
    private BigDecimal totalPrice;
    private Set<ArticleResDTO> articles;
}
