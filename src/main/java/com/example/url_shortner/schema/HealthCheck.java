package com.example.url_shortner.schema;

public class HealthCheck {
    
    public HealthCheck (String status,String message) {
        this.status = status;
        this.message = message;
    }   

    private String status;

    private String message;

    public String getStatus () {return this.status;}

    public String getMessage () {return this.message;}



}
