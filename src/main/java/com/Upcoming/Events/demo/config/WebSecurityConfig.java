package com.Upcoming.Events.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.Upcoming.Events.demo.services.SecurityUserDetailsService;


@ComponentScan 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    MyBasicAuthenticationEntryPoint authenticationEntryPoint;

    private SecurityUserDetailsService service;

    public WebSecurityConfig(SecurityUserDetailsService service) {
        this.service = service;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
     http
      .cors()
      .and()
      .headers(header -> header.frameOptions().sameOrigin())
      .csrf(csrf -> csrf.disable())
      .formLogin(form-> form.disable())
      .logout(logout -> logout
                        .logoutUrl("/api/logout")
                        .deleteCookies("JSESSIONID"))   
      .authorizeRequests((auth) -> auth
                        .antMatchers("/api/register").permitAll()
                        .antMatchers( "/api/events").hasRole("ADMIN")
                        // .antMatchers( "/api/register/**").hasRole("USER")
                        .antMatchers( "/api/login").hasAnyRole("ADMIN", "USER")
                        .anyRequest().permitAll())
                .userDetailsService(service)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .httpBasic(basic -> basic.authenticationEntryPoint(authenticationEntryPoint));
                // .httpBasic(Customizer.withDefaults());
                return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
