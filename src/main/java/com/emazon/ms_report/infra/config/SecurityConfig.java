package com.emazon.ms_report.infra.config;

import com.emazon.ms_report.infra.security.entrypoint.CustomBasicAuthenticationEntryPoint;
import com.emazon.ms_report.infra.security.entrypoint.CustomJWTEntryPoint;
import com.emazon.ms_report.infra.security.filter.JwtValidatorFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    private final CustomBasicAuthenticationEntryPoint customBasicAuthenticationEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, CustomJWTEntryPoint jwtEntryPoint) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .httpBasic(httpBasic -> httpBasic.authenticationEntryPoint(customBasicAuthenticationEntryPoint))
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll();

                auth.anyRequest().denyAll();
            });

        http.anonymous(AbstractHttpConfigurer::disable);
        http.addFilterBefore(new JwtValidatorFilter(jwtEntryPoint), BasicAuthenticationFilter.class);

        return http.build();
    }
}
