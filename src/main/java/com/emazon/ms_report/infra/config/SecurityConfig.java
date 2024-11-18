package com.emazon.ms_report.infra.config;

import com.emazon.ms_report.ConsUtils;
import com.emazon.ms_report.infra.security.entrypoint.CustomBasicAuthenticationEntryPoint;
import com.emazon.ms_report.infra.security.entrypoint.CustomJWTEntryPoint;
import com.emazon.ms_report.infra.security.filter.JwtValidatorFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    private final CustomBasicAuthenticationEntryPoint customBasicAuthenticationEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, CustomJWTEntryPoint jwtEntryPoint) throws Exception {
        http
            .cors(cors -> cors.configurationSource(apiConfigurationSource()))
            .csrf(AbstractHttpConfigurer::disable)
            .httpBasic(httpBasic -> httpBasic.authenticationEntryPoint(customBasicAuthenticationEntryPoint))
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers(HttpMethod.POST, ConsUtils.BASIC_URL).hasRole(ConsUtils.CLIENT);
                auth.requestMatchers(ConsUtils.SWAGGER_URL, ConsUtils.SWAGGER_DOCS_URL).permitAll();

                auth.anyRequest().denyAll();
            });

        http.anonymous(AbstractHttpConfigurer::disable);
        http.addFilterBefore(new JwtValidatorFilter(jwtEntryPoint), BasicAuthenticationFilter.class);

        return http.build();
    }

    CorsConfigurationSource apiConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of(ConsUtils.FRONT_URL));
        configuration.setAllowedMethods(List.of(ConsUtils.GET, ConsUtils.POST, ConsUtils.PUT, ConsUtils.DELETE));
        configuration.setAllowedHeaders(List.of(ConsUtils.AUTHORIZATION, ConsUtils.CONTENT_TYPE, ConsUtils.REQUESTED_WITH));
        configuration.setExposedHeaders(List.of(ConsUtils.AUTHORIZATION));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(ConsUtils.MATCH_ALL_URL, configuration);
        return source;
    }
}
