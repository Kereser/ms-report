package com.emazon.ms_report.infra.exception_handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    public static final String NOT_NULL = "must not be null";
    public static final String NOT_BLANK = "must not be blank";
    public static final String SIZE_BETWEEN_3_50 = "size must be between 3 and 50";
    public static final String SIZE_BETWEEN_3_90 = "size must be between 3 and 90";
    public static final String SIZE_BETWEEN_3_120 = "size must be between 3 and 120";
    public static final String UNIQUE_CONSTRAINT_VIOLATION = "must be unique";
    public static final String ENTITY_ALREADY_EXISTS = " already exists";
    public static final String FIELD_VALIDATION_ERRORS = "Request has field validation errors";
    public static final String ID_NOT_FOUND = "A provided ID could not be found";
    public static final String NOT_VALID_PARAM = "Not valid request param";
    public static final String INVALID_TOKEN = "Invalid token.";
    public static final String ERROR_PROCESSING_OPERATION = "Error processing operation with: ";

    public static final String NOT_ENOUGH_STOCK = "There is not enough stock to process the request for id: %s";
    public static final String STOCK_WILL_BE_AVAILABLE_SOON = "Not enough stock. Will be restored soon.";

    public static final String FAILED_CONSTRAINT_FOR_ARTICLE_CATEGORY = "Request does not meet constraint of 3 articles at max per category.";
    public static final String EXCEEDED = "Exceeded.";

    private String message;
    private Map<String, Object> fieldErrors;
}
