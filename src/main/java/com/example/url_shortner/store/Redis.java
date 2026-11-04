package com.example.url_shortner.store;


import redis.clients.jedis.JedisPooled;

public class Redis extends Store {

    public Redis () {
        super();
        jedis = new JedisPooled("localhost" , 6379);
    
    }


    public int storeData (String url , String value) {

        jedis.set(value,url);
        
        return 1;
    }

    public String getData (String value) {
        return jedis.get(value);
    }

    
    private final JedisPooled jedis;
    
}
