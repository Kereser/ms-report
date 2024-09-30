package com.emazon.ms_report.infra.input.rest;

import com.emazon.ms_report.ConsUtils;
import com.emazon.ms_report.application.dto.ReportReqDTO;
import com.emazon.ms_report.application.handler.IReportHandler;
import com.emazon.ms_report.infra.exception_handler.ExceptionResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ReportControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private IReportHandler handler;

    @Test
    @WithMockUser(roles = ConsUtils.CLIENT)
    void Should_ThrowsException_When_InvalidPayload() throws Exception {

        mockMvc.perform(post(ConsUtils.BASIC_URL))
                .andExpect(jsonPath(ConsUtils.FIELD_MESSAGE).value(ConsUtils.REQUIRED_BODY))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post(ConsUtils.BASIC_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(ReportReqDTO.builder().build())))
                .andExpect(jsonPath(ConsUtils.FIELD_MESSAGE).value(ExceptionResponse.FIELD_VALIDATION_ERRORS))
                .andExpect(jsonPath(ConsUtils.FIELD_TOTAL_PRICE).value(ExceptionResponse.NOT_NULL))
                .andExpect(jsonPath(ConsUtils.FIELD_CART_ID).value(ExceptionResponse.NOT_NULL))
                .andExpect(jsonPath(ConsUtils.FIELD_USER_ID).value(ExceptionResponse.NOT_NULL))
                .andExpect(jsonPath(ConsUtils.FIELD_ARTICLES).value(ExceptionResponse.NOT_NULL))
                .andExpect(jsonPath(ConsUtils.FIELD_CART_LAST_UPADTED_AT).value(ExceptionResponse.NOT_NULL))
                .andExpect(status().isBadRequest());
    }
}