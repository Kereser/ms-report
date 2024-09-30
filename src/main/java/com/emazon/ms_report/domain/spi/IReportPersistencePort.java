package com.emazon.ms_report.domain.spi;

import com.emazon.ms_report.domain.model.Report;
import com.emazon.ms_report.infra.security.model.CustomUserDetails;

public interface IReportPersistencePort {
    void save(Report report);
    CustomUserDetails getPrincipal();
}
