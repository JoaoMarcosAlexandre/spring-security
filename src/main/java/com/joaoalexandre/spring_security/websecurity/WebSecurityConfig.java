package com.joaoalexandre.spring_security.websecurity;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests
                .dispatcherTypeMatchers(HttpMethod.valueOf("/")).permitAll()
                .dispatcherTypeMatchers(HttpMethod.POST, DispatcherType.valueOf("/login")).permitAll()
                .dispatcherTypeMatchers(HttpMethod.valueOf("/managers")).hasAnyRole("MANAGERS")
                .dispatcherTypeMatchers(HttpMethod.valueOf("/users")).hasAnyRole("USERS", "MANAGERS")
                .anyRequest().authenticated());
    }

}