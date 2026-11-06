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
        logMessage.WriteLogMessage("set key:%s to the value:%s" , key, url);
        return 1;
    }

    @Override public String getData (String key) {
        String value = jedis.get(key);
        logMessage.WriteLogMessage("get data from the key:%s" , key);
        return value;
    }

    @Override public int delData (String key) {
        jedis.del(key);
        logMessage.WriteLogMessage("deleting the key:%s",key);
        return 1;
    }

    
    private final JedisPooled jedis;
    
}
