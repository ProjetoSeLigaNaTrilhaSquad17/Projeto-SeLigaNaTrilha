package com.unit17.seliganatrilha.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@Getter
@Setter
@EnableWebSecurity
@ConfigurationProperties(prefix = "security.config")
public class WebSecurityConfig {
    public static String PREFIX;
    public static String KEY;
    public static long EXPIRATION;

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception {
        http
                .httpBasic()
                .and()
                .addFilterAfter(new JWTFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST,"/usuario").permitAll()
                .antMatchers(HttpMethod.GET, "/usuario").hasAnyRole("USER","ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable();

        return http.build();
    }



}
