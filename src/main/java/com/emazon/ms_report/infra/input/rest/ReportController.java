package com.emazon.ms_report.infra.input.rest;

import com.emazon.ms_report.ConsUtils;
import com.emazon.ms_report.application.dto.ReportReqDTO;
import com.emazon.ms_report.application.handler.IReportHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ConsUtils.BASIC_URL)
@RequiredArgsConstructor
public class ReportController {

    private final IReportHandler reportHandler;

    @PostMapping
    public ResponseEntity<Void> createReport(@RequestBody @Valid ReportReqDTO reportReqDTO) {
        reportHandler.generateReport(reportReqDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
