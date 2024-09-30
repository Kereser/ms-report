package com.emazon.ms_report.infra.input.rest;

import com.emazon.ms_report.ConsUtils;
import com.emazon.ms_report.TestCreationUtils;
import com.emazon.ms_report.infra.security.model.CustomUserDetails;
import com.emazon.ms_report.infra.security.utils.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ReportControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void Should_SaveReport_When_ValidPayload() throws Exception {
        mockMvc.perform(post(ConsUtils.BASIC_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(TestCreationUtils.createReportReqDTO()))
                        .header(ConsUtils.AUTHORIZATION, ConsUtils.BEARER + getClientToken()))
                .andExpect(status().isCreated());
    }

    private String getClientToken() {
        CustomUserDetails userDetail = new CustomUserDetails(ConsUtils.USERNAME,
                ConsUtils.PASSWORD,
                Set.of(new SimpleGrantedAuthority(ConsUtils.ROLE.concat(ConsUtils.CLIENT))),
                ConsUtils.LONG_1);
        return JwtUtils.createToken(new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities()));
    }
}