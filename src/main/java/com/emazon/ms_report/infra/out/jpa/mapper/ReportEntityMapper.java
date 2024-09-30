package com.emazon.ms_report.infra.out.jpa.mapper;

import com.emazon.ms_report.domain.model.Report;
import com.emazon.ms_report.infra.out.jpa.document.ReportDocument;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ReportEntityMapper {

    ReportDocument reportToReportDocument(Report report);
}
