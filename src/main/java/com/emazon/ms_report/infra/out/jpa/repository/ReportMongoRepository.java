package com.emazon.ms_report.infra.out.jpa.repository;

import com.emazon.ms_report.infra.out.jpa.document.ReportDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportMongoRepository extends MongoRepository<ReportDocument, Long> {
}
