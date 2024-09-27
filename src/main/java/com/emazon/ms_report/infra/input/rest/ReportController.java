package com.emazon.ms_report.infra.input.rest;

import com.emazon.ms_report.ConstUtils;
import com.emazon.ms_report.application.dto.ReportReqDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ConstUtils.BASIC_URL)
public class ReportController {

    @PostMapping
    public ResponseEntity<Void> createReport(ReportReqDTO reportReqDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
