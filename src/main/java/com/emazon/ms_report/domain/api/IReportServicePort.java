package com.emazon.ms_report.domain.api;

import com.emazon.ms_report.domain.model.Report;

public interface IReportServicePort {
    void generateReport(Report report);
}
