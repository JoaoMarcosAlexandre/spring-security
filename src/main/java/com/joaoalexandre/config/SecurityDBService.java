package com.joaoalexandre.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

import static org.springframework.security.config.Customizer.withDefaults;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityDBService extends WebSecurityConfiguration {
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> {
            try {
                requests
                        .requestMatchers("/").permitAll()
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        .requestMatchers("/managers").hasAnyRole("MANAGERS")
                        .requestMatchers("/users").hasAnyRole("USERS", "MANAGERS")
                        .anyRequest().authenticated().and().httpBasic(withDefaults());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

}