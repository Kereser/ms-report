package com.emazon.ms_report.infra.config;

import com.emazon.ms_report.domain.api.IReportServicePort;
import com.emazon.ms_report.domain.spi.IReportPersistencePort;
import com.emazon.ms_report.domain.usecases.ReportUseCase;
import com.emazon.ms_report.infra.out.jpa.adapter.ReportJpaAdapter;
import com.emazon.ms_report.infra.out.jpa.mapper.ReportEntityMapper;
import com.emazon.ms_report.infra.out.jpa.repository.ReportMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfig {

    private final ReportMongoRepository reportMongoRepository;
    private final ReportEntityMapper entityMapper;

    @Bean
    public IReportServicePort reportServicePort() {
        return new ReportUseCase(reportPersistencePort());
    }

    @Bean
    public IReportPersistencePort reportPersistencePort() {
        return new ReportJpaAdapter(reportMongoRepository, entityMapper);
    }
}
