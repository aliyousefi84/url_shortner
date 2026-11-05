package com.example.url_shortner.store;


import org.springframework.stereotype.Repository;

import redis.clients.jedis.JedisPooled;

@Repository 
public class Redis extends Store {

    public Redis () {
        super();
        jedis = new JedisPooled("localhost" , 6379);
    
    }


    @Override public int storeData (String url , String key) {

        jedis.set(key,url);
        
        return 1;
    }

    @Override public String getData (String key) {
        return jedis.get(key);
    }

    @Override public int delData (String key) {
        jedis.del(key);
        return 1;
    }

    
    private final JedisPooled jedis;
    
}
