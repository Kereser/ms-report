package com.emazon.ms_report.application.handler;

import com.emazon.ms_report.application.dto.ReportReqDTO;

public interface IReportHandler {
    void generateReport(ReportReqDTO reportReqDTO);
}
