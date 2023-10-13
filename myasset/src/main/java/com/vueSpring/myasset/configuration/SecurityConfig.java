package com.vueSpring.myasset.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector)
            throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF ºñÈ°¼ºÈ­ (REST API »ç¿ë ½Ã)
                .authorizeRequests((authz) -> authz.anyRequest().permitAll()
                // .and().formLogin()
                // .loginPage("/login") // 로그인 페이지 경로
                // .defaultSuccessURL("/home") // 로그인 성공 후 리다이렉트 경로
                // .permitAll()
                // .and().logout().permitAll()
                );
        return http.build();
    }
}
