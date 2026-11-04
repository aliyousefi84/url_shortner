package com.example.url_shortner.server;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController 
public class routes {
    
    @GetMapping("health")
    public String getMethodName() {
        return "test api1";
    }

    
    
}
