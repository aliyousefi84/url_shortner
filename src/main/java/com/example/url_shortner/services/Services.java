package com.example.url_shortner.services;


import com.example.url_shortner.store.*;

import org.springframework.stereotype.Service;

import com.example.url_shortner.schema.SetKey;

@Service 
public class Services {
    
    private Store store;

    public Services (Store store) {
        this.store = store;
    }

    public int RegisterKey (SetKey request) {
        // TODO : Check URL , then store
        store.storeData(request.GetKey(), request.GetKey());

        return 1; 

    };

    public String FindKey (String key) {
        // TODO: Check key exist
        return store.getData(key);

    }

    

}
