package com.example.url_shortner.store;


import redis.clients.jedis.JedisPooled;

public class Redis extends Store {

    public Redis () {
        super();
        jedis = new JedisPooled("localhost" , 6379);
    
    }


    public int storeData (String url , String key) {

        jedis.set(key,url);
        
        return 1;
    }

    public String getData (String key) {
        return jedis.get(key);
    }

    public int delData (String key) {
        jedis.del(key);
        return 1;
    }

    
    private final JedisPooled jedis;
    
}
