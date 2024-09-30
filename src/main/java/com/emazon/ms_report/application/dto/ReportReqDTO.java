package com.emazon.ms_report.application.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
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

    @NotNull
    @Positive
    private Long cartId;

    @NotNull
    @Positive
    private Long userId;

    @NotNull
    @PastOrPresent
    private LocalDateTime cartLastUpdatedAt;

    @NotNull
    @Positive
    private BigDecimal totalPrice;

    @NotNull
    private Set<@Valid ArticleResDTO> articles;
}
