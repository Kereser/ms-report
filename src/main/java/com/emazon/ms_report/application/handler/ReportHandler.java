package com.emazon.ms_report.application.handler;

import com.emazon.ms_report.application.dto.ReportReqDTO;
import com.emazon.ms_report.application.mapper.ReportDTOMapper;
import com.emazon.ms_report.domain.api.IReportServicePort;
import com.emazon.ms_report.domain.model.Report;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReportHandler implements IReportHandler {

    private final ReportDTOMapper dtoMapper;
    private final IReportServicePort reportServicePort;

    @Override
    public void generateReport(ReportReqDTO reportReqDTO) {
        Report report = dtoMapper.reportReqToReport(reportReqDTO);
        reportServicePort.generateReport(report);
    }
}
