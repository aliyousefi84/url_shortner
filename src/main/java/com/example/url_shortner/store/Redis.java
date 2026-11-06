package com.example.url_shortner.store;



import org.springframework.stereotype.Repository;
import com.example.url_shortner.log.*;
import redis.clients.jedis.JedisPooled;

@Repository 
public class Redis extends Store {

    public Redis () {
        super();
        logMessage = new Log();
        jedis = new JedisPooled("localhost" , 6379);
        if (jedis == null) {
            logMessage.WriteLogMessage("unable to connect redis server server");
        }
        logMessage.WriteLogMessage("connected to the server successfuly");

    }


    @Override public int storeData (String url , String key) {

        jedis.set(url,key);
        
        return 1;
    }

    @Override public String getData (String key) {
        String value = jedis.get(key);

        return value;
    }

    @Override public int delData (String key) {
        jedis.del(key);
        return 1;
    }

    
    private final JedisPooled jedis;
    
}
