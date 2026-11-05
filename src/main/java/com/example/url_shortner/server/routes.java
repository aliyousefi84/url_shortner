package com.example.url_shortner.server;

import org.springframework.web.bind.annotation.RestController;

import com.example.url_shortner.schema.HealthCheck;
import com.example.url_shortner.schema.SetKey;
import com.example.url_shortner.services.Services;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;





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

    @PostMapping("/setkey")
    public ResponseEntity<?> SetKey(@RequestBody SetKey request) {
        
        svc.RegisterKey(request);

        return ResponseEntity.ok(Map.of("status", "OK"));
        
    }
    
    @GetMapping("/search/{key}")
    public String getMethodName(@PathVariable String param) {
        String url = svc.FindKey(param);

        

        return new String();
    }
    

    private Services svc;
    
    
}
