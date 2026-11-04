package com.example.url_shortner.handlers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;


@RestController 
public class handlers {
    
    @GetMapping("test1")
    public String getMethodName() {
        return "test api1";
    }

    @GetMapping ("test2")
    public String method (@RequestHeader("User-Agent") String userAgent) {
        return  "test api2" + userAgent;
    }

    @PostMapping ("test3")
    public String post_method (@RequestBody String person) {
        return "your data is " + person;
    }
    
}
