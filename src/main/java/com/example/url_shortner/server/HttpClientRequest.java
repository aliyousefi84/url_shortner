package com.example.url_shortner.server;



import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

public class HttpClientRequest {

    private final RestClient client = RestClient.builder()
        .build();
            
            
    public ResponseEntity<String> getPage (String url) {
        System.out.println(url);
        String page = client.get().uri(URI.create(url)).retrieve().body(String.class);
        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(page);
    };
}
