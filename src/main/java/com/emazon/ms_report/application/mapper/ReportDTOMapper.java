package com.emazon.ms_report.application.mapper;

import com.emazon.ms_report.application.dto.ReportReqDTO;
import com.emazon.ms_report.domain.model.Report;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ReportDTOMapper {

    Report reportReqToReport(ReportReqDTO reportReqDTO);
}
