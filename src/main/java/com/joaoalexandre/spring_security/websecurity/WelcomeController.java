package com.joaoalexandre.spring_security.websecurity;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    public String welcome(){
        return "Welcome to Spring Boot web API";
    }

    @GetMapping("/users")
    @PreAuthorize("hashAnyRole('managers','users')")
    public String users(){
        return "Authorized user";
    }
    @GetMapping("/managers")
    @PreAuthorize("hashAnyRole('managers')")
    public String manager(){
        return "Authorized manager";
    }
}
