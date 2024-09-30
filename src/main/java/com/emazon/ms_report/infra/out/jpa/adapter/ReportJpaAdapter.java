package com.emazon.ms_report.infra.out.jpa.adapter;

import com.emazon.ms_report.domain.model.Report;
import com.emazon.ms_report.domain.spi.IReportPersistencePort;
import com.emazon.ms_report.infra.out.jpa.document.ReportDocument;
import com.emazon.ms_report.infra.out.jpa.mapper.ReportEntityMapper;
import com.emazon.ms_report.infra.out.jpa.repository.ReportMongoRepository;
import com.emazon.ms_report.infra.security.model.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

@RequiredArgsConstructor
public class ReportJpaAdapter implements IReportPersistencePort {

    private final ReportMongoRepository reportMongoRepository;
    private final ReportEntityMapper entityMapper;

    @Override
    public void save(Report report) {
        ReportDocument reportDocument = buildDocument(report);
        reportMongoRepository.save(reportDocument);
    }

    @Override
    public CustomUserDetails getPrincipal() {
        return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    private ReportDocument buildDocument(Report report) {
        return entityMapper.reportToReportDocument(report);
    }
}
