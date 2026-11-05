package com.example.url_shortner.server;



import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

public class HttpClientRequest {

    private final RestClient client = RestClient.builder()   
        .build();
            
            
    public ResponseEntity<String> getPage (String url) {
        String page = client.get().uri(url).retrieve().body(String.class);
        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(page);
    };
}
