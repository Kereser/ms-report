package com.emazon.ms_report.domain.usecases;

import com.emazon.ms_report.domain.api.IReportServicePort;
import com.emazon.ms_report.domain.model.Report;
import com.emazon.ms_report.domain.spi.IReportPersistencePort;
import com.emazon.ms_report.infra.security.model.CustomUserDetails;

import java.time.LocalDateTime;

public class ReportUseCase implements IReportServicePort {

    private final IReportPersistencePort reportPersistencePort;

    public ReportUseCase(IReportPersistencePort reportPersistencePort) {
        this.reportPersistencePort = reportPersistencePort;
    }

    @Override
    public void generateReport(Report report) {
        save(report);
    }

    private void save(Report report) {
        saveDefaultFieldsForReport(report);
        reportPersistencePort.save(report);
    }

    private void saveDefaultFieldsForReport(Report report) {
        saveUserRelatedData(report);
        saveDates(report);
    }

    private void saveUserRelatedData(Report report) {
        CustomUserDetails userDetails = getPrincipal();
        report.setUserId(userDetails.getUserId());
        report.setUserEmail(userDetails.getUsername());
    }

    private void saveDates(Report report) {
        report.setDate(LocalDateTime.now());
    }

    private CustomUserDetails getPrincipal() {
        return reportPersistencePort.getPrincipal();
    }
}
