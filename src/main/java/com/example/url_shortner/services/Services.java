package com.example.url_shortner.services;


import com.example.url_shortner.store.*;

import java.net.URI;

import org.springframework.stereotype.Service;

import com.example.url_shortner.log.Log;
import com.example.url_shortner.schema.SetKey;

@Service 
public class Services {
    
    private Store store;

    public Services (Store store) {
        logMessage = new Log();
        this.store = store;
    }

    public record Result(String value,int num) {}

    public int RegisterKey (SetKey request) {
        if (request.GetKey() == null) {
            logMessage.WriteLogMessage("the key is null , please initialize the key");
            return -1;
        }
        
        if (request.GetUrl() == null) {
            logMessage.WriteLogMessage("the url is null , please initialize the url");
            return -1;
        }

        if (URI.create(request.GetUrl()).getScheme() == null && URI.create(request.GetUrl()).getHost() == null) {
            logMessage.WriteLogMessage("the url schema is not valid, please enter a valid url");
            return -2;
        }

        store.storeData(request.GetKey(), request.GetUrl());

        return 1; 

    };

    public Result FindKey (String key) {
        
        String value = store.getData(key);

        if (value == null) {
            logMessage.WriteLogMessage("the value of this key is null");
            return new Result (null,-1);
        }
        
        return new Result(value, 1);

    }

    private final Log logMessage;    

}
