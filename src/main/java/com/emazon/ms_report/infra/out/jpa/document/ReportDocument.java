package com.emazon.ms_report.infra.out.jpa.document;

import com.emazon.ms_report.domain.model.ReportArticle;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Document(collection = "reports")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportDocument {
    @Id
    private String id;
    private Long cartId;
    private Long userId;
    private String userEmail;
    private LocalDateTime cartLastUpdatedAt;
    private BigDecimal totalPrice;
    private Set<ReportArticle> articles;
    private LocalDateTime date;
    private String annotations;
}
