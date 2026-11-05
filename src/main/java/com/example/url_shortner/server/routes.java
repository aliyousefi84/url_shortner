package com.example.url_shortner.server;

import org.springframework.web.bind.annotation.RestController;

import com.example.url_shortner.schema.HealthCheck;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController 
@RequestMapping ("/api/v1")
public class routes {
    
    @GetMapping("/health")
    public ResponseEntity<HealthCheck> healthCheck () {
        HealthCheck hc = new HealthCheck("ok", "server is up");
        return ResponseEntity
               .ok()
               .body(hc);
    }

    
    
    
}
