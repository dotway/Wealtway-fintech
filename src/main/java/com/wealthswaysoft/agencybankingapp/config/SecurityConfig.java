package com.wealthswaysoft.agencybankingapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf ->csrf.disable() )
                .authorizeHttpRequests(authorize ->
                        authorize.requestMatchers(HttpMethod.POST, "api/user")
                                .permitAll()
                                .requestMatchers(HttpMethod.GET, "api/user/nameEnquiry").permitAll()
                                .requestMatchers(HttpMethod.GET, "api/user/balanceEnquiry").permitAll()
                                .requestMatchers(HttpMethod.POST, "api/user/transfer").permitAll()
                                .requestMatchers(HttpMethod.POST, "api/user/credit").permitAll()
                                .requestMatchers(HttpMethod.POST, "api/user/debit").permitAll()
                                .requestMatchers(HttpMethod.GET, "bankStatement").permitAll()
                                .anyRequest().authenticated()

                );
   httpSecurity.sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

   return httpSecurity.build();
    }


}

